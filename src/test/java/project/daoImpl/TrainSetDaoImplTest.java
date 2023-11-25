package project.daoImpl;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import project.dao.TrainSetDao;
import project.daoimpl.TrainSetDaoImpl;
import project.model.product.TrainSet;
import project.service.MysqlService;

import java.util.List;

public class TrainSetDaoImplTest {
    private TrainSetDao trainSetDao;
    private MysqlService mysqlService = new MysqlService();

    @BeforeEach
    public void setUp() {
        // Create the TrainSetDao instance directly
        trainSetDao = new TrainSetDaoImpl(mysqlService);
    }

    @Test
    public void testGetAllTrainSets() {
        List<TrainSet> trainSets = trainSetDao.getAllTrainSets();
        Assertions.assertNotNull(trainSets, "Train sets list should not be null");
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
}
