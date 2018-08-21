package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ExpenseTagDao;
import com.example.demo.model.ExpenseKategori;
import com.example.demo.model.ExpenseTag;
import com.example.demo.model.Tag;
import com.example.demo.repository.ExpenseTagRepository;

@Service
public class ExpenseTagService implements ExpenseTagDao{

	@Autowired
	ExpenseTagRepository expenseTagRepository;
	
	@Autowired
	ExpenseKategoriService expenseKategoriService;
	
	@Autowired
	TagService tagService;
	
	@Override
	public void saveOrUpdate(ExpenseKategori expense, Tag tag) {
		ExpenseTag et = new ExpenseTag(expense.getId(), tag.getId());
		expenseTagRepository.save(et);		
	}

	@Override
	public void saveOrUpdate(ExpenseTag et) {
		expenseTagRepository.save(et);		
	}

	@Override
	public void hapus(ExpenseTag et) {
		et.setStatus("Not Active");
		expenseTagRepository.save(et);
	}

	@Override
	public void delete(ExpenseTag et) {
		expenseTagRepository.delete(et);		
	}

	@Override
	public ExpenseTag getById(ExpenseKategori expense, Tag tag) {
		ExpenseTag ek = expenseTagRepository.getByIdIdExpenseAndIdIdTag(expense.getId(), tag.getId());
		return ek;
	}

	@Override
	public ExpenseTag getById(Long idExpense, Long idTag) {
		return expenseTagRepository.getByIdIdExpenseAndIdIdTag(idExpense, idTag);
	}

	@Override
	public List<ExpenseTag> getAll() {
		List<ExpenseTag> let = new ArrayList<>();
		expenseTagRepository.findAll().forEach(let::add);
		return let;
	}

	@Override
	public List<ExpenseTag> getAllActive() {
		List<ExpenseTag> let = new ArrayList<>();
		expenseTagRepository.findByStatus().forEach(let::add);
		return let;
	}

	@Override
	public List<ExpenseTag> getByExpense(Long idExpense) {
		List<ExpenseTag> let = new ArrayList<>();
		expenseTagRepository.findByIdIdExpense(idExpense).forEach(let::add);
		return let;
	}

	@Override
	public List<ExpenseTag> getByTag(Long idTag) {
		List<ExpenseTag> let = new ArrayList<>();
		expenseTagRepository.findByIdIdTag(idTag).forEach(let::add);
		return let;
	}

}
