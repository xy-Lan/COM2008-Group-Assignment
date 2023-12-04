package project.daoimpl;

import project.dao.ProductDao;
import project.dao.WagonDao;
import project.model.product.Wagon;
import project.model.product.abstractproduct.Product;
import project.model.product.enums.Era;
import project.model.product.enums.WagonType;
import project.service.MySqlService;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WagonDaoImpl extends  ProductDaoImpl implements WagonDao {
    private static final Logger LOGGER = Logger.getLogger(WagonDaoImpl.class.getName());

    @Override
    public void addWagon(Wagon wagon) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = MySqlService.getConnection();
            connection.setAutoCommit(false);

            super.addProduct(wagon,connection);

            String sqlWagon = "INSERT INTO wagon (product_code, wagon_type, era) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sqlWagon);

            preparedStatement.setString(1, wagon.getProductCode());
            preparedStatement.setString(2, wagon.getWagonType().name());
            preparedStatement.setString(3, wagon.getEra().name());

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
            LOGGER.log(Level.SEVERE, "Error adding wagon to the database", e);
            throw new RuntimeException("Database operation failed", e);
        } finally {
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException e) {  }
            if (connection != null) try { connection.close(); } catch (SQLException e) {  }
        }
    }


    @Override
    public Wagon getWagon(String productCode) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = MySqlService.getConnection();

            Product product = super.getProduct(productCode);
            if (!(product instanceof Wagon)) {
                throw new RuntimeException("Product with code " + productCode + " is not a Wagon.");
            }
            Wagon wagon = (Wagon) product;

            String sqlWagon = "SELECT wagon_type, era FROM wagon WHERE product_code = ?";
            preparedStatement = connection.prepareStatement(sqlWagon);
            preparedStatement.setString(1, productCode);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                WagonType wagonType = WagonType.valueOf(resultSet.getString("wagon_type"));
                Era era = Era.valueOf(resultSet.getString("era"));

                wagon.setWagonType(wagonType);
                wagon.setEra(era);
            }

            return wagon;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving wagon with productCode: " + productCode, e);
            throw new RuntimeException("Database operation failed", e);
        }
    }


    @Override
    public List<Wagon> getAllWagons() {
        List<Wagon> wagons = new ArrayList<>();
        String sql = "SELECT p.product_code, p.brand_name, p.product_name, p.retail_price, p.gauge_type, w.wagon_type, w.era FROM product p JOIN wagon w ON p.product_code = w.product_code";
        try (Connection conn = MySqlService.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Wagon wagon = Wagon.fromResultSet(rs);
                wagons.add(wagon);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving all wagons", e);

            throw new RuntimeException("Database operation failed", e);
        }
        return wagons;
    }


    @Override
    public void updateWagon(Wagon wagon) {

    }

    @Override
    public void deleteWagon(String id) {

    }

}
