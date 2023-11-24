package project.model.product;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project.model.product.abstractproduct.*;
import project.model.product.enums.*;


public class TrackPack extends BoxedSet {

	private TrackPackType packType;

	public TrackPack(String productCode, String brandName, String productName, BigDecimal retailPrice, Gauge gaugeType, TrackPackType packType ) {
        super(productCode, brandName, productName, retailPrice, gaugeType);
        this.packType = packType;
    }
    
	// Static method to create a TrackPack instance from a ResultSet
	public static TrackPack fromResultSet(ResultSet resultSet) throws SQLException {
        String productCode = resultSet.getString("product_code");
        String brandName = resultSet.getString("brand_name");
        String productName = resultSet.getString("product_name");
        BigDecimal retailPrice = resultSet.getBigDecimal("retail_price");
        Gauge gaugeType = Gauge.valueOf(resultSet.getString("gauge_type")); 
        TrackPackType packType = TrackPackType.valueOf(resultSet.getString("pack_type")); 

        return new TrackPack(productCode, brandName, productName, retailPrice, gaugeType, packType);
    }

    @Override
    public String getSubclassTableSql() {
        return "INSERT INTO track_pack (product_code, pack_type) VALUES (?, ?)";
    }

    @Override
    public void setSubclassTableParameters(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, this.getProductCode());
        preparedStatement.setString(2, this.packType.name());
    }

    public TrackPackType getPackType() {
        return packType;
    }

    public void setPackType(TrackPackType packType) {
        this.packType = packType;
    }
}