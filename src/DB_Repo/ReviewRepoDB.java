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

    private Review createReviewFromResultSet(ResultSet resultSet) throws SQLException {
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

}
