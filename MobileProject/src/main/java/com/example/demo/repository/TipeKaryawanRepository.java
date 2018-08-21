package com.example.demo.repository;

import com.example.demo.model.TipeKaryawan;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipeKaryawanRepository extends CrudRepository<TipeKaryawan,Long> {
	 @Query(value = "SELECT tk from  TipeKaryawan tk where tk.status='Active'")
	    List<TipeKaryawan> findTipeKaryawanActive();
}
