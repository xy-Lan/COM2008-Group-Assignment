package project.daoImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.dao.InventoryDao;
import project.daoimpl.InventoryDaoImpl;
import project.model.inventory.Inventory;

import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryDaoImplTest {
    private InventoryDao inventoryDao;
    private static final Logger LOGGER = Logger.getLogger(InventoryDaoImplTest.class.getName());


    @BeforeEach
    void setUp() {
        inventoryDao = new InventoryDaoImpl();
    }

//    @Test
//    void testIncreaseStock() {
//
//        String testProductCode = "P122";
//        int stockNumber = inventoryDao.getStock(testProductCode);
//        System.out.println(stockNumber);
//        inventoryDao.increaseStock(testProductCode, 5);
//
//    }

//    @Test
//    void testDecreaseStock() {
//
//        String testProductCode = "P122";
//
//        inventoryDao.decreaseStock(testProductCode, 5);
//
//    }

    @Test
    void testCheckStock() {
        List<Inventory> inventoryList = inventoryDao.checkStock();

        assertFalse(inventoryList.isEmpty(), "Inventory list should not be empty");

         Inventory expectedInventory = new Inventory("M122", 5);
         for (Inventory inventory : inventoryList) {
             System.out.println(inventory.getProductCode());
             System.out.println(inventory.getQuantity());
         }
    }
}