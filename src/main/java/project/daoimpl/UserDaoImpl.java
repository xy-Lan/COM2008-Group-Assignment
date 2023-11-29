package project.daoimpl;

import project.model.user.*;
import project.service.MySqlService;
import project.model.inventory.*;
import project.model.payment.*;
import project.model.order.*;
import project.model.address.*;
import project.dao.UserDao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDaoImpl implements UserDao {

    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class.getName());
    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO users (email,  forename, surname, house_number, post_code) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = MySqlService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            user.prepareStatement(preparedStatement);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error adding user to the database", e);
            throw new RuntimeException("Database operation failed", e);
        }
    }

    @Override
    public void addUserPasswordHash(int userId, String passwordHash) {
        // Using MySqlService to add a user's password hash to the database
    }

    @Override
    public String getUserPasswordHash(String email) {
        // Using MySqlService to get a user's password hash
        return null; //Returns the user's password hash or null if not found
    }

    @Override
    public Optional<User> getUserById(int userId) {
        // Implement JDBC code to retrieve a User by userId from the database
        String query = "SELECT * FROM users WHERE user_id = ?";
        try (Connection connection = MySqlService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String userEmail = resultSet.getString("email");

                User user = new User(userEmail);
                user.setUserID(userId);
                return Optional.of(user);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error accessing the database", e);
            throw new RuntimeException("Error accessing the database", e);
        }
        return Optional.empty();
    }

    @Override
    public User getUserByEmail(String email) {
        // Implement JDBC code to retrieve a User by email from the database
        return null; // Replace with actual user retrieved from the database
    }

    @Override
    public List<User> getAllUsers() {
        // Implement JDBC code to retrieve all Users from the database
        return null; // Replace with actual list of users retrieved from the database
    }

    @Override
    public void updateUser(User user) {
        // Implement JDBC code to update a User's details in the database
    }

    @Override
    public void deleteUser(int userId) {
        // Implement JDBC code to delete a User by userId from the database
    }

    // The following methods would be similarly implemented, with JDBC operations
    // to handle the corresponding user-related actions in the database.

    @Override
    public List<Role> getUserRoles(int userId) {
        List<Role> roles = new ArrayList<>();
        String sql = "SELECT role FROM user_roles WHERE user_id = ?";

        try (Connection connection = MySqlService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, userId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String roleName = resultSet.getString("role");
                    roles.add(Role.valueOf(roleName));
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving user roles from database", e);
            throw new RuntimeException("Database operation failed", e);
        }

        return roles;
    }

    @Override
    public void addUserRole(int userId, Role role) {
        String sql = "INSERT INTO user_roles (user_id, role) VALUES (?, ?)";

        try (Connection connection = MySqlService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, userId);
            preparedStatement.setString(2, role.name());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // Handling exceptions, e.g. logging
            LOGGER.log(Level.SEVERE, "Error adding user role to database", e);
            throw new RuntimeException("Database operation failed", e);
        }
    }

    @Override
    public void removeUserRole(int userId, Role role) {
    }



    @Override
    public List<Inventory> getUserInventories(int userId) {
        return null;
    }


    @Override
    public void addInventoryToUser(int userId, Inventory inventory) {
    }

    @Override
    public void removeInventoryFromUser(int userID, Inventory inventory) {
    }

    @Override
    public List<Payment> getUserPayments(int userID) {
        return null;
    }

    @Override
    public void addPaymentToUser(int userID, Payment payment) {
    }

    @Override
    public void removePaymentFromUser(int userID, String paymentId) {
    }

    @Override
    public List<Order> getUserOrders(int userID) {
        return null;
    }

    @Override
    public void addOrderToUser(int userID, Order order) {
    }

    // @Override
    // this method has been implement in OrderDao
    // public void updateOrderStatus(int userID, String orderId, OrderStatus status) {
    // }

    @Override
    public Address getUserAddress(int userID) {
        return null;
    }

    @Override
    public void updateUserAddress(int userID, Address address) {
    }
}

