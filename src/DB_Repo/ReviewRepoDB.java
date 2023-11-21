package DB_Repo;

import Entities.Articles;
import Entities.Cart;
import Entities.Review;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewRepoDB {
    private String connectionString;
    private String username;
    private String password;

    public ReviewRepoDB(String connectionString, String username, String password) {
        this.connectionString = connectionString;
        this.username = username;
        this.password = password;
    }

    public void saveIntoDB(List<Review> reviews) {
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Review (Id, Stars, Comment,Date) VALUES (?, ?, ?, ?)")) {

            for (Review review : reviews) {
                preparedStatement.setInt(1, review.getId());
                preparedStatement.setString(2, review.getStars());
                preparedStatement.setString(3, review.getComment());
                preparedStatement.setString(4, review.getDate());

                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Review createReviewFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("Id");
        String stars = resultSet.getString("Stars");
        String comment = resultSet.getString("Comment");
        String date = resultSet.getString("Date");

        return new Review(id, stars,comment,date);
    }

    public List<Review> loadFromDB() {
        List<Review> result = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             Statement statement = connection.createStatement()) {

            String sql = "SELECT * FROM Review";
            try (ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    result.add(createReviewFromResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception properly
        }
        return result;
    }

    public Review findById(int Id) {

        List<Review> reviewList = loadFromDB();
        Review foundItem = null;
        for (Review item : reviewList) {
            if (item.getId() == Id)
                foundItem = item;

        }

        return foundItem;
    }

    public void delete(int Id) {
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Review WHERE Id = ?")) {

            preparedStatement.setInt(1, Id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public void updateComment(int Id, String newComment) {
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Review SET Comment = ? WHERE Id = ?")) {

            preparedStatement.setString(1, newComment);
            preparedStatement.setInt(2, Id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStars(int Id, String stars) {
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Review SET Stars = ? WHERE Id = ?")) {

            preparedStatement.setString(1, stars);
            preparedStatement.setInt(2, Id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Review> filterByStars(String stars) {
        List<Review> result = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Review WHERE Stars = ?")) {

            preparedStatement.setString(1, stars);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    result.add(createReviewFromResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


}
