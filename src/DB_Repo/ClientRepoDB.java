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

                if(client.getOrders() == null)
                    preparedStatement.setNull(5, Types.INTEGER);
                else
                    preparedStatement.setInt(5, client.getOrders().get(0).getId());

                if(client.getReview() == null)
                preparedStatement.setNull(6, Types.INTEGER);
                else
                preparedStatement.setInt(6, client.getReview().get(0).getId());

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

    public void addOrder(int orderId, int clientId){
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Client SET Orders_id = ? WHERE Id =?")) {

            preparedStatement.setInt(1, orderId);
            preparedStatement.setInt(2, clientId);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void addReview(int revId, int clientId){
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Client SET Review_id = ? WHERE Id =?")) {

            preparedStatement.setInt(1, revId);
            preparedStatement.setInt(2, clientId);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void addCart(int cartId, int clientId){
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Client SET Cart_id = ? WHERE Id =?")) {

            preparedStatement.setInt(1, cartId);
            preparedStatement.setInt(2, clientId);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public int getOrderId(int clientId) {
        int Id = -1;

        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT Orders_id FROM Client WHERE Id = ?")) {

            preparedStatement.setInt(1, clientId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Id = resultSet.getInt("Orders_id");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Id;
    }


    public int getRevId(int clientId) {
        int Id = -1;

        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT Review_id FROM Client WHERE Id = ?")) {

            preparedStatement.setInt(1, clientId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Id = resultSet.getInt("Review_id");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Id;
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
