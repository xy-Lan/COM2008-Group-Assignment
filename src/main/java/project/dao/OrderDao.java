package project.dao;

import java.util.List;

import project.model.order.Order;

public interface OrderDao {
    // Adds a new order to the database
    void addOrder(Order order);

    // Retrieves an order by its order number from the database
    Order getOrderById(String orderId);

    // Retrieves all orders from the database
    List<Order> getAllOrders();

    // Updates an existing order in the database
    void updateOrder(Order order);

    // Deletes an order by its order number from the database
    void deleteOrder(String orderId);

    // Retrieves all orders for a specific user from the database
    List<Order> getOrdersByUserId(String userId);

    // Other order-related methods...
}
