package DAO;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseHelper {

    private final ConnectionProvider connectionProvider;

    // Constructor
    public DatabaseHelper(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    // Non-static method to get connection
    public Connection getConnection() {
        try {
            return connectionProvider.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
