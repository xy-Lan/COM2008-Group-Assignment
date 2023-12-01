package project.daoImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.dao.RollingStockDao;
import project.daoimpl.RollingStockDaoImpl;
import project.exceptions.UserDatabaseException;
import project.model.product.RollingStock;
import project.model.product.enums.Era;
import project.model.product.enums.Gauge;
import project.model.product.enums.RollingStockType;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RollingStockDaoTest {
    RollingStockDao rollingStockDao;
    String testProductCode = "S5555";
    RollingStock testRollingStock;

    @BeforeEach
    void setUp() {
        rollingStockDao = new RollingStockDaoImpl();
        testRollingStock = new RollingStock(
                testProductCode,
                "Bachmann",
                ", GWR Toad Guards Van",
                BigDecimal.valueOf(100),
                Gauge.OO_GAUGE,
                RollingStockType.WAGON,
                Era.ERA_6
        );
    }

    @Test
    void testAddRollingStock() throws SQLException {
        rollingStockDao.addRollingStock(testRollingStock);

    }

    @Test
    void testGetRollingStockSuccess() {
        try {
            RollingStock rollingStock = rollingStockDao.getRollingStock(testProductCode);
            System.out.println("Product code is "+rollingStock.getProductCode());
            assertNotNull(rollingStock, "RollingStock should not be null for existing product code");
        }  catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    @Test
//    void testGetAllRollingStock() {
//        try {
//            List<RollingStock> rollingStockList = rollingStockDao.getAllRollingStock();
//            assertNotNull(rollingStockList, "RollingStock list should not be null");
//            assertFalse(rollingStockList.isEmpty(), "RollingStock list should not be empty");
//
//            for (RollingStock rollingStock : rollingStockList) {
//                assertNotNull(rollingStock.getProductCode(), "Product code should not be null");
//                System.out.println("Product code is " + rollingStock.getProductCode());
//            }
//        } catch (SQLException e) {
//            fail("Should not throw an exception: " + e.getMessage());
//        }
//    }

    @Test
    void testUpdateRollingStock() {
        RollingStock rollingStock = new RollingStock(
                testProductCode,
                "Hornby",
                "Corridor First",
                BigDecimal.valueOf(100),
                Gauge.TT_GAUGE,
                RollingStockType.CARRIAGE,
                Era.ERA_1
        );

        rollingStock.setEra(Era.ERA_6);
        rollingStock.setGaugeType(Gauge.OO_GAUGE);

        try {
            rollingStockDao.updateRollingStock(rollingStock);
            RollingStock updatedRollingStock = rollingStockDao.getRollingStock(rollingStock.getProductCode());

        } catch (SQLException e) {
            fail("Should not throw an exception: " + e.getMessage());
        }
    }

    @Test
    void testDeleteRollingStock() {
        String productCode = "S299";

        try {
            assertNotNull(rollingStockDao.getRollingStock(productCode));

            rollingStockDao.deleteRollingStock(productCode);

            assertNull(rollingStockDao.getRollingStock(productCode));
        } catch (SQLException e) {
            fail("Should not throw an exception: " + e.getMessage());
        }
    }
}
