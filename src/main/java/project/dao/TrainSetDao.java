package project.dao;

import project.model.product.TrainSet;

import java.util.List;

public interface TrainSetDao {
    void addTrainSet(TrainSet trainSet); // Add a train set to the database
    TrainSet getTrainSet(String id);      // Retrieve a train set from the database by ID
    List<TrainSet> getAllTrainSets();     // Retrieve all train sets from the database
    void updateTrainSet(TrainSet trainSet); // Update a train set in the database
    void deleteTrainSet(String id);       // Delete a train set from the database by ID
}
