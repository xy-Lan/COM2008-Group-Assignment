package project.daoImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.dao.TrackDao;
import project.daoimpl.TrackDaoImpl;
import project.model.product.Track;
import project.model.product.enums.Gauge;
import project.model.product.enums.TrackType;
import project.service.MySqlService;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TrackDaoImplTest {
    private TrackDao trackDao;
    private final String testProductCode = "R223";

    @BeforeEach
    public void setUp() {
        trackDao = new TrackDaoImpl();

    }

    @Test
    void testAddTrack()  {
        Track testTrack = new Track(testProductCode, "Test Brand", "Test Product", BigDecimal.valueOf(100.0), Gauge.OO_GAUGE, TrackType.STRAIGHT);
        trackDao.addTrack(testTrack);
    }

    @Test
    public void testDeleteTrack()  {

        trackDao.deleteTrack(testProductCode);

    }

    @Test
    public void testGetTrack() {
        String testProductCode = "R122";
            Track testTrack = trackDao.getTrack(testProductCode);
            System.out.println(testTrack.getBrandName());
            assertNotNull(testTrack, "Track should not be null");
            assertEquals(testProductCode, testTrack.getProductCode(), "Product code should match");

    }

    @Test
    public void testUpdateTrack() throws SQLException {
        Track testTrack = new Track(testProductCode, "Test Brand", "Test Product", BigDecimal.valueOf(150.0), Gauge.OO_GAUGE, TrackType.CURVE);
        trackDao.updateTrack(testTrack);

        Track updatedTrack = trackDao.getTrack(testTrack.getProductCode());

        assertNotNull(updatedTrack);
        assertEquals(TrackType.CURVE, updatedTrack.getTrackType());
    }


    @Test
    public void testGetAllTracks() {
        List<Track> tracks = trackDao.getAllTracks();
        assertNotNull(tracks, "Tracks list should not be null");
        Assertions.assertFalse(tracks.isEmpty(), "Tracks list should not be empty");

        boolean hasProductCodeR122 = tracks.stream()
                .anyMatch(track -> "R122".equals(track.getProductCode()));
        assertTrue(hasProductCodeR122, "Tracks list should contain a track with productCode 'R122'");

        boolean hasProductCodeR123 = tracks.stream()
                .anyMatch(track -> "R123".equals(track.getProductCode()));
        assertTrue(hasProductCodeR123, "Tracks list should contain a track with productCode 'R123'");
    }


}
