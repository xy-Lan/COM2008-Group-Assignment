package project.daoImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.dao.CarriageDao;
import project.daoimpl.CarriageDaoImpl;
import project.model.product.Carriage;
import project.service.MysqlService;

import java.util.List;

public class CarriageDaoImplTest {
    private CarriageDao carriageDao;
    private MysqlService mysqlService = new MysqlService();

    @BeforeEach
    public void setUp() {
        carriageDao = new CarriageDaoImpl(mysqlService);
    }

    @Test
    public void testGetAllCarriages() {
        List<Carriage> carriages = carriageDao.getAllCarriages();
        Assertions.assertNotNull(carriages, "Carriages list should not be null");
        Assertions.assertFalse(carriages.isEmpty(), "Carriages list should not be empty");
        boolean hasProductCodeRC122 = carriages.stream()
                .anyMatch(carriage -> "RC122".equals(carriage.getProductCode()));
        Assertions.assertTrue(hasProductCodeRC122, "Carriages list should contain a carriage with productCode 'RC122'");

        boolean hasProductCodeRC123 = carriages.stream()
                .anyMatch(carriage -> "RC123".equals(carriage.getProductCode()));
        Assertions.assertTrue(hasProductCodeRC123, "Carriages list should contain a carriage with productCode 'RC123'");
    }
}
