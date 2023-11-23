package project.model.product.abstractproduct;

import java.math.BigDecimal;

import project.model.product.enums.Gauge;

public abstract class Part extends Product {

    public Part(String productCode, String brandName, String productName, BigDecimal retailPrice, Gauge gaugeType) {
    }
}