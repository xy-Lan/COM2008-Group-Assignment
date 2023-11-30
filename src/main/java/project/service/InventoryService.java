package project.service;

import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public void updateInventoryForOrder(Order order) {
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



}
