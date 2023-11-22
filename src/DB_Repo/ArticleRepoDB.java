package DB_Repo;

import java.lang.reflect.Array;
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
import Entities.Review;
import Entities.Specifications;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.Objects;


public class ArticleRepoDB {
    private String connectionString;
    private String username;
    private String password;


    public ArticleRepoDB(String connectionString, String username, String password) {
        this.connectionString = connectionString;
        this.username = username;
        this.password = password;
    }


    public void saveIntoDB(List<Articles> articles) {
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Articles (Id, Name, Brand, Material, Type, Price, Specification_id, Review_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {

            for (Articles article : articles) {
                preparedStatement.setInt(1, article.getId());
                preparedStatement.setString(2, article.getName());
                preparedStatement.setString(3, article.getBrand());
                preparedStatement.setString(4, article.getMaterial());
                preparedStatement.setString(5, article.getType());
                preparedStatement.setDouble(6, article.getPrice());
                if(article.getSpecifications() == null)
                    preparedStatement.setNull(7, Types.INTEGER);
                else
                    preparedStatement.setInt(7, article.getSpecifications().get(0).getId());

                if(article.getReviews() == null)
                    preparedStatement.setNull(8, Types.INTEGER);
                else
                    preparedStatement.setInt(8, article.getReviews().get(0).getId());


                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addSpecifications(int articleId, int specId){
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Articles SET Specification_id = ? WHERE Id =?")) {

            preparedStatement.setInt(1, specId);
            preparedStatement.setInt(2, articleId);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public void addReview(int articleId, int revId){
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Review SET Review_id = ? WHERE Id =?")) {

            preparedStatement.setInt(1, revId);
            preparedStatement.setInt(2, articleId);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public int getSpecificationId(int articleId) {
        int Id = -1;

        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT Specification_id FROM Articles WHERE Id = ?")) {

            preparedStatement.setInt(1, articleId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Id = resultSet.getInt("Specification_id");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Id;
    }

    public int getReviewId(int articleId) {
        int reviewId = -1;

        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT Review_id FROM Articles WHERE Id = ?")) {

            preparedStatement.setInt(1, articleId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    reviewId = resultSet.getInt("Review_id");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reviewId;
    }



    public Articles createArticleFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("Id");
        String name = resultSet.getString("Name");
        String brand = resultSet.getString("Brand");
        String material = resultSet.getString("Material");
        String type = resultSet.getString("Type");
        float price = resultSet.getFloat("Price");

        return new Articles(id, name, brand, material, type, price);
    }


    public List<Articles> loadFromDB() {
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
            e.printStackTrace();
        }
        return result;
    }


    //String specificationIdsString = "";
    //            for (Specifications specification : article.getSpecifications()) {
    //                specificationIdsString += specification.getId() + ",";
    //            }
    //            // Remove the trailing comma
    //            if (!specificationIdsString.isEmpty()) {
    //                specificationIdsString = specificationIdsString.substring(0, specificationIdsString.length() - 1);
    //            }
    //            System.out.println("Specification IDs: " + specificationIdsString);
    //            preparedStatement.setString(7, specificationIdsString);


    public Articles findById(int Id) {

        List<Articles> allArticles = loadFromDB();
        Articles foundItem = null;
        for (Articles item : allArticles) {
            if (item.getId() == Id)
                foundItem = item;

        }

        return foundItem;
    }

    public void delete(int Id) {
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Articles WHERE Id = ?")) {

            preparedStatement.setInt(1, Id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void update(int Id, Articles updatedArticle) {
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Articles SET Name = ?, Brand = ?, Material = ?, Type = ?, Price = ? WHERE Id = ?")) {

            preparedStatement.setString(1, updatedArticle.getName());
            preparedStatement.setString(2, updatedArticle.getBrand());
            preparedStatement.setString(3, updatedArticle.getMaterial());
            preparedStatement.setString(4, updatedArticle.getType());
            preparedStatement.setDouble(5, updatedArticle.getPrice());
            preparedStatement.setInt(6, Id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void updatePrice(int Id, double newPrice) {
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Articles SET Price = ? WHERE Id = ?")) {

            preparedStatement.setDouble(1, newPrice);
            preparedStatement.setInt(2, Id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public List<Articles> filterByBrand(String brand) {
        List<Articles> result = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Articles WHERE Brand = ?")) {

            preparedStatement.setString(1, brand);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    result.add(createArticleFromResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Articles> sortByPriceAsc() {
        List<Articles> result = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             Statement statement = connection.createStatement()) {

            String sql = "SELECT * FROM Articles ORDER BY Price ASC";
            try (ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    result.add(createArticleFromResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }




}