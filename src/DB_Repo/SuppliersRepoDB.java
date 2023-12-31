package DB_Repo;

import Entities.Articles;
import Entities.Cart;
import Entities.Suppliers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SuppliersRepoDB {
    private String connectionString;
    private String username;
    private String password;

    public SuppliersRepoDB(String connectionString, String username, String password) {
        this.connectionString = connectionString;
        this.username = username;
        this.password = password;
    }

    public void saveIntoDB(List<Suppliers> suppliers) {
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Suppliers (Id, Name, Telefon,ArticleType) VALUES (?, ?, ?, ?)")) {

            for (Suppliers supplier : suppliers) {
                preparedStatement.setInt(1, supplier.getId());
                preparedStatement.setString(2, supplier.getName());
                preparedStatement.setDouble(3, supplier.getTelefon());
                preparedStatement.setString(4, supplier.getArticleType());

                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Suppliers createSuppliersFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("Id");
        String name = resultSet.getString("Name");
        Double telefon = resultSet.getDouble("Telefon");
        String articleType = resultSet.getString("ArticleType");


        return new Suppliers(id, name,telefon,articleType);
    }

    public List<Suppliers> loadFromDB() {
        List<Suppliers> result = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             Statement statement = connection.createStatement()) {

            String sql = "SELECT * FROM Suppliers";
            try (ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    result.add(createSuppliersFromResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception properly
        }
        return result;
    }



    public Suppliers findById(int Id) {

        List<Suppliers> allSuppliers = loadFromDB();
        Suppliers foundItem = null;
        for (Suppliers item : allSuppliers) {
            if (item.getId() == Id)
                foundItem = item;

        }

        return foundItem;
    }

    public void delete(int Id) {
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Suppliers WHERE Id = ?")) {

            preparedStatement.setInt(1, Id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public List<Suppliers> filterByName(String name) {
        List<Suppliers> result = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Suppliers WHERE Name = ?")) {

            preparedStatement.setString(1, name);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    result.add(createSuppliersFromResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


}
