package project.daoImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.dao.TrackDao;
import project.daoimpl.TrackDaoImpl;
import project.model.product.Track;
import project.service.MySqlService;

import java.util.List;

public class TrackDaoImplTest {
    private TrackDao trackDao;

    @BeforeEach
    public void setUp() {
        trackDao = new TrackDaoImpl();

    }

    @Test
    public void testGetAllTracks() {
        List<Track> tracks = trackDao.getAllTracks();
        Assertions.assertNotNull(tracks, "Tracks list should not be null");
        Assertions.assertFalse(tracks.isEmpty(), "Tracks list should not be empty");

        boolean hasProductCodeR122 = tracks.stream()
                .anyMatch(track -> "R122".equals(track.getProductCode()));
        Assertions.assertTrue(hasProductCodeR122, "Tracks list should contain a track with productCode 'R122'");

        boolean hasProductCodeR123 = tracks.stream()
                .anyMatch(track -> "R123".equals(track.getProductCode()));
        Assertions.assertTrue(hasProductCodeR123, "Tracks list should contain a track with productCode 'R123'");
    }
}
