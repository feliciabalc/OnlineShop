package DB_Repo;

import Entities.Articles;
import Entities.Cart;
import Entities.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepoDB {
    private String connectionString;
    private String username;
    private String password;

    public OrderRepoDB(String connectionString, String username, String password) {
        this.connectionString = connectionString;
        this.username = username;
        this.password = password;
    }

    public void saveIntoDB(List<Order> orders) {
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Order (Id, OrderNumber, TotalAmount,PaymentMethod,Address,Date) VALUES (?, ?, ?, ?, ?, ?)")) {

            for (Order order : orders) {
                preparedStatement.setInt(1, order.getId());
                preparedStatement.setDouble(2, order.getOrderNumber());
                preparedStatement.setFloat(3, order.getTotalAmount());
                preparedStatement.setString(4, order.getPaymentMethod());
                preparedStatement.setString(5, order.getAddress());
                preparedStatement.setString(6, order.getDate());



                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Order createOrderFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("Id");
        double orderNumber = resultSet.getDouble("OrderNumber");
        float totalAmount = resultSet.getFloat("TotalAmount");
        String paymentMethod = resultSet.getString("PaymentMethod");
        String address = resultSet.getString("Address");
        String date = resultSet.getString("Date");

        return new Order(id, orderNumber,totalAmount,paymentMethod,address,date);
    }

    public List<Order> loadFromDB() {
        List<Order> result = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             Statement statement = connection.createStatement()) {

            String sql = "SELECT * FROM Order";
            try (ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    result.add(createOrderFromResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception properly
        }
        return result;
    }
}


