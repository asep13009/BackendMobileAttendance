package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ExpenseApprovalDao;
import com.example.demo.model.ExpenseApproval;
import com.example.demo.repository.ExpenseApprovalRepository;

@Service
public class ExpenseApprovalService implements ExpenseApprovalDao{
	
	@Autowired
	ExpenseApprovalRepository expenseApprovalRepository;
	 
	@Override
	public List<ExpenseApproval> getAllExpenseApproval() {
		 List<ExpenseApproval> al = new ArrayList<>();
		 expenseApprovalRepository.findAll().forEach(al::add);
	     return al;
	}
	
	@Override
	public void SaveOrUpdate(ExpenseApproval a) {
		expenseApprovalRepository.save(a);
		
	}
	
	@Override
	public void deleteExpenseApproval(long id) {
		expenseApprovalRepository.deleteById(id);
		
	}
	@Override
	public void deleteExpenseApproval(ExpenseApproval a) {
		expenseApprovalRepository.delete(a);
		
	}

	@Override
	public List<ExpenseApproval> getExpenseApprovalByExpense(Long ek) {
		List<ExpenseApproval> lea = new ArrayList<>();
		expenseApprovalRepository.findByIdIdExpense(ek).forEach(lea::add);
		return lea;
	}

	@Override
	public ExpenseApproval getById(Long idE, Long idA) {
		return expenseApprovalRepository.findByIdIdExpenseAndIdIdApproval(idE, idA);
	}

	@Override
	public List<ExpenseApproval> getExpenseApprovalByApproval(Long a) {
		List<ExpenseApproval> lea = new ArrayList<>();
		expenseApprovalRepository.findByIdIdApproval(a).forEach(lea::add);
		return lea;
	}

	@Override
	public List<ExpenseApproval> getActiveExpenseApproval() {
		List<ExpenseApproval> lea = new ArrayList<>();
		expenseApprovalRepository.getAll().forEach(lea::add);
		return lea;
	}

}
