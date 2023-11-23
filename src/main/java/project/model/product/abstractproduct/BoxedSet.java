package project.model.product.abstractproduct;

import java.math.BigDecimal;
import java.util.List;

import project.model.product.association.BoxedSetAssociation;
import project.model.product.enums.Gauge;

public abstract class BoxedSet extends Product {
     public BoxedSet(String productCode, String brandName, String productName, BigDecimal retailPrice,
               Gauge gaugeType) {
     }

     private List<BoxedSetAssociation> associations;
    
}