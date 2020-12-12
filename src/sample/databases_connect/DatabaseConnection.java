package sample.databases_connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection() {
        String databaseName = "flip_db";
        String username = "postgres";
        String password = "nur26erb";
        String url = "jdbc:postgresql://localhost:5432/" + databaseName;

        try {
            databaseLink = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return databaseLink;
    }
}
