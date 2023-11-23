package project.daoimpl;

import project.dao.ProductDao;
import project.dao.TrainSetDao;
import project.model.product.TrainSet;
import project.service.MysqlService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;
import java.sql.*;

public class TrainSetDaoImpl implements TrainSetDao {

    private MysqlService mysqlService;
    private ProductDao productDao;

    private static final Logger LOGGER = Logger.getLogger(TrainSetDaoImpl.class.getName());

    public TrainSetDaoImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void addTrainSet(TrainSet trainSet) {
        // Implement logic to add a train set to the database
    }

    @Override
    public TrainSet getTrainSet(String id) {
        // Implement logic to retrieve a train set from the database
        return null;
    }

    // @Override
    // public List<TrainSet> getAllTrainSets() {
    // //Implement logic to retrieve all train sets from the database
    // List<TrainSet> trainSets = new ArrayList<>();
    // String sql = "SELECT ts.product_code, p.product_name, p.brand_name,
    // p.retail_price " +
    // "FROM train_set ts JOIN product p ON ts.product_code = p.product_code";
    // try (Connection conn = mysqlService.getConnection();
    // PreparedStatement stmt = conn.prepareStatement(sql);
    // ResultSet rs = stmt.executeQuery()) {

    // while (rs.next()) {
    // TrainSet trainSet = new TrainSet();
    // trainSet.setProductCode(rs.getString("product_code"));
    // trainSet.setProductName(rs.getString("product_name"));
    // trainSet.setBrandName(rs.getString("brand_name"));
    // trainSet.setRetailPrice(rs.getBigDecimal("retail_price"));
    // trainSets.add(trainSet);
    // }
    // } catch (SQLException e) {
    // e.printStackTrace();
    // }
    // return trainSets;
    // }

    @Override
    public List<TrainSet> getAllTrainSets() {
        List<TrainSet> trainSets = new ArrayList<>();
        String sql = "SELECT ts.product_code, p.product_name, p.brand_name, p.retail_price, p.gauge_type " +
                "FROM train_set ts JOIN product p ON ts.product_code = p.product_code";
        try (Connection conn = mysqlService.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
<<<<<<< HEAD

=======
                TrainSet trainSet = TrainSet.fromResultSet(rs);
>>>>>>> 54baf0e598c22aa3119dc855bb7d89d0d799bf1d
                trainSets.add(trainSet);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error in getting all train sets", e); 
            throw new RuntimeException("Database operation failed", e)
;        }
        return trainSets;
    }

    @Override
    public void updateTrainSet(TrainSet trainSet) {
        // Implement logic to update a train set's information in the database
    }

    @Override
    public void deleteTrainSet(String id) {
        // Implement logic to delete a train set from the database
    }
}
