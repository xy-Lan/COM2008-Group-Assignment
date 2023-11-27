package project.model.product.association;

import project.model.product.abstractproduct.BoxedSet;
import project.model.product.abstractproduct.Part;

public class PartBoxedSetAssociation {
    private BoxedSet boxedSet;
    private Part part;
    private int quantity;  

    public PartBoxedSetAssociation(BoxedSet boxedSet, Part part, int quantity) {
        this.boxedSet = boxedSet;
        this.part = part;
        this.quantity = quantity;
    }
}
