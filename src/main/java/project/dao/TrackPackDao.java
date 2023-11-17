package project.dao;

import project.model.product.TrackPack;

import java.util.List;

public interface TrackPackDao {
    void addTrackPack(TrackPack trackPack); // Add a track pack to the database
    TrackPack getTrackPack(String id);       // Retrieve a track pack from the database by ID
    List<TrackPack> getAllTrackPacks();     // Retrieve all track packs from the database
    void updateTrackPack(TrackPack trackPack); // Update a track pack in the database
    void deleteTrackPack(String id);        // Delete a track pack from the database by ID
}
