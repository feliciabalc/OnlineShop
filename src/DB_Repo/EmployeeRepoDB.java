package DB_Repo;

import Entities.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepoDB {
    private String connectionString;
    private String username;
    private String password;

    public EmployeeRepoDB(String connectionString, String username, String password) {
        this.connectionString = connectionString;
        this.username = username;
        this.password = password;
    }

    public void saveIntoDB(List<Employee> employees) {
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Employee (Id, Name,Salary,Telefon,Orders_id) VALUES (?, ?, ?, ?, ?)")) {

            for (Employee employee : employees) {
                preparedStatement.setInt(1, employee.getId());
                preparedStatement.setString(2, employee.getName());
                preparedStatement.setString(3, employee.getSalary());
                preparedStatement.setDouble(4, employee.getTelefon());

                String ordersIdsString = "";
                for (Order orders : employee.getOrders()) {
                    ordersIdsString += orders.getId() + ",";
                }
                // Remove the trailing comma
                if (!ordersIdsString.isEmpty()) {
                    ordersIdsString = ordersIdsString.substring(0, ordersIdsString.length() - 1);
                }

                if (!ordersIdsString.isEmpty()) {
                    preparedStatement.setInt(5, Integer.parseInt(ordersIdsString));
                } else {
                    preparedStatement.setNull(5, Types.INTEGER);
                }

                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Employee createEmployeeFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("Id");
        String name = resultSet.getString("Name");
        String salary = resultSet.getString("Salary");
        double telefon= resultSet.getDouble("Telefon");

        return new Employee(id, name,salary,telefon);
    }

    public List<Employee> loadFromDB() {
        List<Employee> result = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             Statement statement = connection.createStatement()) {

            String sql = "SELECT * FROM Employee";
            try (ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    result.add(createEmployeeFromResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception properly
        }
        return result;
    }



    public Employee findById(int Id) {

        List<Employee> allEmployees = loadFromDB();
        Employee foundItem = null;
        for (Employee item : allEmployees) {
            if (item.getId() == Id)
                foundItem = item;

        }

        return foundItem;
    }

    public void delete(int Id) {
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Employee WHERE Id = ?")) {

            preparedStatement.setInt(1, Id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public void updateSalary(int Id, String salary) {
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Employee SET Salary = ? WHERE Id = ?")) {

            preparedStatement.setString(1, salary);
            preparedStatement.setInt(2, Id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void updateRole(int Id, String role) {
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Employee SET Role = ? WHERE Id = ?")) {

            preparedStatement.setString(1, role);
            preparedStatement.setInt(2, Id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Employee> filterByRole(String role) {
        List<Employee> result = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Employee WHERE Role = ?")) {

            preparedStatement.setString(1, role);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    result.add(createEmployeeFromResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}

