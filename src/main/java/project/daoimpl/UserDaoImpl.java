package project.daoimpl;

import project.model.user.*;
import project.service.MySqlService;
import project.model.inventory.*;
import project.model.order.*;
import project.model.address.*;
import project.dao.UserDao;
import project.utils.PasswordUtils;

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
        String sql = "INSERT INTO users (email,  forename, surname, address_id) VALUES (?, ?, ?, ?)";

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
    public void addUserPasswordHash(int userId, String password) {
        String hashedPassword = PasswordUtils.hashPassword(password);
        System.out.println("hashed password is" + hashedPassword);
        System.out.println("user password is " + password);
        String sql = "INSERT INTO hashed_passwords (user_id, password_hash) VALUES (?, ?)";

        try (Connection connection = MySqlService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, userId);
            preparedStatement.setString(2, hashedPassword);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error adding password hash for user ID: " + userId, e);
            throw new RuntimeException("Database operation failed", e);
        }
    }

    @Override
    public Boolean updateUserPasswordHash(int userId, String newPassword) {
        String newPasswordHash = PasswordUtils.hashPassword(newPassword);
        String sql = "UPDATE hashed_passwords SET password_hash = ? WHERE user_id = ?";

        try (Connection connection = MySqlService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, newPasswordHash);
            preparedStatement.setInt(2, userId);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                LOGGER.info("Password hash not updated: no user found with ID " + userId);
                 return false;
            } else {
                LOGGER.info("Password hash updated successfully for user ID: " + userId);
                return true;
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error updating password hash for user ID: " + userId, e);
            throw new RuntimeException("Database operation failed", e);
        }
    }

    @Override
    public void removeAddressFromUser(int userId) {

    }

    @Override
    public void updateUserAddressId(int userId, int addressId) {
        String sql = "UPDATE users SET address_id = ? WHERE user_id = ?";

        try (Connection connection = MySqlService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            System.out.println("In updateUserAddressId method , new address id is " + addressId);
            preparedStatement.setInt(1, addressId);
            preparedStatement.setInt(2, userId);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                LOGGER.info("No user found with ID " + userId + ", address ID not updated.");
            } else {
                LOGGER.info("Address ID updated successfully for user ID: " + userId);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error updating address ID for user ID: " + userId, e);
            throw new RuntimeException("Database operation failed", e);
        }
    }



    @Override
    public String getUserPasswordHash(int userId) {
        String sql = "SELECT * FROM hashed_passwords WHERE user_id = ?";

        try (Connection connection = MySqlService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, userId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("password_hash");
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error getting password hash for userId: " + userId, e);
        }

        return null;
    }



    @Override
    public Optional<User> getUserById(int userId) {
        String query = "SELECT * FROM users WHERE user_id = ?";
        MySqlService mySqlService = new MySqlService();
        try (Connection connection = mySqlService.getInstanceConnection();      PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return Optional.of(User.fromResultSet(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error accessing the database", e);
            throw new RuntimeException("Error accessing the database", e);
        }
        return Optional.empty();
    }

    @Override
    public User getUserByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";

        try (Connection connection = MySqlService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return User.fromResultSet(resultSet);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error getting user by email: " + email, e);

        }

        return null;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Connection connection = MySqlService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                users.add(User.fromResultSet(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error getting all users", e);
            // You might want to throw an exception or handle the error based on your application's requirements
        }

        return users;
    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE users SET email = ?, forename = ?, surname = ?, address_id = ? WHERE user_id = ?";

        try (Connection connection = MySqlService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            user.prepareStatement(preparedStatement);
            preparedStatement.setInt(5, user.getUserID());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating user failed, no rows affected.");
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error updating user with ID: " + user.getUserID(), e);
            throw new RuntimeException("Database operation failed", e);
        }
    }

    @Override
    public void deleteUser(int userId) {
        String sql = "DELETE FROM users WHERE user_id = ?";

        try (Connection connection = MySqlService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, userId);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Deleting user failed, no rows affected.");
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error deleting user with ID: " + userId, e);
            throw new RuntimeException("Database operation failed", e);
        }
    }

    // The following methods would be similarly implemented, with JDBC operations
    // to handle the corresponding user-related actions in the database.

    @Override
    public List<Role> getUserRoles(int userId) {
        List<Role> roles = new ArrayList<>();
        String sql = "SELECT r.role_name FROM roles r JOIN user_roles ur ON r.role_id = ur.role_id WHERE ur.user_id = ?";

        try (Connection connection = MySqlService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, userId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String roleName = resultSet.getString("role_name");
                    roles.add(Role.valueOf(roleName));
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving user roles from database", e);
            throw new RuntimeException("Database operation failed", e);
        }

        return roles;
    }

    public Boolean hasCustomerRole(int userId) {
        String sql = "SELECT COUNT(*) FROM user_roles WHERE user_id = ? AND role_id = 1";

        try (Connection conn = MySqlService.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error checking if user has CUSTOMER role", e);
            throw new RuntimeException("Database operation failed", e);
        }

        return false;
    }

    @Override
    public void addUserRole(int userId, Role role) {
        // First, get the role_id corresponding to the role name
        int roleId = getRoleId(role.name());

        String sql = "INSERT INTO user_roles (user_id, role_id) VALUES (?, ?)";

        try (Connection connection = MySqlService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, roleId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error adding user role to database", e);
            throw new RuntimeException("Database operation failed", e);
        }
    }

    @Override
    public int getRoleId(String roleName) {
        String query = "SELECT role_id FROM roles WHERE role_name = ?";
        try (Connection connection = MySqlService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, roleName);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("role_id");
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving role ID from database", e);
            throw new RuntimeException("Database operation failed", e);
        }
        throw new IllegalStateException("Role not found: " + roleName);
    }


    @Override
    public void removeUserRole(int userId, Role role) {
        int roleId = getRoleId(role.name());

        String sql = "DELETE FROM user_roles WHERE user_id = ? AND role_id = ?";

        try (Connection connection = MySqlService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, roleId);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Removing user role failed, no rows affected.");
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error removing user role from database", e);
            throw new RuntimeException("Database operation failed", e);
        }
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

