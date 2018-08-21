package com.example.demo.repository;


import com.example.demo.model.Jabatan;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JabatanRepository extends CrudRepository<Jabatan, Long> {
	@Query(value = "SELECT a from  Jabatan a where a.status='Active'")
    List<Jabatan> findJabatanActive();
}
