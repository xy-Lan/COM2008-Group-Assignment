package project.dao;

import project.model.product.Wagon;

import java.util.List;

public interface WagonDao {
    void addWagon(Wagon wagon); // Add a wagon to the database
    Wagon getWagon(String id);  // Retrieve a wagon from the database by ID
    List<Wagon> getAllWagons(); // Retrieve all wagons from the database
    void updateWagon(Wagon wagon); // Update a wagon in the database
    void deleteWagon(String id);   // Delete a wagon from the database by ID
}
