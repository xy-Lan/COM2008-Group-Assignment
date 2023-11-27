package project.model.product.abstractproduct;

import java.math.BigDecimal;
import java.util.List;

import project.model.product.association.PartBoxedSetAssociation;
import project.model.product.enums.Gauge;

public abstract class BoxedSet extends Product {
     private String productCode;
     private String brandName;
     private String productName;
     private BigDecimal retailPrice;
     private Gauge gaugeType;
     public BoxedSet(String productCode, String brandName, String productName, BigDecimal retailPrice,
               Gauge gaugeType) {
          super(productCode, brandName, productName, retailPrice, gaugeType);
     }

     private List<PartBoxedSetAssociation> associations;
    
}