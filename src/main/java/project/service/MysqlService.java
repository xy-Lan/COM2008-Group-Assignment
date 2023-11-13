package project.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlService {

    private static final String JDBC_URL = "jdbc:mysql://stusql.dcs.shef.ac.uk/team015";
    private static final String USERNAME = "team015";
    private static final String PASSWORD = "eSh7Shahk";

    private static final MysqlService mySqlService = new MysqlService();

    public static MysqlService getInstance() {
        return mySqlService;
    }


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
            System.out.println("Connecting...");
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            System.out.println("Connected!");
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

    public ResultSet executeQuery(String query) {
        try {
            Connection connection = getConnection();

            String sql = query;
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                return preparedStatement.executeQuery();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean login(String username, String password) {

        Connection connection = getConnection();

        String sql = "SELECT u.user_id FROM users u " +
                        "JOIN hashed_passwords p ON u.user_id = p.user_id " +
                        "WHERE u.email = ? AND p.password_hash = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            System.out.println(preparedStatement.toString());

            ResultSet resultSet =  preparedStatement.executeQuery();

            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        String id = resultSet.getString("user_id");
                        System.out.println("Found user with id: " + id);
                        return true;
                    }
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        resultSet.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
