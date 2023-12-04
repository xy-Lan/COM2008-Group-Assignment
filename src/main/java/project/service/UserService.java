package project.service;

import java.util.List;

import project.dao.BankCardDao;
import project.dao.UserDao;
import project.daoimpl.BankCardDaoImpl;
import project.model.user.Role;
import project.model.user.User;
import project.security.PasswordEncryption;

import java.sql.*;
import java.util.Optional;

public class UserService {
    
    private UserDao userDao;
	private BankCardDao bankCardDao = new BankCardDaoImpl();
    private List<User> users;

	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}

	public boolean isUserManager(int userId) {
		List<Role> roles = userDao.getUserRoles(userId);
		return roles.contains(Role.MANAGER);
	}

	public boolean isUserStaff(int userId) {
		List<Role> roles = userDao.getUserRoles(userId);
		return roles.contains(Role.STAFF);
	}


    public boolean loginUser(String email, String password) {
        return false;
    }



	public boolean checkUserHasBankCard(int userId) {
		return bankCardDao.userHasBankCard(userId);
	}

    // Update user information
    public void updateUserDetails(User user) {
        // Logic to update user details
        userDao.updateUser(user);
    }

    public Optional<User> getUserById(int userId) {
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
		throw new UnsupportedOperationException();
	}


	public void viewPendingOrders(int userID) {
		throw new UnsupportedOperationException();
	}


	public void updateBankingDetails(int userID) {
		throw new UnsupportedOperationException();
	}


	public void addCard(int userID) {
		throw new UnsupportedOperationException();
	}

	public void removeCard(int userID) {
		throw new UnsupportedOperationException();
	}

	public void appointUserAsStaff(int userID) {

		throw new UnsupportedOperationException();
	}


	public void removeUserFromStaff(int userID) {
		throw new UnsupportedOperationException();
	}

}
