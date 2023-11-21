package DB_Repo;

import Entities.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientRepoDB {
    private String connectionString;
    private String username;
    private String password;

    public ClientRepoDB(String connectionString, String username, String password) {
        this.connectionString = connectionString;
        this.username = username;
        this.password = password;
    }

    public void saveIntoDB(List<Client> clients) {
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Client (Id, Name, Address, Telefon, Orders_id, Review_id, Cart_id) VALUES (?, ?, ?, ?)")) {

            for (Client client : clients) {
                preparedStatement.setInt(1, client.getId());
                preparedStatement.setString(2, client.getName());
                preparedStatement.setString(3, client.getAddress());
                preparedStatement.setDouble(4, client.getTelefon());

                String orderIdsString = "";
                for (Order order:client.getOrders()) {
                    orderIdsString+=order.getId();
                }
                // Remove the trailing comma
                if (!orderIdsString.isEmpty()) {
                    orderIdsString = orderIdsString.substring(0, orderIdsString.length() - 1);
                }
                if (!orderIdsString.isEmpty()) {
                    preparedStatement.setInt(5, Integer.parseInt(orderIdsString));
                } else {
                    preparedStatement.setNull(5, Types.INTEGER);
                }

                String reviewIdsString = "";
                for (Review review:client.getReview()) {
                    reviewIdsString+=review.getId();
                }
                // Remove the trailing comma
                if (!reviewIdsString.isEmpty()) {
                    reviewIdsString = reviewIdsString.substring(0, reviewIdsString.length() - 1);
                }
                if (!reviewIdsString.isEmpty()) {
                    preparedStatement.setInt(6, Integer.parseInt(reviewIdsString));
                } else {
                    preparedStatement.setNull(6, Types.INTEGER);
                }

                if (client.getCart()!= null) {
                    preparedStatement.setInt(7, client.getCart().getId());
                } else {
                    preparedStatement.setNull(7, Types.INTEGER);
                }


                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Client createClientFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("Id");
        String name = resultSet.getString("Name");
        String address = resultSet.getString("Address");
        double telefon = resultSet.getDouble("Telefon");

        Client client = new Client(id, name, address, telefon);
        // You may load related data like reviews, orders, or cart here if needed
        return client;
    }

    public List<Client> loadFromDB() {
        List<Client> result = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             Statement statement = connection.createStatement()) {

            String sql = "SELECT * FROM Client";
            try (ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    result.add(createClientFromResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception properly
        }
        return result;
    }



    public Client findById(int Id) {

        List<Client> allClients = loadFromDB();
        Client foundItem = null;
        for (Client item : allClients) {
            if (item.getId() == Id)
                foundItem = item;

        }

        return foundItem;
    }

    public void delete(int Id) {
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Client WHERE Id = ?")) {

            preparedStatement.setInt(1, Id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public void updateAddress(int Id, String address) {
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Client SET Address = ? WHERE Id = ?")) {

            preparedStatement.setString(1, address);
            preparedStatement.setInt(2, Id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Client> filterByName(String name) {
        List<Client> result = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Client WHERE Name = ?")) {

            preparedStatement.setString(1, name);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    result.add(createClientFromResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }



}
