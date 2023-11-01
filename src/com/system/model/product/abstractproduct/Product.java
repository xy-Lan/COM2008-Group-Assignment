package com.system.model.product.abstractproduct;
import com.system.model.order.*;
import com.system.model.product.enums.Gauge;

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