package project.daoimpl;

import project.dao.BoxedSetDao;
import project.dao.ProductDao;
import project.model.product.abstractproduct.BoxedSet;
import project.model.product.abstractproduct.Part;
import project.model.product.enums.Gauge;
import project.service.MySqlService;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class BoxedSetDaoImpl implements BoxedSetDao {
    private static final Logger LOGGER = Logger.getLogger(BoxedSetDaoImpl.class.getName());
    private ProductDao productDao;
    
    public BoxedSetDaoImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void addBoxedSet(BoxedSet boxedSet) throws SQLException {

    }

    @Override
    public BoxedSet getBoxedSetById(String productCode) throws SQLException {
        
        String sql = "SELECT * FROM boxed_set WHERE product_code = ?";
        Connection conn = MySqlService.getConnection();

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, productCode);

            try (ResultSet resultSet = stmt.executeQuery()) {
                while (resultSet.next()) {
                    String brand_name = resultSet.getString("brand_name");
                    String product_name = resultSet.getString("product_name");
                    BigDecimal retail_price = resultSet.getBigDecimal("retail_price");
                    Gauge gauge = Gauge.fromString(resultSet.getString("gauge_type"));

                    // return new BoxedSet(productCode, brand_name, product_name, retail_price, gauge);
                }
            }

        } catch (SQLException e) {
            // LOGGER.log(Level.SEVERE, "Error adding part to the database", e);
            throw new RuntimeException("Database operation failed", e);
        }
        return null;

    }

    @Override
    public List<BoxedSet> getAllBoxedSets() throws SQLException {
        return null;
    }

    @Override
    public void deleteBoxedSet(String productCode) throws SQLException {

    }

}

