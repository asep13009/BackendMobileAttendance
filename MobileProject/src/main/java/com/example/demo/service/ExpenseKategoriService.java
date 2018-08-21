package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ExpenseKategoriDao;
import com.example.demo.model.ExpenseKategori;
import com.example.demo.repository.ExpenseKategoriRepository;

@Service
public class ExpenseKategoriService implements ExpenseKategoriDao{
	
	@Autowired
	ExpenseKategoriRepository ekr;
	
	@Override
	public ExpenseKategori getKategori(Long id) {
		return ekr.findById(id).get();
	}

	@Override
	public List<ExpenseKategori> getAllExpenseKategori() {
		 List<ExpenseKategori> al = new ArrayList<>();
		 ekr.findAll().forEach(al::add);
	     return al;
	}

	@Override
	public void SaveOrUpdate(ExpenseKategori a) {
		ekr.save(a);
		
	}

	@Override
	public void deleteExpenseKategori(long id) {
		ekr.deleteById(id);
		
	}

	@Override
	public void deleteExpenseKategori(ExpenseKategori a) {
		ekr.delete(a);
		
	}
	
	public List<ExpenseKategori>getexpensekategoriactive(){
		return ekr.findExpenseKategoriActive();
	}

}
