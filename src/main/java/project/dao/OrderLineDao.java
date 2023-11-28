package project.dao;

import project.model.order.OrderLine;

import java.math.BigDecimal;
import java.util.List;

public interface OrderLineDao {
    void addOrderLine(OrderLine orderLine); // Add an order line to the database
    OrderLine getOrderLine(int orderNumber, String productCode);  // Retrieve an order line from the database by order number
    List<OrderLine> getAllOrderLines(); // Retrieve all order lines from the database
    void updateOrderLine(OrderLine orderLine); // Update an order line in the database
    void deleteOrderLine(int orderNumber, String productCode);   // Delete an order line from the database by order number
    BigDecimal getProductRetailPrice(String productCode);
}
