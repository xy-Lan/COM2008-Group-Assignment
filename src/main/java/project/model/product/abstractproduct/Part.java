package project.model.product.abstractproduct;

import java.math.BigDecimal;

import project.model.product.enums.Gauge;

public abstract class Part extends Product {

    private String productCode;
    private String brandName;
    private String productName;
    private BigDecimal retailPrice;
    private Gauge gaugeType;

    public Part(String productCode, String brandName, String productName, BigDecimal retailPrice, Gauge gaugeType) {
        super(productCode, brandName, productName, retailPrice, gaugeType);
    }
}