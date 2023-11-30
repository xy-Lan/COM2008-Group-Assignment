package project.daoimpl;

import project.dao.BoxedSetDao;
import project.dao.ProductDao;
import project.dao.TrackPackDao;
import project.exceptions.CustomDuplicateKeyException;
import project.exceptions.UserDatabaseException;
import project.model.product.TrackPack;
import project.model.product.abstractproduct.Product;
import project.model.product.enums.TrackPackType;
import project.service.MySqlService;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrackPackDaoImpl extends  ProductDaoImpl implements TrackPackDao {
    private static final Logger LOGGER = Logger.getLogger(TrackPackDaoImpl.class.getName());

    @Override
    public void addTrackPack(TrackPack trackPack) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = MySqlService.getConnection();
            connection.setAutoCommit(false); // Start transaction

            // First, add the generic product attributes
            super.addProduct(trackPack, connection);
            BoxedSetDao boxedSetDao = new BoxedSetDaoImpl();
            boxedSetDao.addBoxedSet(trackPack, connection);

            // Then, add the specific attributes of the TrackPack
            String sqlTrackPack = "INSERT INTO track_pack (product_code, pack_type) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(sqlTrackPack);
            preparedStatement.setString(1, trackPack.getProductCode());
            preparedStatement.setString(2, trackPack.getPackType().name()); // Storing the enum value as String

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
            if (e.getSQLState().equals("23000")) {
                throw new CustomDuplicateKeyException("A track pack with the same product code already exists.");
            }
            LOGGER.log(Level.SEVERE, "Error adding track pack to the database", e);
            throw new RuntimeException("Error adding track pack", e);
        }
    }



    @Override
    public TrackPack getTrackPack(String productCode)  {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Product product = super.getProduct(productCode);
            if (product == null) {
                LOGGER.info("No product found with productCode: " + productCode);
                return null;
            }

            if (!(product instanceof TrackPack)) {
                throw new UserDatabaseException("Product with code " + productCode + " is not a TrackPack.");
            }
            TrackPack trackPack = (TrackPack) product;

            connection = MySqlService.getConnection();
            if (connection == null) {
                LOGGER.info("Database connection is null");
                return null;
            }

            String sqlTrackPack = "SELECT pack_type FROM track_pack WHERE product_code = ?";
            preparedStatement = connection.prepareStatement(sqlTrackPack);
            preparedStatement.setString(1, productCode);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                TrackPackType packType = TrackPackType.valueOf(resultSet.getString("pack_type"));
                trackPack.setPackType(packType);
            }

            return trackPack;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving track pack with productCode: " + productCode, e);
            throw new UserDatabaseException("Error retrieving track pack from database", e);
        }
    }



    @Override
    public List<TrackPack> getAllTrackPacks() {
        List<TrackPack> trackPacks = new ArrayList<>();
        String sql = "SELECT p.product_code, p.brand_name, p.product_name, p.retail_price, p.gauge_type, tp.pack_type FROM product p JOIN track_pack tp ON p.product_code = tp.product_code";
        try (Connection conn = MySqlService.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                // Using the Create TrackPack from ResultSet method
                TrackPack trackPack = TrackPack.fromResultSet(rs);
                trackPacks.add(trackPack);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving all track packs", e);
            throw new RuntimeException("Database operation failed", e);
        }
        return trackPacks;
    }


    @Override
    public void updateTrackPack(TrackPack trackPack) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = MySqlService.getConnection();
            connection.setAutoCommit(false);

            super.updateProduct(trackPack, connection);

            // Update specific TrackPack attributes
            String sqlTrackPack = "UPDATE track_pack SET pack_type = ? WHERE product_code = ?";
            preparedStatement = connection.prepareStatement(sqlTrackPack);
            preparedStatement.setString(1, trackPack.getPackType().name());
            preparedStatement.setString(2, trackPack.getProductCode());
            preparedStatement.executeUpdate();

            connection.commit(); // Commit transaction
            LOGGER.info("TrackPack updated successfully for productCode: " + trackPack.getProductCode());
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error updating TrackPack: " + e.getMessage(), e);
            if (connection != null) {
                try {
                    connection.rollback(); // Rollback transaction in case of error
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, "Error rolling back transaction", ex);
                }
            }
            throw new RuntimeException("Database operation failed: " + e.getMessage(), e);
        }
    }



    @Override
    public void deleteTrackPack(String productCode) {
        Connection connection = null;

        try {
            connection = MySqlService.getConnection();
            connection.setAutoCommit(false); // Start transaction

            String sqlTrackPack = "DELETE FROM track_pack WHERE product_code = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlTrackPack)) {
                preparedStatement.setString(1, productCode);
                preparedStatement.executeUpdate();
            }

            BoxedSetDao boxedSetDao = new BoxedSetDaoImpl();
            boxedSetDao.deleteBoxedSet(productCode, connection);

            super.deleteProduct(productCode, connection);

            connection.commit(); // Commit transaction
            LOGGER.info("TrackPack deleted successfully for productCode: " + productCode);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error deleting TrackPack with productCode: " + productCode, e);
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, "Error rolling back transaction", ex);
                }
            }
            throw new RuntimeException("Database operation failed for productCode: " + productCode, e);
        }
    }


}
