package com.example.demo.repository;

import com.example.demo.model.Venue;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository extends CrudRepository<Venue,Long> {
	 @Query(value = "SELECT v from  Venue v where v.status='Active'")
	    List<Venue> findVenueActive();
}
