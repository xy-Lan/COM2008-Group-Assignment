package com.system.model.product.association;

import com.system.model.product.abstractproduct.BoxedSet;
import com.system.model.product.abstractproduct.Part;

public class BoxedSetAssociation {
    private BoxedSet boxedSet;
    private Part part;
    private int quantity;  

    public BoxedSetAssociation(BoxedSet boxedSet, Part part, int quantity) {
        this.boxedSet = boxedSet;
        this.part = part;
        this.quantity = quantity;
    }
}
