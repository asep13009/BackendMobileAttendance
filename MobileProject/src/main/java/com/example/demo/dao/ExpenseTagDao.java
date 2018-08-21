package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.ExpenseKategori;
import com.example.demo.model.ExpenseTag;
import com.example.demo.model.Tag;

public interface ExpenseTagDao {
	
	public void saveOrUpdate(ExpenseKategori expense, Tag tag);
	public void saveOrUpdate(ExpenseTag et);
	public void hapus(ExpenseTag et);
	public void delete(ExpenseTag et);
	public ExpenseTag getById(ExpenseKategori expense, Tag tag);
	public ExpenseTag getById(Long idExpense, Long idTag);
	public List<ExpenseTag> getAll();
	public List<ExpenseTag> getAllActive();
	public List<ExpenseTag> getByExpense(Long idExpense);
	public List<ExpenseTag> getByTag(Long idTag);

}
