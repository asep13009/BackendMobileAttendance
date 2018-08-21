package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ExpenseTag;
import com.example.demo.model.ExpenseTagPK;

@Repository
public interface ExpenseTagRepository extends CrudRepository<ExpenseTag, ExpenseTagPK>{

	@Query(value = "select et from ExpenseTag et where et.id.idExpense=:idExpense and et.id.idTag=:idTag and et.status='Active'")
	ExpenseTag getByIdIdExpenseAndIdIdTag(@Param("idExpense") Long idExpense, @Param("idTag") Long idTag);
	
	@Query(value = "select et from ExpenseTag et where et.id.idExpense=:idExpense and et.status='Active'")
	List<ExpenseTag> findByIdIdExpense(@Param("idExpense") Long idExpense);
	
	@Query(value = "select et from ExpenseTag et where et.id.idTag=:idTag and et.status='Active'")
	List<ExpenseTag> findByIdIdTag(@Param("idTag") Long idTag);
	
	@Query(value = "select et from ExpenseTag et where et.status='Active'")
	List<ExpenseTag> findByStatus();
}
