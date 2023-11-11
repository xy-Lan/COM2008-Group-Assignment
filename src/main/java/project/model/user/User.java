package project.model.user;

import java.util.ArrayList;
import java.util.List;

import project.model.address.*;
import project.model.inventory.Inventory;
import project.model.order.*;
import project.model.payment.Payment;

public class User {

	private List<Role> roles = new ArrayList<>();
	private String email;
	private String password;
	private String userID;
	// Used only when the user is Staff
	private List<Inventory> inventories = new ArrayList<>();
	// Used only when the user is Customer
	private List<Payment> payments = new ArrayList<>();
	private List<Order> orders = new ArrayList<>();
	private Address residesAt;

	public void updateDetails() {
		// TODO - implement User.updateDetails
		throw new UnsupportedOperationException();
	}

	public void selfRegister() {
		// TODO - implement User.selfRegister
		throw new UnsupportedOperationException();
	}

	public void login() {
		// TODO - implement User.login
		throw new UnsupportedOperationException();
	}

	public void viewOrders() {
		// TODO - implement Customer.viewOrders
		throw new UnsupportedOperationException();
	}

	/**
	 * Checks if the user has the specified role.
	 *
	 * @param role The role to check for.
	 * @return {@code true} if the user has the given role, {@code false} otherwise.
	 */
	public boolean hasRole(Role role) {
		return roles.contains(role);
	}

	/**
	 * Adds the specified role to the user.
	 * If the user already has the role, it will not be added again.
	 *
	 * @param role The role to add.
	 */
	public void addRole(Role role) {
		if (!roles.contains(role)) {
			roles.add(role);
		}
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
	public void viewPendingOrders() {
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
	public void updateBankingDetails() {
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
	public void addCard() {
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
	public void removeCard() {
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
	public void appointUserAsStaff() {
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
	public void removeUserFromStaff() {
		// TODO - implement Manager.removeUserFromStaff
		throw new UnsupportedOperationException();
	}

}