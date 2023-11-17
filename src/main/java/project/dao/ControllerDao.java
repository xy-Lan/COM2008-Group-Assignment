package project.dao;


import project.model.product.Controller;

import java.util.List;

public interface ControllerDao {
    void addController(Controller controller); // Add a controller to the database
    Controller getController(String id);       // Retrieve a controller from the database by ID
    List<Controller> getAllControllers();      // Retrieve all controllers from the database
    void updateController(Controller controller); // Update a controller in the database
    void deleteController(String id);          // Delete a controller from the database by ID
}
