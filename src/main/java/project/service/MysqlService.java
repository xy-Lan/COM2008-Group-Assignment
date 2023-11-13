package project.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlService {

    private static final String JDBC_URL = "jdbc:mysql://stusql.dcs.shef.ac.uk/team043";
    private static final String USERNAME = "team015";
    private static final String PASSWORD = "eSh7Shahk";

    private Connection connection;

    public MysqlService() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load MySQL JDBC driver.");
        }

        connect();
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connect();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to check the connection status.");
        }

        return connection;
    }

    private void connect() {
        try {
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database.");
        }
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to close the database connection.");
        }
    }

    static boolean login(String username, String password) {

        

        return false;
    }
}
