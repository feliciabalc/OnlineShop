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

                if(warehouse.getArticles() == null)
                    preparedStatement.setNull(4, Types.INTEGER);
                else
                    preparedStatement.setInt(4, warehouse.getArticles().get(0).getId());


                if(warehouse.getSuppliers() == null)
                    preparedStatement.setNull(5, Types.INTEGER);
                else
                    preparedStatement.setInt(5, warehouse.getSuppliers().get(0).getId());

                if(warehouse.getCouriers() == null)
                    preparedStatement.setNull(5, Types.INTEGER);
                else
                    preparedStatement.setInt(5, warehouse.getCouriers().get(0).getId());

                if(warehouse.getEmployees() == null)
                    preparedStatement.setNull(6, Types.INTEGER);
                else
                    preparedStatement.setInt(6, warehouse.getEmployees().get(0).getId());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Warehouse createWarehouseFromResultSet(ResultSet resultSet) throws SQLException {
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


    public Warehouse findById(int Id) {

        List<Warehouse> warehouseList = loadFromDB();
        Warehouse foundItem = null;
        for (Warehouse item : warehouseList) {
            if (item.getId() == Id)
                foundItem = item;

        }

        return foundItem;
    }

    public void delete(int Id) {
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Warehouse WHERE Id = ?")) {

            preparedStatement.setInt(1, Id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public List<Warehouse> filterByAddress(String address) {
        List<Warehouse> result = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Warehouse WHERE Address = ?")) {

            preparedStatement.setString(1, address);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    result.add(createWarehouseFromResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    public void addArticle(int articleId, int warehouseId){
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Warehouse SET Articles_id = ? WHERE Id =?")) {

            preparedStatement.setInt(1, articleId);
            preparedStatement.setInt(2, warehouseId);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void addSupplier(int sId, int warehouseId){
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Warehouse SET Suppliers_id = ? WHERE Id =?")) {

            preparedStatement.setInt(1, sId);
            preparedStatement.setInt(2, warehouseId);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCourier(int cId, int warehouseId){
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Warehouse SET Courier_id = ? WHERE Id =?")) {

            preparedStatement.setInt(1, cId);
            preparedStatement.setInt(2, warehouseId);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addEmployee(int eId, int warehouseId){
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Warehouse SET Employee_id = ? WHERE Id =?")) {

            preparedStatement.setInt(1, eId);
            preparedStatement.setInt(2, warehouseId);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getArticleId(int warehouseId) {
        int Id = -1;

        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT Articles_id FROM Warehouse WHERE Id = ?")) {

            preparedStatement.setInt(1, warehouseId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Id = resultSet.getInt("Articles_id");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Id;
    }

    public int getSupplierId(int warehouseId) {
        int Id = -1;

        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT Suppliers_id FROM Warehouse WHERE Id = ?")) {

            preparedStatement.setInt(1, warehouseId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Id = resultSet.getInt("Suppliers_id");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Id;
    }

    public int getCourierId(int warehouseId) {
        int Id = -1;

        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT Courier_id FROM Warehouse WHERE Id = ?")) {

            preparedStatement.setInt(1, warehouseId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Id = resultSet.getInt("Courier_id");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Id;
    }


    public int getEmployeeId(int warehouseId) {
        int Id = -1;

        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT Employee_id FROM Warehouse WHERE Id = ?")) {

            preparedStatement.setInt(1, warehouseId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Id = resultSet.getInt("Employee_id");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Id;
    }





}
