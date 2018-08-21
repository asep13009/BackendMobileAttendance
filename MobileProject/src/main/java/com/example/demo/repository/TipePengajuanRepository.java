package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TipePengajuan;

import java.util.List;

@Repository
public interface TipePengajuanRepository extends CrudRepository<TipePengajuan, Long>{

	TipePengajuan getById(Long id);
	@Query(value = "select a from TipePengajuan a where a.status='Active'")
	List<TipePengajuan> gettipePengajuanactive();

}
