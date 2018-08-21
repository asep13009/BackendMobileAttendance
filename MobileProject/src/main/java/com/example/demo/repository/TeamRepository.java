package com.example.demo.repository;

import com.example.demo.model.Team;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<Team,Long> {
	 @Query(value = "SELECT t from  Team t where t.status='Active'")
	    List<Team> findTeamActive();
}
