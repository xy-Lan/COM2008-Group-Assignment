package main.java.com.system.model.product.abstractproduct;
import main.java.com.system.model.order.*;
import main.java.com.system.model.product.enums.Gauge;

import java.math.BigDecimal;
import java.util.*;

public abstract class Product {

	Collection<OrderLine> containsProduct;
	private String productCode;
	private String brandName;
	private String productName;
	private BigDecimal retailPrice;
	private Gauge gaugeType;

}