package project.daoImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.dao.TrackDao;
import project.daoimpl.TrackDaoImpl;
import project.model.product.Track;
import project.service.MysqlService;

import java.util.List;

public class TrackDaoImplTest {
    private TrackDao trackDao;
    MysqlService mysqlService = new MysqlService();

    @BeforeEach
    public void setUp() {
        trackDao = new TrackDaoImpl(mysqlService);

    }

    @Test
    public void testGetAllTracks() {
        List<Track> tracks = trackDao.getAllTracks();
        Assertions.assertNotNull(tracks, "Tracks list should not be null");
        Assertions.assertFalse(tracks.isEmpty(), "Tracks list should not be empty");

    }
}
