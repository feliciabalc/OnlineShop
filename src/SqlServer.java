import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlServer {

    public static void main(String[] args) {
        // JDBC URL, username, and password of SQL Server
        String jdbcUrl = "jdbc:mysql://localhost:3306/onlineshop";
        String username = "shop_user";
        String password = "shop_pass";

        // Establish a connection
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("Connected to the SQL Server database");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
