package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TeamTag;
import com.example.demo.model.TeamTagPK;

@Repository
public interface TeamTagRepository extends CrudRepository<TeamTag, TeamTagPK>{

	@Query(value = "select tt from TeamTag tt where tt.id.idTeam=:idTeam and tt.id.idTag=:idTag and tt.status='Active'")
	TeamTag getByIdIdTeamAndIdIdTag(@Param("idTeam") Long idTeam, @Param("idTag") Long idTag);
	
	@Query(value = "select tt from TeamTag tt where tt.id.idTeam=:idTeam and tt.status='Active'")
	List<TeamTag> findByIdIdTeam(@Param("idTeam") Long idTeam);
	
	@Query(value = "select tt from TeamTag tt where tt.id.idTag=:idTag and tt.status='Active'")
	List<TeamTag> findByIdIdTag(@Param("idTag") Long idTag);
	
	@Query(value = "select tt from TeamTag tt where tt.status='Active'")
	List<TeamTag> findByStatus();
}
