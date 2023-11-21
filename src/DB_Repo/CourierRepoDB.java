package DB_Repo;

import Entities.Articles;
import Entities.Cart;
import Entities.Courier;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourierRepoDB {
    private String connectionString;
    private String username;
    private String password;

    public CourierRepoDB(String connectionString, String username, String password) {
        this.connectionString = connectionString;
        this.username = username;
        this.password = password;
    }

    public void saveIntoDB(List<Courier> couriers) {
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Cart (Id, Name,Salary,Telefon) VALUES (?, ?,?,?)")) {

            for (Courier courier : couriers) {
                preparedStatement.setInt(1, courier.getId());
                preparedStatement.setString(2, courier.getName());
                preparedStatement.setString(3, courier.getSalary());
                preparedStatement.setDouble(4, courier.getTelefon());


                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Courier createCourierFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("Id");
        String name = resultSet.getString("Name");
        String salary = resultSet.getString("Salary");
        double telefon= resultSet.getDouble("Telefon");


        return new Courier(id,  name,salary,telefon);
    }

    public List<Courier> loadFromDB() {
        List<Courier> result = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             Statement statement = connection.createStatement()) {

            String sql = "SELECT * FROM Courier";
            try (ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    result.add(createCourierFromResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception properly
        }
        return result;
    }

}
