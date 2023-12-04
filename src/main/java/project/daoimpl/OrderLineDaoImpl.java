package project.daoimpl;

import project.dao.OrderLineDao;
import project.model.order.Order;
import project.model.order.OrderLine;
import project.service.MySqlService;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderLineDaoImpl implements OrderLineDao {
    private static final Logger LOGGER = Logger.getLogger(OrderLineDaoImpl.class.getName());

    @Override
    public void addOrderLine(OrderLine orderLine) {
        String sql = "INSERT INTO orderline (product_code, quantity, linecost, order_number) VALUES (?, ?, ?, ?)";

        try (Connection conn = MySqlService.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, orderLine.getProductCode());
            pstmt.setInt(2, orderLine.getQuantity());
            pstmt.setBigDecimal(3, orderLine.getLineCost());
            pstmt.setInt(4, orderLine.getOrderNumber());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating order line failed, no rows affected.");
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "AddOrderLine method:Database operation failed", e);
            throw new RuntimeException("Error accessing the database", e);
        }
    }

    @Override
    public OrderLine getOrderLine(int orderNumber, String productCode) {
        String sql = "SELECT * FROM orderline WHERE order_number = ? AND product_code = ?";

        try (Connection conn = MySqlService.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, orderNumber);
            pstmt.setString(2, productCode);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int quantity = rs.getInt("quantity");
                    BigDecimal lineCost = rs.getBigDecimal("linecost");
                    return new OrderLine(productCode, quantity, lineCost, orderNumber);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "GetOrderLine method:Database operation failed", e);
            throw new RuntimeException("Error accessing the database", e);
        }
        return null;
    }

    @Override
    public List<OrderLine> getAllOrderLines(int orderNumber) {
        List<OrderLine> orderLines = new ArrayList<>();
        String query = "SELECT * FROM orderline WHERE order_number = ?";

        try (Connection connection = MySqlService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, orderNumber);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {

                    String productCode = resultSet.getString("product_code");
                    int quantity = resultSet.getInt("quantity");
                    BigDecimal linecost = resultSet.getBigDecimal("linecost");

                    OrderLine orderLine = new OrderLine(productCode, quantity, linecost, orderNumber);
                    orderLines.add(orderLine);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving order lines for order number: " + orderNumber, e);
            throw new RuntimeException("Database operation failed", e);
        }

        return orderLines;
    }

    @Override
    public void updateOrderLine(OrderLine orderLine) {
        BigDecimal unitPrice = getProductRetailPrice(orderLine.getProductCode());

        String sql = "UPDATE orderline SET quantity = ?, linecost = ? WHERE order_number = ? AND product_code = ?";

        BigDecimal newLineCost = unitPrice.multiply(new BigDecimal(orderLine.getQuantity()));

        try (Connection conn = MySqlService.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, orderLine.getQuantity());
            pstmt.setBigDecimal(2, newLineCost);
            pstmt.setInt(3, orderLine.getOrderNumber());
            pstmt.setString(4, orderLine.getProductCode());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows == 0) {
                LOGGER.log(Level.WARNING, "No order line was updated for order number: {0} and product code: {1}", new Object[]{orderLine.getOrderNumber(), orderLine.getProductCode()});
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error when trying to update order line", e);
            throw new RuntimeException("Error accessing the database", e);
        }
    }

    @Override
    public BigDecimal getProductRetailPrice(String productCode) {
        String sql = "SELECT retail_price FROM product WHERE product_code = ?";

        try (Connection conn = MySqlService.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, productCode);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getBigDecimal("retail_price");
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error when trying to get retail price for product code: " + productCode, e);
            throw new RuntimeException("Error accessing the database", e);
        }
        return null;
    }


    @Override
    public void deleteOrderLine(int orderNumber, String productCode) {
        String sql = "DELETE FROM orderline WHERE order_number = ? AND product_code = ?";

        try (Connection conn = MySqlService.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, orderNumber);
            pstmt.setString(2, productCode);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows == 0) {
                LOGGER.log(Level.WARNING, "No order lines were deleted for order number: {0} and product code: {1}", new Object[]{orderNumber, productCode});
            }


        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "DeleteOrderLine method:Database operation failed", e);
            throw new RuntimeException("Error accessing the database", e);
        }
    }

}
