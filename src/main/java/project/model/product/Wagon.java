package project.model.product;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import project.model.product.abstractproduct.*;
import project.model.product.enums.*;

public class Wagon extends Part {

	private WagonType wagonType;
	private Era era;

	public Wagon(String productCode, String brandName, String productName, BigDecimal retailPrice, Gauge gaugeType, WagonType wagonType, Era era) {
        super(productCode, brandName, productName, retailPrice, gaugeType);
        this.wagonType = wagonType;
        this.era = era;
    }
    
	// Static method to create a Wagon instance from a ResultSet
	public static Wagon fromResultSet(ResultSet resultSet) throws SQLException {
        String productCode = resultSet.getString("product_code");
        String brandName = resultSet.getString("brand_name");
        String productName = resultSet.getString("product_name");
        BigDecimal retailPrice = resultSet.getBigDecimal("retail_price");
        Gauge gaugeType = Gauge.valueOf(resultSet.getString("gauge_type"));
        WagonType wagonType = WagonType.valueOf(resultSet.getString("wagon_type"));
        Era era = Era.valueOf(resultSet.getString("era")); 

        return new Wagon(productCode, brandName, productName, retailPrice, gaugeType, wagonType, era);
    }

}