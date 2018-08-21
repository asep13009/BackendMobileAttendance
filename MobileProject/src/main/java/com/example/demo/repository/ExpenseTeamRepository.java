package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ExpenseTeam;
import com.example.demo.model.ExpenseTeamPK;

@Repository
public interface ExpenseTeamRepository extends CrudRepository<ExpenseTeam, ExpenseTeamPK>{
	
	@Query(value = "select et from ExpenseTeam et where et.id.idExpense=:idExpense and et.id.idTeam=:idTeam and et.status='Active'")
	ExpenseTeam getByIdIdExpenseAndIdIdTeam(@Param("idExpense") Long idExpense, @Param("idTeam") Long idTeam);
	
	@Query(value = "select et from ExpenseTeam et where et.id.idExpense=:idExpense and et.status='Active'")
	List<ExpenseTeam> findByIdIdExpense(@Param("idExpense") Long idExpense);
	
	@Query(value = "select et from ExpenseTeam et where et.id.idTeam=:idTeam and et.status='Active'")
	List<ExpenseTeam> findByIdIdTeam(@Param("idTeam") Long idTeam);
	
	@Query(value = "select et from ExpenseTeam et where et.status='Active'")
	List<ExpenseTeam> findByStatus();

}
