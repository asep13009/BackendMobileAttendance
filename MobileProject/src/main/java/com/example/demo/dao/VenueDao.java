package com.example.demo.dao;

import com.example.demo.model.Venue;

import java.util.List;

public interface VenueDao {
    public List<Venue> getAllVenue();
    public Venue getById(long id);
    public void SaveOrUpdate(Venue a);
    public void deleteVenue(long id);
    public void deleteVenue(Venue a);
}
