
package com.example.demo.service;

import com.example.demo.dao.VenueDao;
import com.example.demo.model.Venue;
import com.example.demo.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class VenueService implements VenueDao {
    @Autowired
    VenueRepository venueRepository;
    @Override
    public List<Venue> getAllVenue() {
        List<Venue> al = new ArrayList<>();
        venueRepository.findAll().forEach(al::add);
        return al;
    }

    @Override
    public Venue getById(long id) {
        Venue v = venueRepository.findById(id).get();
        return v;
    }
    
    public List<Venue> getVenueActive(){
        return venueRepository.findVenueActive();
    }

    @Override
    public void SaveOrUpdate(Venue a) {
        venueRepository.save(a);
    }

    @Override
    public void deleteVenue(long id) {
        venueRepository.deleteById(id);
    }

    @Override
    public void deleteVenue(Venue a) {
        venueRepository.delete(a);
    }
}
