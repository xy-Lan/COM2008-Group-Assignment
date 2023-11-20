package project.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import project.model.order.Order;
import project.model.order.OrderLine;

public interface OrderDao {
    // Adds a new order to the database
    void addOrder(Order order);

    // Retrieves an order by its order number from the database
    Optional<Order> getOrderById(String orderNumber);

    // Retrieves all orders from the database
    List<Order> getAllOrders();

    // Updates an existing order in the database
    void updateOrderStatus(Order order);

    // Deletes an order by its order number from the database
    void deleteOrder(String orderId);

    // Retrieves all orders for a specific user from the database
    List<Order> getOrdersByUserId(String userId);

    // Other order-related methods...
    void addOrderLine(OrderLine orderLine);

    void deleteOrderLine(OrderLine orderLine);

    Optional<OrderLine> findOrderLineByOrderNumberAndProductCode(String orderNumber, String productCode);

}
