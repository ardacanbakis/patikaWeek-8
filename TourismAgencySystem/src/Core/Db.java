package Core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {
    private static Db instance = null;
    private Connection connection = null;
    private final String URL = "jdbc:postgresql://localhost:5432/TourismAgencyDatabase";
    private final String USER = "postgres";
    private final String PASSWORD = "postgres";

    private Db() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database Connection Successfully Established");
        } catch (SQLException e) {
            System.out.println("Error Connecting to Database: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static Connection getInstance() {
        try {
            if (instance == null || instance.getConnection().isClosed()) {
                instance = new Db();
            }
        } catch (SQLException e) {
            System.out.println("Database Connection Error: " + e.getMessage());
        }
        return instance.getConnection();
    }
}
