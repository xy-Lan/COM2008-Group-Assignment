package project.model.product.abstractproduct;
import java.math.BigDecimal;
import java.util.*;

import project.model.order.*;
import project.model.product.enums.Gauge;

public abstract class Product {

	Collection<OrderLine> containsProduct;
	private String productCode;
	private String brandName;
	private String productName;
	private BigDecimal retailPrice;
	private Gauge gaugeType;

}