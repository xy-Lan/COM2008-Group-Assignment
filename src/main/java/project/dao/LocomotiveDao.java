package project.dao;

import project.model.product.Locomotive;

import java.util.List;

public interface LocomotiveDao {
    void addLocomotive(Locomotive locomotive); // Add a locomotive to the database
    Locomotive getLocomotive(String id);       // Retrieve a locomotive from the database by ID
    List<Locomotive> getAllLocomotives();      // Retrieve all locomotives from the database
    void updateLocomotive(Locomotive locomotive); // Update a locomotive in the database
    void deleteLocomotive(String id);          // Delete a locomotive from the database by ID
}
