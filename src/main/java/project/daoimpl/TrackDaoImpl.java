package project.daoimpl;

import project.dao.PartDao;
import project.dao.ProductDao;
import project.dao.TrackDao;
import project.exceptions.CustomDuplicateKeyException;
import project.exceptions.UserDatabaseException;
import project.model.product.Track;
import project.model.product.abstractproduct.Product;
import project.model.product.enums.TrackType;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import project.service.MySqlService;

public class TrackDaoImpl extends ProductDaoImpl implements TrackDao {
    private static final Logger LOGGER = Logger.getLogger(TrackDaoImpl.class.getName());

    @Override
    public void addTrack(Track track)  {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = MySqlService.getConnection();
            connection.setAutoCommit(false);
            super.addProduct(track, connection);
            PartDao partDao = new PartDaoImpl();
            partDao.addPart(track, connection);

            String sqlTrack = "INSERT INTO track (product_code, track_type) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(sqlTrack);

            preparedStatement.setString(1, track.getProductCode());
            preparedStatement.setString(2, track.getTrackType().name());

            preparedStatement.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, "Error rolling back transaction", ex);
                }
            }
            if (e.getSQLState().equals("23000")) {
                throw new CustomDuplicateKeyException("A track with the same product code already exists.");
            }
            LOGGER.log(Level.SEVERE, "Error adding track to the database", e);
            throw new RuntimeException("Error adding track", e);
        }
    }


    @Override
    public Track getTrack(String productCode)  {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Product product = super.getProduct(productCode);
            if (product == null) {
                LOGGER.info("No product found with productCode: " + productCode);
                return null;
            }

            if (!(product instanceof Track)) {
                throw new UserDatabaseException("Product with code " + productCode + " is not a Track.");
            }
            Track track = (Track) product;

            connection = MySqlService.getConnection();
            if (connection == null) {
                LOGGER.info("Database connection is null");
                return null;
            }

            String sqlTrack = "SELECT track_type FROM track WHERE product_code = ?";
            preparedStatement = connection.prepareStatement(sqlTrack);
            preparedStatement.setString(1, productCode);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                TrackType trackType = TrackType.valueOf(resultSet.getString("track_type"));
                track.setTrackType(trackType);
            }

            return track;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving track with productCode: " + productCode, e);
            throw new UserDatabaseException("Error retrieving track from database", e);
        }
    }



    @Override
    public List<Track> getAllTracks() {
        List<Track> tracks = new ArrayList<>();
        String sql = "SELECT p.product_code, p.brand_name, p.product_name, p.retail_price, p.gauge_type, t.track_type FROM product p JOIN track t ON p.product_code = t.product_code";
        try (Connection conn = MySqlService.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Track track = Track.fromResultSet(rs);
                tracks.add(track);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving all tracks", e);
            throw new RuntimeException("Database operation failed", e);
        }
        return tracks;
    }


    @Override
    public void updateTrack(Track track)  {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = MySqlService.getConnection();
            connection.setAutoCommit(false);
            super.updateProduct(track, connection);

            String sqlTrack = "UPDATE track SET track_type = ? WHERE product_code = ?";
            preparedStatement = connection.prepareStatement(sqlTrack);

            preparedStatement.setString(1, track.getTrackType().name());
            preparedStatement.setString(2, track.getProductCode());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating track failed, no rows affected.");
            }

            connection.commit();
            LOGGER.info("Track updated successfully for productCode: " + track.getProductCode());
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error updating track: " + e.getMessage(), e);
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, "Error rolling back transaction", ex);
                }
            }
            throw new RuntimeException("Database operation failed ", e);
        }
    }


    @Override
    public void deleteTrack(String productCode)  {
        Connection connection = null;

        try {
            connection = MySqlService.getConnection();
            connection.setAutoCommit(false);
            String sqlTrack = "DELETE FROM track WHERE product_code = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlTrack)) {
                preparedStatement.setString(1, productCode);
                int affectedRows = preparedStatement.executeUpdate();
                if (affectedRows == 0) {
                    LOGGER.info("No track was deleted for productCode: " + productCode);
                } else {
                    LOGGER.info("Track deleted successfully for productCode: " + productCode);
                }
            }

            PartDao partDao = new PartDaoImpl();
            partDao.deletePart(productCode, connection);

            super.deleteProduct(productCode, connection);

            connection.commit();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error deleting track with productCode: " + productCode, e);
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, "Error rolling back transaction", ex);
                }
            }
            throw new UserDatabaseException("Failed to delete track from the database for productCode: " + productCode, e);
        }
    }

}
