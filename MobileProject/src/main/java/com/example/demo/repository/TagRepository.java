package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long>{
	
	Tag getById(Long id);
	List<Tag> findAll();
	@Query(value = "SELECT a from  Tag a where a.status='Active'")
    List<Tag> findTagActive();
}
