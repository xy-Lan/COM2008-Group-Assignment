package project.daoImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.dao.TrackPackDao;
import project.daoimpl.TrackPackDaoImpl;
import project.model.product.TrackPack;
import project.model.product.enums.Gauge;
import project.model.product.enums.TrackPackType;
import project.service.MySqlService;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TrackPackDaoImplTest {
    private TrackPackDao trackPackDao;

    @BeforeEach
    public void setUp() {
        trackPackDao = new TrackPackDaoImpl();
    }



//    @Test
//    void testDeleteTrackPack() {
//        String testProductCode = "P2235";
//        trackPackDao.deleteTrackPack(testProductCode);
//
//    }
//
//    @Test
//    public void testAddTrackPack() {
//        TrackPack trackPack = new TrackPack("P2235", "TestBrand", "TestName", new BigDecimal("10.99"), Gauge.OO_GAUGE, TrackPackType.EXTENSION_PACK);
//
//        trackPackDao.addTrackPack(trackPack);
//
//    }

//    @Test
//    public void testUpdateTrackPack()  {
//        TrackPack trackPack = new TrackPack("P2235", "TestBrand", "TestName", new BigDecimal("10.99"), Gauge.OO_GAUGE, TrackPackType.EXTENSION_PACK);
//
//        TrackPack newTrackPack = new TrackPack("P2235", "TestBrand", "TestName", new BigDecimal("100.99"), Gauge.TT_GAUGE, TrackPackType.STARTER_OVAL);
//        trackPackDao.updateTrackPack(newTrackPack);
//
//        TrackPack retrievedTrackPack = trackPackDao.getTrackPack("P2235");
//
//        assertNotNull(retrievedTrackPack);
//        assertEquals(TrackPackType.STARTER_OVAL, retrievedTrackPack.getPackType());
//        assertEquals("TestName", retrievedTrackPack.getProductName());
//
//    }

    @Test
    void testGetTrackPackSuccess()  {
        String productCode = "P122";
        TrackPack result = trackPackDao.getTrackPack(productCode);
        assertNotNull(result, "TrackPack should not be null for valid product code");
        assertEquals(productCode, result.getProductCode(), "Product codes should match");
    }



    @Test
    public void testGetAllTrackPacks() {
        List<TrackPack> trackPacks = trackPackDao.getAllTrackPacks();
        assertNotNull(trackPacks, "Track packs list should not be null");
        Assertions.assertFalse(trackPacks.isEmpty(), "Track packs list should not be empty");

        boolean hasProductCodeP122 = trackPacks.stream()
                .anyMatch(trackPack -> "P122".equals(trackPack.getProductCode()));
        assertTrue(hasProductCodeP122, "Track packs list should contain a track pack with productCode 'P122'");

        boolean hasProductCodeP123 = trackPacks.stream()
                .anyMatch(trackPack -> "P123".equals(trackPack.getProductCode()));
        assertTrue(hasProductCodeP123, "Track packs list should contain a track pack with productCode 'P123'");
    }
}
