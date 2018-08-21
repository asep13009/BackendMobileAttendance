package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Log;

@Repository
public interface LogRepository extends CrudRepository<Log, Long>{
	
	

}
