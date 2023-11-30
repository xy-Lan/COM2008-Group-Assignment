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
    Optional<Order> getOrderById(int orderNumber);

    Optional<Order> getPendingOrderByUserId(int userId);

    // Retrieves all orders from the database
    List<Order> getAllOrders();

    // Updates an existing order in the database
    void updateOrderStatus(Order order);

    // Deletes an order by its order number from the database
    void deleteOrder(int orderNumber);

    // Retrieves all orders for a specific user from the database
    List<Order> getOrdersByUserId(int userId);

    List<Order> getConfirmedOrder();

    Boolean hasOrderedBefore (int userId);

    // Other order-related methods...
    void addOrderLine(OrderLine orderLine);

    void deleteOrderLine(OrderLine orderLine);

    Optional<OrderLine> findOrderLineByOrderNumberAndProductCode(int orderNumber, String productCode);

}
