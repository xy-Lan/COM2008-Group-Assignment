package project.daoimpl;

import project.dao.ProductDao;
import project.dao.TrackDao;
import project.model.product.Track;
import project.model.product.abstractproduct.Product;
import project.model.product.enums.TrackType;
import project.service.MysqlService;

import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrackDaoImpl extends ProductDaoImpl implements TrackDao {
    private static final Logger LOGGER = Logger.getLogger(TrackDaoImpl.class.getName());
    private MysqlService mysqlService;

    public TrackDaoImpl(MysqlService mysqlService) {
        super(mysqlService);
    }

    @Override
    public void addTrack(Track track) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = mysqlService.getConnection();
            connection.setAutoCommit(false); // Start transaction

            // First, call the superclass method to handle the common Product attributes
            super.addProduct(track);

            // Then, add the specific attributes of the Track
            String sqlTrack = "INSERT INTO track (product_code, track_type) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(sqlTrack);

            // Set the parameters for the preparedStatement
            preparedStatement.setString(1, track.getProductCode());
            preparedStatement.setString(2, track.getTrackType().name()); // Track specific attribute

            preparedStatement.executeUpdate();

            connection.commit(); // Commit transaction
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback(); // Rollback transaction
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, "Error rolling back transaction", ex);
                }
            }
            LOGGER.log(Level.SEVERE, "Error adding track to the database", e);
            throw new RuntimeException("Database operation failed", e);
        } finally {
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException e) { /* ignored */ }
            if (connection != null) try { connection.close(); } catch (SQLException e) { /* ignored */ }
        }
    }

    @Override
    public Track getTrack(String productCode) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = mysqlService.getConnection();

            // Retrieve common Product attributes
            Product product = super.getProduct(productCode);
            if (!(product instanceof Track)) {
                throw new RuntimeException("Product with code " + productCode + " is not a Track.");
            }
            Track track = (Track) product;

            // Retrieve specific attributes of the Track
            String sqlTrack = "SELECT track_type FROM track WHERE product_code = ?";
            preparedStatement = connection.prepareStatement(sqlTrack);
            preparedStatement.setString(1, productCode);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                TrackType trackType = TrackType.valueOf(resultSet.getString("track_type"));

                track.setTrackType(trackType); // Track specific attribute
            }

            return track;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving track with productCode: " + productCode, e);
            throw new RuntimeException("Database operation failed", e);
        } finally {
            if (resultSet != null) try { resultSet.close(); } catch (SQLException e) { /* ignored */ }
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException e) { /* ignored */ }
            if (connection != null) try { connection.close(); } catch (SQLException e) { /* ignored */ }
        }
    }


    @Override
    public List<Track> getAllTracks() {
        // Implement logic to retrieve all tracks from the database
        return null;
    }

    @Override
    public void updateTrack(Track track) {
        // Implement logic to update a track's information in the database
    }

    @Override
    public void deleteTrack(String id) {
        // Implement logic to delete a track from the database
    }

    // Other necessary methods...
}
