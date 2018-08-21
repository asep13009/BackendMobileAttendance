package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ExpenseKategori;

@Repository
public interface ExpenseKategoriRepository extends CrudRepository<ExpenseKategori, Long> {
	 @Query(value = "SELECT l from  ExpenseKategori l where l.status='Active'")
	    List<ExpenseKategori> findExpenseKategoriActive();
	

}
