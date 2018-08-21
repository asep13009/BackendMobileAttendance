package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Status;

@Repository
public interface StatusRepository extends CrudRepository<Status, Long>{
	
	Status getById(Long id);
	 @Query(value = "SELECT t from  Team t where t.status='Active'")
	  List<Status> findStatusActive();
}
