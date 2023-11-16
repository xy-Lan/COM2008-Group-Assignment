package project.dao;

import java.util.List;

import project.model.address.Address;
import project.model.inventory.Inventory;
import project.model.order.*;
import project.model.payment.Payment;
import project.model.user.*;

public interface UserDao {
    // Basic CRUD operations
    void addUser(User user);
    User getUserById(String userId);
    User getUserByEmail(String email);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(String userId);

    // Methods for handling user roles
    List<Role> getUserRoles(String userId);
    void addUserRole(String userId, Role role);
    void removeUserRole(String userId, Role role);

    // Methods for handling inventories for staff users
    List<Inventory> getUserInventories(String userId);
    void addInventoryToUser(String userId, Inventory inventory);
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
