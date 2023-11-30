package project.daoImpl;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import project.dao.TrainSetDao;
import project.daoimpl.TrainSetDaoImpl;
import project.exceptions.UserDatabaseException;
import project.model.product.TrainSet;
import project.model.product.enums.Gauge;
import project.service.MySqlService;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TrainSetDaoImplTest {
    private TrainSetDao trainSetDao;

    @BeforeEach
    public void setUp() {
        // Create the TrainSetDao instance directly
        trainSetDao = new TrainSetDaoImpl();
    }

    @Test
    public void testAddTrainSet() {
        TrainSetDao trainSetDao = new TrainSetDaoImpl();
        TrainSet testTrainSet = new TrainSet("M229", "TestBrand", "TestName", new BigDecimal("99.99"), Gauge.N_GAUGE);

        trainSetDao.addTrainSet(testTrainSet);

    }

    @Test
    void getTrainSetTest() {
        try {
            TrainSet testTrainSet = trainSetDao.getTrainSet("M122");
            assertNotNull(testTrainSet, "TrainSet should not be null");
            Object testProductCode;
            assertEquals("M122", testTrainSet.getProductCode(), "Product codes should match");
        } catch (UserDatabaseException e) {
            fail("UserDatabaseException was thrown: " + e.getMessage());
        }
    }

    @Test
    public void testGetAllTrainSets() {
        List<TrainSet> trainSets = trainSetDao.getAllTrainSets();
        assertNotNull(trainSets, "Train sets list should not be null");
        Assertions.assertFalse(trainSets.isEmpty(), "Train sets list should not be empty");
        for (TrainSet trainSet : trainSets) {
            System.out.println("Product Code: " + trainSet.getProductCode());
        }
        boolean hasProductCodeM123 = trainSets.stream()
                .anyMatch(trainSet -> "M123".equals(trainSet.getProductCode()));
        Assertions.assertTrue(hasProductCodeM123, "List should contain a train set with product_code 'M123'");

        boolean hasProductCodeM122 = trainSets.stream()
                .anyMatch(trainSet -> "M122".equals(trainSet.getProductCode()));
        Assertions.assertTrue(hasProductCodeM123, "List should contain a train set with product_code 'M122'");
    }

    @Test
    void testDeleteTrainSet() {
        trainSetDao.deleteTrainSet("M229");

        assertNull(trainSetDao.getTrainSet("TestCode"), "TrainSet should be deleted from the database");
    }

    @Test
    public void testUpdateTrainSet() throws SQLException {
        TrainSet trainSet = new TrainSet("M224", "TestBrand", "TestName", new BigDecimal("122.99"), Gauge.TT_GAUGE);

        trainSetDao.updateTrainSet(trainSet);

    }
}
