package project.service;

import java.sql.*;
import java.util.List;
import java.util.logging.Level;

import project.dao.OrderLineDao;
import project.daoimpl.InventoryDaoImpl;
import project.daoimpl.OrderLineDaoImpl;
import project.model.order.Order;
import project.model.order.OrderLine;
import project.model.user.*;

import project.dao.InventoryDao;
import project.model.inventory.Inventory;
import project.model.user.Role;

public class InventoryService {

    private InventoryDao inventoryDao = new InventoryDaoImpl();

    private User updater;

    private List<Inventory> inventories;
    private OrderLineDao orderLineDao = new OrderLineDaoImpl();

    private void checkStaffRole() {
        if (!updater.hasRole(Role.STAFF)) {
            throw new UnsupportedOperationException("Only staff can perform this operation.");
        }
    }

    public Boolean increaseStock(String productCode, int newShipmentQuantity) {
        checkStaffRole();

        try (
                Connection con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team015", "team015", "eSh7Shahk");
                PreparedStatement pstmt = con.prepareStatement("UPDATE `inventory` SET `quantity` = `quantity` + ? WHERE `product_code` = ?")
        ) {
            pstmt.setInt(1, newShipmentQuantity);
            pstmt.setString(2, productCode);
            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    // Additional parameters may be required
    public Boolean decreaseStock(String productCode, int quantityDecrease) {
        checkStaffRole();

        try (
                Connection con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team015", "team015", "eSh7Shahk");
                PreparedStatement pstmt = con.prepareStatement("UPDATE `inventory` SET `quantity` = `quantity` - ? WHERE `product_code` = ?")
        ) {
            pstmt.setInt(1, quantityDecrease);
            pstmt.setString(2, productCode);
            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void updateInventoryForOrder(Order order) throws SQLException {
        List<OrderLine> orderLines = orderLineDao.getAllOrderLines(order.getOrderNumber());

        for (OrderLine orderLine : orderLines) {
            String productCode = orderLine.getProductCode();
            int quantity = orderLine.getQuantity();

            inventoryDao.decreaseStock(productCode, quantity);
        }
    }

    // Additional parameters may be required
    public void checkStock() {
        checkStaffRole();
        // TODO - implement Inventory.checkStock
    }



}
