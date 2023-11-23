package project.model.product;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import project.model.product.*;
import project.model.product.abstractproduct.*;
import project.model.product.enums.*;

public class Carriage extends Part {

	private CarriageType carriageType;
	private Era era;

	public Carriage(String productCode, String brandName, String productName, BigDecimal retailPrice, Gauge gaugeType, CarriageType carriageType, Era era) {
        super(productCode, brandName, productName, retailPrice, gaugeType);
        this.carriageType = carriageType;
        this.era = era;
    }
    
	// Static method to create a Carriage instance from a ResultSet
    public static Carriage fromResultSet(ResultSet resultSet) throws SQLException {
        String productCode = resultSet.getString("product_code");
        String brandName = resultSet.getString("brand_name");
        String productName = resultSet.getString("product_name");
        BigDecimal retailPrice = resultSet.getBigDecimal("retail_price");
        Gauge gaugeType = Gauge.valueOf(resultSet.getString("gauge_type")); 
        CarriageType carriageType = CarriageType.valueOf(resultSet.getString("carriage_type")); 
        Era era = Era.valueOf(resultSet.getString("era"));

        return new Carriage(productCode, brandName, productName, retailPrice, gaugeType, carriageType, era);
    }

}