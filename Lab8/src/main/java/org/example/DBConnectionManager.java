package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {

    private static final String URL = "jdbc:postgresql://localhost:5432/Lab8Java";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "Pass4Postgres1!";

    private static DBConnectionManager instance = null;

    private Connection connection = null;

    private DBConnectionManager() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static DBConnectionManager getInstance() {
        if (instance == null) {
            instance = new DBConnectionManager();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
