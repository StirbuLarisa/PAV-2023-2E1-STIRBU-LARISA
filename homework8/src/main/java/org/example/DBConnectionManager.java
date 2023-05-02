package org.example;
import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class DBConnectionManager {

    private static final String URL = "jdbc:postgresql://localhost:5432/Lab8Java";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "Pass4Postgres1!";
    private static final int MAX_TOTAL_CONNECTIONS = 10;
    private static final int MAX_IDLE_CONNECTIONS = 5;

    private static DBConnectionManager instance = null;
    private BasicDataSource dataSource;

    private Connection connection = null;

    private DBConnectionManager() {
        try {
            dataSource = new BasicDataSource();
            dataSource.setDriverClassName("org.postgresql.Driver");
            dataSource.setUrl(URL);
            dataSource.setUsername(USERNAME);
            dataSource.setPassword(PASSWORD);
            dataSource.setMaxTotal(MAX_TOTAL_CONNECTIONS);
            dataSource.setMaxIdle(MAX_IDLE_CONNECTIONS);
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            System.err.println(e);
        }

    }

    public static DBConnectionManager getInstance() {
        if (instance == null) {
            instance = new DBConnectionManager();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return connection;
    }
}