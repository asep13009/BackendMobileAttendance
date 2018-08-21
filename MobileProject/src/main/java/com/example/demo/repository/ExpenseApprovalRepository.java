package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ExpenseApproval;

@Repository
public interface ExpenseApprovalRepository extends CrudRepository<ExpenseApproval,Long>{
	
	@Query
	(value = "SELECT * FROM expense_approval ea WHERE ea.id_expense=:idExpense AND ea.status='Active'", nativeQuery = true)
	List<ExpenseApproval> findByIdIdExpense(@Param("idExpense") Long ek);
	@Query
	(value = "SELECT * FROM expense_approval ea WHERE ea.id_approval=:idApproval AND ea.status='Active'", nativeQuery = true)
	List<ExpenseApproval> findByIdIdApproval(@Param("idApproval") Long ek);
	@Query
	(value = "select ea from ExpenseApproval ea where ea.id.idExpense=:idExpense and ea.id.idApproval=:idApproval and ea.status='Active'")
	ExpenseApproval findByIdIdExpenseAndIdIdApproval(@Param("idExpense") Long idExpense, @Param ("idApproval") Long idApproval);
	@Query
	(value = "select ea from ExpenseApproval ea where ea.status='Active'")
	List<ExpenseApproval> getAll();

}
