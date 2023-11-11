package project.model.inventory;
import project.model.user.*;

public class Inventory {

	private String updaterID;
	private String productCode;
	private Integer quantity;
	private User updater;

	private void checkStaffRole() {
        if (!updater.hasRole(Role.STAFF)) {
            throw new UnsupportedOperationException("Only staff can perform this operation.");
        }
    }

    public void increaseStock() {
        checkStaffRole();
        // TODO - implement Inventory.increaseStock
    }

    public void decreaseStock() {
        checkStaffRole();
        // TODO - implement Inventory.decreaseStock
    }

    public void checkStock() {
        checkStaffRole();
        // TODO - implement Inventory.checkStock
    }

}