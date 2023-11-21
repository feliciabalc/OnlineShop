package DB_Repo;

import Entities.Articles;
import Entities.Cart;
import Entities.Specifications;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SpecificationsRepoDB {
    private String connectionString;
    private String username;
    private String password;

    public SpecificationsRepoDB(String connectionString, String username, String password) {
        this.connectionString = connectionString;
        this.username = username;
        this.password = password;
    }

    public void saveIntoDB(List<Specifications> specification) {
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Specifications (Id, Size,Color,Quantity, Availability) VALUES (?, ?, ?, ?, ?)")) {

            for (Specifications specification1 : specification) {
                preparedStatement.setInt(1, specification1.getId());
                preparedStatement.setString(2, specification1.getSize().toString());
                preparedStatement.setString(3, specification1.getColor());
                preparedStatement.setDouble(4, specification1.getQuantity());
                preparedStatement.setBoolean(5, specification1.getAvailability());



                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Specifications createSpecificationsFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("Id");
        String[] size = new String[]{resultSet.getString("Size")};
        String color = resultSet.getString("Color");
        double quantity = resultSet.getDouble("Quantity");
        boolean availability = resultSet.getBoolean("Availability");

        return new Specifications(id, size,color,quantity,availability);
    }

    public List<Specifications> loadFromDB() {
        List<Specifications> result = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             Statement statement = connection.createStatement()) {

            String sql = "SELECT * FROM Specifications";
            try (ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    result.add(createSpecificationsFromResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception properly
        }
        return result;
    }


    public Specifications findById(int Id) {

        List<Specifications> allSpecifications = loadFromDB();
        Specifications foundItem = null;
        for (Specifications item : allSpecifications) {
            if (item.getId() == Id)
                foundItem = item;

        }

        return foundItem;
    }

    public void delete(int Id) {
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Specifications WHERE Id = ?")) {

            preparedStatement.setInt(1, Id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public List<Specifications> filterBySize(String size) {
        List<Specifications> result = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Specifications WHERE Size = ?")) {

            preparedStatement.setString(1, size);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    result.add(createSpecificationsFromResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Specifications> filterByColor(String color) {
        List<Specifications> result = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Specifications WHERE Color = ?")) {

            preparedStatement.setString(1, color);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    result.add(createSpecificationsFromResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    public void updateQuantity(int Id, double newQuantity) {
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Specifications SET Quantity = ? WHERE Id = ?")) {

            preparedStatement.setDouble(1, newQuantity);
            preparedStatement.setInt(2, Id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
