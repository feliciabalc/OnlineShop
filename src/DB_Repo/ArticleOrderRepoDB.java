package DB_Repo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ArticleOrderRepoDB {
    private String connectionString;
    private String username;
    private String password;

    public ArticleOrderRepoDB(String connectionString, String username, String password) {
        this.connectionString = connectionString;
        this.username = username;
        this.password = password;
    }

    public void saveIntoArticleOrder(List<Integer> articleIds, int orderId) {
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Article_order (ArticleId, OrderId) VALUES (?, ?)")) {

            for (int articleId : articleIds) {
                preparedStatement.setInt(1, articleId);
                preparedStatement.setInt(2, orderId);
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Integer> loadArticleIdsByOrderId(int orderId) {
        List<Integer> articleIds = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT ArticleId FROM article_order WHERE OrderId = ?")) {

            preparedStatement.setInt(1, orderId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int articleId = resultSet.getInt("ArticleId");
                    articleIds.add(articleId);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articleIds;
    }
}

