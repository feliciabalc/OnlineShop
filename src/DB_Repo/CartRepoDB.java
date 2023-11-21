package DB_Repo;

import Entities.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartRepoDB {
    private String connectionString;
    private String username;
    private String password;

    public CartRepoDB(String connectionString, String username, String password) {
        this.connectionString = connectionString;
        this.username = username;
        this.password = password;
    }
    public void saveIntoDB(List<Cart> carts) {
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Cart (Id, Quantity, Articles_id) VALUES (?, ?)")) {

            for (Cart cart : carts) {
                preparedStatement.setInt(1, cart.getId());
                preparedStatement.setDouble(2, cart.getQuantity());

                String articlesIdsString = "";
                for (Articles articles : cart.getArticles()) {
                    articlesIdsString += articles.getId() + ",";
                }
                // Remove the trailing comma
                if (!articlesIdsString.isEmpty()) {
                    articlesIdsString = articlesIdsString.substring(0, articlesIdsString.length() - 1);
                }
                System.out.println("Cart IDs: " + articlesIdsString);
                if (!articlesIdsString.isEmpty()) {
                    preparedStatement.setInt(3, Integer.parseInt(articlesIdsString));
                } else {
                    preparedStatement.setNull(3, Types.INTEGER);
                }

                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cart createCartFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("Id");
        double quantity = resultSet.getDouble("Quantity");

        return new Cart(id, quantity);
    }

    public List<Cart> loadFromDB() {
        List<Cart> result = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             Statement statement = connection.createStatement()) {

            String sql = "SELECT * FROM Cart";
            try (ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    result.add(createCartFromResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception properly
        }
        return result;
    }

    public Cart findById(int Id){
        List<Cart> allCart = loadFromDB();
        Cart foundItem = null;
        for(Cart item : allCart){
            if(item.getId() == Id)
                foundItem =item;

        }

        return foundItem;
    }

    public void delete(int Id) {
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Cart WHERE Id = ?")) {

            preparedStatement.setInt(1, Id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void updateQuantity(int Id, double Quantity) {
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Cart SET Quantity = ? WHERE Id = ?")) {

            preparedStatement.setDouble(1, Quantity);
            preparedStatement.setInt(2, Id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
