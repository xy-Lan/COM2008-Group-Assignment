package project.dao;

import project.model.product.Track;

import java.util.List;

public interface TrackDao {
    void addTrack(Track track); // Add a track to the database
    Track getTrack(String id);  // Retrieve a track from the database by ID
    List<Track> getAllTracks(); // Retrieve all tracks from the database
    void updateTrack(Track track); // Update a track in the database
    void deleteTrack(String id);   // Delete a track from the database by ID
}
