package project.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import project.model.product.enums.CarriageType;
import project.model.user.User;
import project.utils.UserSessionManager;

/*
The MysqlService class is designed as a centralized service
to manage database connections and operations for MySQL. Each DaoImpl
(Data Access Object Implementation) needs an instance of MysqlService
as a parameter to perform database operations like queries and updates.
This design ensures that all DAOs share the same configuration and
connection management logic, leading
to more maintainable and consistent database interaction across
the application.
*/
public class MySqlService {

    private static final String JDBC_URL = "jdbc:mysql://stusql.dcs.shef.ac.uk/team015";
    private static final String USERNAME = "team015";
    private static final String PASSWORD = "eSh7Shahk";

    private static final MySqlService mySqlService = new MySqlService();

    public static MySqlService getInstance() {
        return mySqlService;
    }


    private static Connection connection;

    public MySqlService() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load MySQL JDBC driver.");
        }

        connect();
    }

    public static Connection getConnection() {
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

    public Connection getInstanceConnection() {
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

    private static void connect() {
        try {
            System.out.println("Connecting...");
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            System.out.println("Connected!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database.");
        }
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to close the database connection.");
        }
    }

    public static ResultSet executeQuery(String query) {
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

    public static User signUp(User user, String password) {
        System.out.println("Calling sign up...");
        try {
            Connection connection = getConnection();

            String insertUserSQL = "INSERT INTO users (email) VALUES (?)";
            try (PreparedStatement userStatement = connection.prepareStatement(insertUserSQL, PreparedStatement.RETURN_GENERATED_KEYS)) {
                userStatement.setString(1, user.getEmail());
                System.out.println(userStatement);
                userStatement.executeUpdate();

                try (ResultSet generatedKeys = userStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int userId = generatedKeys.getInt(1);

                        String insertPasswordSQL = "INSERT INTO hashed_passwords (user_id, password_hash) VALUES (?, ?)";
                        try (PreparedStatement passwordStatement = connection.prepareStatement(insertPasswordSQL)) {
                            passwordStatement.setInt(1, userId);
                            passwordStatement.setString(2, password);
                            passwordStatement.executeUpdate();

                            System.out.println("Successfully added");
                            user.setUserID(userId);
                            return user;
                        }
                    } else {
                        throw new SQLException("Failed to get the user ID.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return null;
    }


    public static boolean login(String username, String password) {

        Connection connection = getConnection();

        String sql = "SELECT u.user_id, u.email, u.address_id FROM users u " +
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
                        int id = resultSet.getInt("user_id");
                        int address_id = resultSet.getInt("address_id");
                        String email = resultSet.getString("email");
                        System.out.println("Found user with id: " + id);
                        User user = new User(email);
                        user.setUserID(id);
                        user.setAddressId(address_id);
                        UserSessionManager.getInstance().setLoggedInUser(user);
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

    public static String generateProductCode(String productType) {
        if ("LOCOMOTIVE".equals(productType)) {
            return "L" + highestProductCode("L");
        } else if ("CARRIAGE".equals(productType)) {
            return checkWagonType(productType) + highestProductCode(checkWagonType(productType));
        } else if ("CONTROLLER".equals(productType)) {
            return "C" + highestProductCode("C");
        } else if ("TRACK".equals(productType)) {
            return "R" + highestProductCode("R");
        } else if ("TRACK_PACK".equals(productType)) {
            return "P" + highestProductCode("P");
        } else if ("BOXED_SET".equals(productType)) {
            return "PO" + highestProductCode("PO");
        } else if ("TRAIN_SET".equals(productType)) {
            return "M" + highestProductCode("M");
        } else {
            return "ERROR";
        }
    }
    
    private static String highestProductCode(String productIdentifier){
        int maxProductCode = findMax(getFilteredProductCodes(productIdentifier));
        return String.valueOf(maxProductCode + 1);
    }

    public static String checkWagonType(String wagonType) {
        switch (wagonType) {
            case "CORRIDOR_FIRST":
            case "OPEN_FIRST":
            case "CORRIDOR_SECOND":
            case "SLEEPER_CAR":
            case "RESTAURANT_CAR":
            case "BUFFET_CAR":
            case "OPEN_SECOND":
            case "BRAKE_SECOND":
            case "PULLMAN":
            case "STANDARD_CALSS":
                return "RC"; // Passenger Carriage
            default:
                return "SW"; // Unknown wagon type
        }
    }

    public static List<String> getAllProductCodes() {
        List<String> productCodes = new ArrayList<>();
    
        try (Connection conn = MySqlService.getConnection();) {
            String sql = "SELECT product_code FROM product";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
    
                while (resultSet.next()) {
                    String productCode = resultSet.getString("product_code");
                    productCodes.add(productCode);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return productCodes;
    }
    

    public static List<Integer> getFilteredProductCodes(String prefixToFilter) {
        List<Integer> filteredProductCodes = new ArrayList<>();
        List<String> allProductCodes = getAllProductCodes();
    
        int prefixLength = prefixToFilter.length();
    
        for (String productCode : allProductCodes) {
            if (productCode.startsWith(prefixToFilter)) {
                try {
                    int productCodeInt = Integer.parseInt(productCode.substring(prefixLength));
                    filteredProductCodes.add(productCodeInt);
                } catch (NumberFormatException e) {
                    // Handle the exception if the numeric part is not a valid integer
                    e.printStackTrace();
                }
            }
        }
    
        return filteredProductCodes;
    }
    

    public static int findMax(List<Integer> numbers) {
        int max = Integer.MIN_VALUE;

        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }
}
