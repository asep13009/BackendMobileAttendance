package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ExpenseTeamDao;
import com.example.demo.model.ExpenseKategori;
import com.example.demo.model.ExpenseTeam;
import com.example.demo.model.Team;
import com.example.demo.repository.ExpenseTeamRepository;

@Service
public class ExpenseTeamService implements ExpenseTeamDao{
	
	@Autowired
	ExpenseTeamRepository expenseTeamRepository;

	@Override
	public void saveOrUpdate(ExpenseKategori expense, Team team) {
		ExpenseTeam et = new ExpenseTeam(expense.getId(), team.getId());
		expenseTeamRepository.save(et);			
	}

	@Override
	public void saveOrUpdate(ExpenseTeam et) {
		expenseTeamRepository.save(et);		
	}

	@Override
	public void hapus(ExpenseTeam et) {
		et.setStatus("Not Active");
		expenseTeamRepository.save(et);
	}

	@Override
	public void delete(ExpenseTeam et) {
		expenseTeamRepository.delete(et);		
	}

	@Override
	public ExpenseTeam getById(ExpenseKategori expense, Team team) {
		ExpenseTeam et = expenseTeamRepository.getByIdIdExpenseAndIdIdTeam(expense.getId(), team.getId());
		return et;
	}

	@Override
	public ExpenseTeam getById(Long idExpense, Long idTeam) {
		return expenseTeamRepository.getByIdIdExpenseAndIdIdTeam(idExpense, idTeam);
	}

	@Override
	public List<ExpenseTeam> getAll() {
		List<ExpenseTeam> let = new ArrayList<>();
		expenseTeamRepository.findAll().forEach(let::add);
		return let;
	}

	@Override
	public List<ExpenseTeam> getAllActive() {
		List<ExpenseTeam> let = new ArrayList<>();
		expenseTeamRepository.findByStatus().forEach(let::add);
		return let;
	}

	@Override
	public List<ExpenseTeam> getByExpense(Long idExpense) {
		List<ExpenseTeam> let = new ArrayList<>();
		expenseTeamRepository.findByIdIdExpense(idExpense).forEach(let::add);
		return let;
	}

	@Override
	public List<ExpenseTeam> getByTeam(Long idTeam) {
		List<ExpenseTeam> let = new ArrayList<>();
		expenseTeamRepository.findByIdIdTeam(idTeam).forEach(let::add);
		return let;
	}

}
