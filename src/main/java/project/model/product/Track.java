package project.model.product;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import project.model.product.abstractproduct.*;
import project.model.product.enums.*;


public class Track extends Part {

	private TrackType trackType;

	public Track(String productCode, String brandName, String productName, BigDecimal retailPrice, Gauge gaugeType, TrackType trackType) {
        super(productCode, brandName, productName, retailPrice, gaugeType);
        this.trackType = trackType;
    }
    
	// Static method to create a Track instance from a ResultSet
	public static Track fromResultSet(ResultSet resultSet) throws SQLException {
        String productCode = resultSet.getString("product_code");
        String brandName = resultSet.getString("brand_name");
        String productName = resultSet.getString("product_name");
        BigDecimal retailPrice = resultSet.getBigDecimal("retail_price");
        Gauge gaugeType = Gauge.valueOf(resultSet.getString("gauge_type")); 
        TrackType trackType = TrackType.valueOf(resultSet.getString("track_type"));

        return new Track(productCode, brandName, productName, retailPrice, gaugeType, trackType);
    }

    @Override
    public String getSubclassTableSql() {
        return "INSERT INTO track (product_code, track_type) VALUES (?, ?)";
    }

    @Override
    public void setSubclassTableParameters(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, this.getProductCode());
        preparedStatement.setString(2, this.trackType.name());
    }


    public TrackType getTrackType() {
        return trackType;
    }

    public void setTrackType(TrackType trackType) {
        this.trackType = trackType;
    }
}