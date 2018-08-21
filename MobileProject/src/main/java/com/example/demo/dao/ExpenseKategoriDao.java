package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.ExpenseKategori;

public interface ExpenseKategoriDao {
	
	public ExpenseKategori getKategori(Long id);
	public List<ExpenseKategori> getAllExpenseKategori();
	public void SaveOrUpdate(ExpenseKategori a);
	public void deleteExpenseKategori(long id);
	public void deleteExpenseKategori(ExpenseKategori a);
}
