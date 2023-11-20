package project.dao;

import java.util.List;

import project.model.address.Address;
import project.model.inventory.Inventory;
import project.model.order.*;
import project.model.payment.Payment;
import project.model.user.*;

public interface UserDao {
    // Basic CRUD operations
    int addUser(User user);
    User getUserById(int userId);
    User getUserByEmail(String email);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(int userId);

    void addUserPasswordHash(int userId, String passwordHash);

    String getUserPasswordHash(String email);

    // Methods for handling user roles
    List<Role> getUserRoles(int userId);
    void addUserRole(int userId, Role role);
    void removeUserRole(int userId, Role role);

    // Methods for handling inventories for staff users
    List<Inventory> getUserInventories(int userId);
    void addInventoryToUser(int userId, Inventory inventory);
    void removeInventoryFromUser(int userId, Inventory inventory);

    void removeInventoryFromUser(String userId, Inventory inventory);

    // Methods for handling payment information for customer users
    List<Payment> getUserPayments(String userId);
    void addPaymentToUser(String userId, Payment payment);
    void removePaymentFromUser(String userId, String paymentId);

    // Methods for handling user orders
    List<Order> getUserOrders(String userId);
    void addOrderToUser(String userId, Order order);
    void updateOrderStatus(String userId, String orderId, OrderStatus status);

    // Methods for handling user address
    Address getUserAddress(String userId);
    void updateUserAddress(String userId, Address address);
}
