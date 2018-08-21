package com.example.demo.repository;

import com.example.demo.model.Karyawan;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KaryawanRepository extends CrudRepository<Karyawan,Long> {
	 @Query(value = "SELECT k from  Karyawan k where k.status='Active'")
	    List<Karyawan> findKaryawanActive();
}
