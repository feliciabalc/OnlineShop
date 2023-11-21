package DB_Repo;

import Entities.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WarehouseRepoDB {
    private String connectionString;
    private String username;
    private String password;

    public WarehouseRepoDB(String connectionString, String username, String password) {
        this.connectionString = connectionString;
        this.username = username;
        this.password = password;
    }

    public void saveIntoDB(List<Warehouse> warehouses) {
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Warehouse(Id, Name, Address, Articles_id, Suppliers_id, Courier_id, Employee_id) VALUES (?, ?, ?, ?, ?, ?,?)")) {

            for (Warehouse warehouse : warehouses) {
                preparedStatement.setInt(1, warehouse.getId());
                preparedStatement.setString(2, warehouse.getName());
                preparedStatement.setString(3, warehouse.getAddress());

                String articlesIdsString = "";
                for (Articles articles : warehouse.getArticles()) {
                    articlesIdsString += articles.getId() + ",";
                }
                // Remove the trailing comma
                if (!articlesIdsString.isEmpty()) {
                    articlesIdsString = articlesIdsString.substring(0, articlesIdsString.length() - 1);
                }
                if (!articlesIdsString.isEmpty()) {
                    preparedStatement.setInt(4, Integer.parseInt(articlesIdsString));
                } else {
                    preparedStatement.setNull(4, Types.INTEGER);
                }


                String suppliersIdsString = "";
                for (Suppliers suppliers : warehouse.getSuppliers()) {
                    suppliersIdsString += suppliers.getId() + ",";
                }
                // Remove the trailing comma
                if (!suppliersIdsString.isEmpty()) {
                    suppliersIdsString = suppliersIdsString.substring(0, suppliersIdsString.length() - 1);
                }
                if (!suppliersIdsString.isEmpty()) {
                    preparedStatement.setInt(5, Integer.parseInt(suppliersIdsString));
                } else {
                    preparedStatement.setNull(5, Types.INTEGER);
                }

                String couriersString = "";
                for (Courier courier1 : warehouse.getCouriers()) {
                    couriersString += courier1.getId() + ",";
                }
                // Remove the trailing comma
                if (!couriersString.isEmpty()) {
                    couriersString = couriersString.substring(0, couriersString.length() - 1);
                }
                if (!couriersString.isEmpty()) {
                    preparedStatement.setInt(6, Integer.parseInt(couriersString));
                } else {
                    preparedStatement.setNull(6, Types.INTEGER);
                }

                String employeesIdsString = "";
                for (Employee employee1 : warehouse.getEmployees()) {
                    employeesIdsString += employee1.getId() + ",";
                }
                // Remove the trailing comma
                if (!employeesIdsString.isEmpty()) {
                    employeesIdsString = employeesIdsString.substring(0, employeesIdsString.length() - 1);
                }
                if (!employeesIdsString.isEmpty()) {
                    preparedStatement.setInt(7, Integer.parseInt(employeesIdsString));
                } else {
                    preparedStatement.setNull(7, Types.INTEGER);
                }

                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Warehouse createWarehouseFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("Id");
        String name = resultSet.getString("Name");
        String address = resultSet.getString("Address");


        return new Warehouse(id, name, address);
    }

    public List<Warehouse> loadFromDB() {
        List<Warehouse> result = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             Statement statement = connection.createStatement()) {

            String sql = "SELECT * FROM Warehouse";
            try (ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    result.add(createWarehouseFromResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception properly
        }
        return result;
    }

}
