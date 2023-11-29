package project.dao;

import java.util.List;
import java.util.Optional;

import project.model.address.Address;
import project.model.inventory.Inventory;
import project.model.order.*;
import project.model.payment.Payment;
import project.model.user.*;

public interface UserDao {
    // Basic CRUD operations
    void addUser(User user);
    Optional<User> getUserById(int userId);
    User getUserByEmail(String email);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(int userId);

    void addUserPasswordHash(int userId, String passwordHash);

    String getUserPasswordHash(int userId);

    // Methods for handling user roles
    List<Role> getUserRoles(int userId);
    void addUserRole(int userId, Role role);
    int getRoleId(String roleName);
    void removeUserRole(int userId, Role role);

    // Methods for handling inventories for staff users
    List<Inventory> getUserInventories(int userId);
    void addInventoryToUser(int userId, Inventory inventory);


    void removeInventoryFromUser(int userID, Inventory inventory);

    // Methods for handling payment information for customer users
    List<Payment> getUserPayments(int userID);
    void addPaymentToUser(int userID, Payment payment);
    void removePaymentFromUser(int userID, String paymentId);

    // Methods for handling user orders
    List<Order> getUserOrders(int userID);
    void addOrderToUser(int userID, Order order);
    // void updateOrderStatus(int userID, String orderId, OrderStatus status);

    // Methods for handling user address
    Address getUserAddress(int userID);
    void updateUserAddress(int userID, Address address);
}
