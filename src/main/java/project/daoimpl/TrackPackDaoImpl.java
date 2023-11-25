package project.daoimpl;

import project.dao.ProductDao;
import project.dao.TrackPackDao;
import project.model.product.TrackPack;
import project.model.product.abstractproduct.Product;
import project.model.product.enums.TrackPackType;
import project.service.MysqlService;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrackPackDaoImpl extends  ProductDaoImpl implements TrackPackDao {
    private static final Logger LOGGER = Logger.getLogger(TrackPackDaoImpl.class.getName());
    private MysqlService mysqlService;

    public TrackPackDaoImpl(MysqlService mysqlService) {
        super(mysqlService);
    }

    @Override
    public void addTrackPack(TrackPack trackPack) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = mysqlService.getConnection();
            connection.setAutoCommit(false); // Start transaction

            // First, call the superclass method to handle the common Product attributes
            super.addProduct(trackPack);

            // Then, add the specific attributes of the TrackPack
            String sqlTrackPack = "INSERT INTO track_pack (product_code, pack_type) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(sqlTrackPack);

            // Set the parameters for the preparedStatement
            preparedStatement.setString(1, trackPack.getProductCode());
            preparedStatement.setString(2, trackPack.getPackType().name()); // TrackPack specific attribute

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
            LOGGER.log(Level.SEVERE, "Error adding track pack to the database", e);
            throw new RuntimeException("Database operation failed", e);
        } finally {
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException e) { /* ignored */ }
            if (connection != null) try { connection.close(); } catch (SQLException e) { /* ignored */ }
        }
    }


    @Override
    public TrackPack getTrackPack(String productCode) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = mysqlService.getConnection();

            // Retrieve common Product attributes
            Product product = super.getProduct(productCode);
            if (!(product instanceof TrackPack)) {
                throw new RuntimeException("Product with code " + productCode + " is not a TrackPack.");
            }
            TrackPack trackPack = (TrackPack) product;

            // Retrieve specific attributes of the TrackPack
            String sqlTrackPack = "SELECT pack_type FROM track_pack WHERE product_code = ?";
            preparedStatement = connection.prepareStatement(sqlTrackPack);
            preparedStatement.setString(1, productCode);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                TrackPackType packType = TrackPackType.valueOf(resultSet.getString("pack_type"));

                trackPack.setPackType(packType); // TrackPack specific attribute
            }

            return trackPack;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving track pack with productCode: " + productCode, e);
            throw new RuntimeException("Database operation failed", e);
        } finally {
            if (resultSet != null) try { resultSet.close(); } catch (SQLException e) { /* ignored */ }
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException e) { /* ignored */ }
            if (connection != null) try { connection.close(); } catch (SQLException e) { /* ignored */ }
        }
    }


    @Override
    public List<TrackPack> getAllTrackPacks() {
        List<TrackPack> trackPacks = new ArrayList<>();
        String sql = "SELECT p.product_code, p.brand_name, p.product_name, p.retail_price, p.gauge_type, tp.pack_type FROM product p JOIN track_pack tp ON p.product_code = tp.product_code";
        try (Connection conn = mysqlService.getConnection();
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
        // Implement logic to update a track pack's information in the database
    }

    @Override
    public void deleteTrackPack(String id) {
        // Implement logic to delete a track pack from the database
    }

    // Other necessary methods...
}
