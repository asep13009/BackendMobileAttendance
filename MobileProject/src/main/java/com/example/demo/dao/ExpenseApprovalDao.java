package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.ExpenseApproval;

public interface ExpenseApprovalDao {
		public ExpenseApproval getById(Long idE, Long idA);
		public List<ExpenseApproval> getExpenseApprovalByExpense(Long e);
		public List<ExpenseApproval> getExpenseApprovalByApproval(Long a);
	 	public List<ExpenseApproval> getAllExpenseApproval();
	 	public List<ExpenseApproval> getActiveExpenseApproval();
	 	public void SaveOrUpdate(ExpenseApproval a);
	    public void deleteExpenseApproval(long id);
	    public void deleteExpenseApproval(ExpenseApproval a);
}
