package project.service;

import java.util.List;

import project.dao.UserDao;
import project.model.user.Role;
import project.model.user.User;
import project.security.PasswordEncryption;

import java.sql.*;

public class UserService {
    
    private UserDao userDao;

    private List<User> users;

	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}

	// Register a new user
    public User signUp(String email, String password) {
		// Hash the plaintext password
		String hashedPassword = PasswordEncryption.hashPassword(password);

		try {
			// Create a new User object
			User newUser = new User(email);
			newUser.setPasswordHash(hashedPassword);
			// Set additional user attributes as needed

			// Add user to the database and get generated user ID
			int userId = userDao.addUser(newUser);
			if (userId == 0) {
				throw new SQLException("Failed to create user.");
			}

			// Add hashed password associated with the user
			userDao.addUserPasswordHash(userId, hashedPassword);

			// Set the user ID of the newUser object
			newUser.setUserID(userId);

			return newUser;
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle or log the exception as appropriate
			return null;
		}
    }

    // User login
    public boolean loginUser(String email, String password) {
        // Implement the login logic here
        // For example, check if the email and password match
        return false; // Return whether the login was successful
    }

    // Update user information
    public void updateUserDetails(User user) {
        // Logic to update user details
        userDao.updateUser(user);
    }

    public User getUserById(int userId) {
        // Retrieve user information by user ID
        return userDao.getUserById(userId);
    }

    // Delete a user
    public void deleteUser(int userId) {
        // Logic to delete a user
        userDao.deleteUser(userId);
    }

    // Assigning roles to user
    public void assignRoleToUser(int userId, Role role) {
        userDao.addUserRole(userId, role);
    }
    
    // Deleting a user's role
    public void removeRoleFromUser(int userId, Role role) {
        userDao.removeUserRole(userId, role);
    }

    public void viewOrders(int userId) {
		// TODO - implement Customer.viewOrders
		throw new UnsupportedOperationException();
	}

    /**
	 * Views the pending orders.
	 * <p>
	 * <b>Note:</b> This method can only be used by users with the 'STAFF' role in
	 * their Role list.
	 * </p>
	 * 
	 * @throws UnsupportedOperationException if the user doesn't have the 'STAFF'
	 *                                       role
	 */
	public void viewPendingOrders(String userId) {
		// TODO - implement Staff.viewPendingOrders
		throw new UnsupportedOperationException();
	}

	/**
	 * Views the pending orders.
	 * <p>
	 * <b>Note:</b> This method can only be used by users with the 'CUSTOMER' role
	 * in
	 * their Role list.
	 * </p>
	 * 
	 * @throws UnsupportedOperationException if the user doesn't have the 'STAFF'
	 *                                       role
	 */
	public void updateBankingDetails(String userId) {
		// TODO - implement Customer.updateBankingDetails
		throw new UnsupportedOperationException();
	}

	/**
	 * Views the pending orders.
	 * <p>
	 * <b>Note:</b> This method can only be used by users with the 'CUSTOMER' role
	 * in
	 * their Role list.
	 * </p>
	 * 
	 * @throws UnsupportedOperationException if the user doesn't have the 'STAFF'
	 *                                       role
	 */
	public void addCard(String userId) {
		// TODO - implement Customer.addCard
		throw new UnsupportedOperationException();
	}

	/**
	 * Views the pending orders.
	 * <p>
	 * <b>Note:</b> This method can only be used by users with the 'CUSTOMER' role
	 * in
	 * their Role list.
	 * </p>
	 * 
	 * @throws UnsupportedOperationException if the user doesn't have the 'STAFF'
	 *                                       role
	 */
	public void removeCard(String userId) {
		// TODO - implement Customer.removeCard
		throw new UnsupportedOperationException();
	}

	/**
	 * Views the pending orders.
	 * <p>
	 * <b>Note:</b> This method can only be used by users with the 'MANAGER' role in
	 * their Role list.
	 * </p>
	 * 
	 * @throws UnsupportedOperationException if the user doesn't have the 'STAFF'
	 *                                       role
	 */
	public void appointUserAsStaff(String userId) {
		// TODO - implement Manager.appointUserAsStaff
		throw new UnsupportedOperationException();
	}

	/**
	 * Views the pending orders.
	 * <p>
	 * <b>Note:</b> This method can only be used by users with the 'MANAGER' role in
	 * their Role list.
	 * </p>
	 * 
	 * @throws UnsupportedOperationException if the user doesn't have the 'STAFF'
	 *                                       role
	 */
	public void removeUserFromStaff(String userId) {
		// TODO - implement Manager.removeUserFromStaff
		throw new UnsupportedOperationException();
	}
    // Additional business methods related to users...
}
