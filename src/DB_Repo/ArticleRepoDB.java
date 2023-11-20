package DB_Repo;

import java.lang.reflect.Type;
import java.sql.*;
import java.util.List;
import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import Entities.Articles;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.Objects;


public class ArticleRepoDB{
    private  String connectionString;
    private  String username;
    private  String password ;


    public ArticleRepoDB(String connectionString, String username, String password) {
        this.connectionString = connectionString;
        this.username = username;
        this.password = password;
    }

    //////////////trebuie adaugat pt fiecare specification.....dau ca arametru specification id???
    public void saveIntoDB(List<Articles> articles) {
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Articles (Id,Name, Brand, Material, Type, Price) VALUES (?, ?, ?, ?, ?,?)")) {

            for (Articles article : articles) {
                preparedStatement.setInt(1, article.getId());
                preparedStatement.setString(2, article.getName());
                preparedStatement.setString(3, article.getBrand());
                preparedStatement.setString(4, article.getMaterial());
                preparedStatement.setString(5, article.getType());
                preparedStatement.setDouble(6, article.getPrice());

                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    private Articles createArticleFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("Id");
        String name = resultSet.getString("Name");
        String brand = resultSet.getString("Brand");
        String material = resultSet.getString("Material");
        String type = resultSet.getString("Type");
        float price = resultSet.getFloat("Price");

        return new Articles(id, name, brand, material, type, price);
    }



    public List<Articles> loadFromDB(List<Articles> articles) {
        List<Articles> result = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             Statement statement = connection.createStatement()) {

            String sql = "SELECT * FROM Articles";
            try (ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    result.add(createArticleFromResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception properly
        }
        return result;
    }


}
