package project.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

import project.dao.OrderLineDao;
import project.daoimpl.InventoryDaoImpl;
import project.daoimpl.OrderLineDaoImpl;
import project.model.order.Order;
import project.model.order.OrderLine;
import project.model.user.*;

import project.dao.InventoryDao;
import project.model.inventory.Inventory;

public class InventoryService {

    private InventoryDao inventoryDao = new InventoryDaoImpl();

    private User updater;

    private List<Inventory> inventories;
    private OrderLineDao orderLineDao = new OrderLineDaoImpl();
    private static final Logger LOGGER = Logger.getLogger(InventoryService.class.getName());

    private void checkStaffRole() {
        if (!updater.hasRole(Role.STAFF)) {
            throw new UnsupportedOperationException("Only staff can perform this operation.");
        }
    }

    public Boolean increaseStock(String productCode, int newShipmentQuantity) {
        try {
            inventoryDao.increaseStock(productCode, newShipmentQuantity);
            return true;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error increasing stock for product code: " + productCode, e);
            return false;
        }
    }



    public Boolean decreaseStock(String productCode, int quantityDecrease) {
        try {
            inventoryDao.decreaseStock(productCode, quantityDecrease);
            return true;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error decreasing stock for product code: " + productCode, e);
            return false;
        }
    }

    public void updateStockLevel(String productCode, int newQuantity) {
        inventoryDao.updateStockLevel(productCode, newQuantity);
    }

    public void updateInventoryForOrder(Order order)  {

        List<OrderLine> orderLines = orderLineDao.getAllOrderLines(order.getOrderNumber());

        for (OrderLine orderLine : orderLines) {
            String productCode = orderLine.getProductCode();
            int quantity = orderLine.getQuantity();

            inventoryDao.decreaseStock(productCode, quantity);
        }
    }

    public void checkStock() {
        checkStaffRole();
    }

    public static void deleteProduct(String productCode) {
        try(Connection conn = MySqlService.getConnection()) {
            String query = "DELETE FROM locomotive WHERE product_code = ?";
            String query2 = "DELETE FROM rolling_stock WHERE product_code = ?";
            String query3 = "DELETE FROM track WHERE product_code = ?";
            String query4 = "DELETE FROM train_set WHERE product_code = ?";
            String query5 = "DELETE FROM track_pack WHERE product_code = ?";
            String query6 = "DELETE FROM part_boxed_set_association WHERE part_product_code = ?";
            String query7 = "DELETE FROM controller WHERE product_code = ?";
            String query8 = "DELETE FROM orderline WHERE product_code = ?";
            String query9 = "DELETE FROM boxed_set WHERE product_code = ?";
            String query10 = "DELETE FROM part WHERE product_code = ?";
            String query11 = "DELETE FROM inventory WHERE product_code = ?";
            String query12 = "DELETE FROM product WHERE product_code = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            PreparedStatement preparedStatement2 = conn.prepareStatement(query2);
            PreparedStatement preparedStatement3 = conn.prepareStatement(query3);
            PreparedStatement preparedStatement4 = conn.prepareStatement(query4);
            PreparedStatement preparedStatement5 = conn.prepareStatement(query5);
            PreparedStatement preparedStatement6 = conn.prepareStatement(query6);
            PreparedStatement preparedStatement7 = conn.prepareStatement(query7);
            PreparedStatement preparedStatement8 = conn.prepareStatement(query8);
            PreparedStatement preparedStatement9 = conn.prepareStatement(query9);
            PreparedStatement preparedStatement10 = conn.prepareStatement(query10);
            PreparedStatement preparedStatement11 = conn.prepareStatement(query11);
            PreparedStatement preparedStatement12 = conn.prepareStatement(query12);
            preparedStatement.setString(1, productCode);
            preparedStatement.executeUpdate();
            preparedStatement2.setString(1, productCode);
            preparedStatement2.executeUpdate();
            preparedStatement3.setString(1, productCode);
            preparedStatement3.executeUpdate();
            preparedStatement4.setString(1, productCode);
            preparedStatement4.executeUpdate();
            preparedStatement5.setString(1, productCode);
            preparedStatement5.executeUpdate();
            preparedStatement6.setString(1, productCode);
            preparedStatement6.executeUpdate();
            preparedStatement7.setString(1, productCode);
            preparedStatement7.executeUpdate();
            preparedStatement8.setString(1, productCode);
            preparedStatement8.executeUpdate();
            preparedStatement9.setString(1, productCode);
            preparedStatement9.executeUpdate();
            preparedStatement10.setString(1, productCode);
            preparedStatement10.executeUpdate();
            preparedStatement11.setString(1, productCode);
            preparedStatement11.executeUpdate();
            preparedStatement12.setString(1, productCode);
            preparedStatement12.executeUpdate();
            System.out.println("We just nuked the product with product code: " + productCode);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error deleting product with product code: " + productCode, e);
        }

    }


}
