package project.model.product.association;

import project.model.product.abstractproduct.BoxedSet;
import project.model.product.abstractproduct.Part;

import java.util.ArrayList;
import java.util.List;

public class PartBoxedSetAssociation {
    private BoxedSet boxedSet;
    private Part part;
    private int quantity;

    public PartBoxedSetAssociation(BoxedSet boxedSet, Part part, int quantity) {
        this.boxedSet = boxedSet;
        this.part = part;
        this.quantity = quantity;
    }

    public BoxedSet getBoxedSet() {
        return boxedSet;
    }

    public void setBoxedSet(BoxedSet boxedSet) {
        this.boxedSet = boxedSet;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private List<PartBoxedSetAssociation> associations;

    // Getter for the associations list
    public List<PartBoxedSetAssociation> getAssociations() {
        return associations;
    }

    // Setter for the associations list
    public void setAssociations(List<PartBoxedSetAssociation> associations) {
        this.associations = associations;
    }

    // Method to add a single association to the list
    public void addAssociation(PartBoxedSetAssociation association) {
        if (this.associations == null) {
            this.associations = new ArrayList<>();
        }
        this.associations.add(association);
    }

    // Method to remove a single association from the list
    public void removeAssociation(PartBoxedSetAssociation association) {
        if (this.associations != null) {
            this.associations.remove(association);
        }
    }
}
