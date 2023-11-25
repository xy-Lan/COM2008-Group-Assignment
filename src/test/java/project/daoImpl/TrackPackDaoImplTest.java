package project.daoImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.dao.TrackPackDao;
import project.daoimpl.TrackPackDaoImpl;
import project.model.product.TrackPack;
import project.service.MysqlService;

import java.util.List;

public class TrackPackDaoImplTest {
    private TrackPackDao trackPackDao;
    private MysqlService mysqlService = new MysqlService();

    @BeforeEach
    public void setUp() {
        trackPackDao = new TrackPackDaoImpl(mysqlService);
    }

    @Test
    public void testGetAllTrackPacks() {
        List<TrackPack> trackPacks = trackPackDao.getAllTrackPacks();
        Assertions.assertNotNull(trackPacks, "Track packs list should not be null");
        Assertions.assertFalse(trackPacks.isEmpty(), "Track packs list should not be empty");

        boolean hasProductCodeP122 = trackPacks.stream()
                .anyMatch(trackPack -> "P122".equals(trackPack.getProductCode()));
        Assertions.assertTrue(hasProductCodeP122, "Track packs list should contain a track pack with productCode 'P122'");

        boolean hasProductCodeP123 = trackPacks.stream()
                .anyMatch(trackPack -> "P123".equals(trackPack.getProductCode()));
        Assertions.assertTrue(hasProductCodeP123, "Track packs list should contain a track pack with productCode 'P123'");
    }
}
