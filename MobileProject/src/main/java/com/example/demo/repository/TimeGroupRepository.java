package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.TimeGroup;


public interface TimeGroupRepository extends CrudRepository<TimeGroup, Long> {
	@Query(value = "SELECT t from  TimeGroup t where t.status='Active'")
    List<TimeGroup> findTimeGroupActive();
}
