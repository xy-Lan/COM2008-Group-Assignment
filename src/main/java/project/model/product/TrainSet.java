package project.model.product;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project.model.product.abstractproduct.*;
import project.model.product.enums.*;


public class TrainSet extends BoxedSet {

    public TrainSet(String productCode, String brandName, String productName, BigDecimal retailPrice, Gauge gaugeType) {
        super(productCode, brandName, productName, retailPrice, gaugeType);   
    }
    
    // Static method to create a TrainSet instance from a ResultSet
    public static TrainSet fromResultSet(ResultSet resultSet) throws SQLException {
        String productCode = resultSet.getString("product_code");
        String brandName = resultSet.getString("brand_name");
        String productName = resultSet.getString("product_name");
        BigDecimal retailPrice = resultSet.getBigDecimal("retail_price");
        Gauge gaugeType = Gauge.valueOf(resultSet.getString("gauge_type")); 

        return new TrainSet(productCode, brandName, productName, retailPrice, gaugeType);

    }

    @Override
    public String getSubclassTableSql() {

        return "";
    }

    @Override
    public void setSubclassTableParameters(PreparedStatement preparedStatement) throws SQLException {

    }
}