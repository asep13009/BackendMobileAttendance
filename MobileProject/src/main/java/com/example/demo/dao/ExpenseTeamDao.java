package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.ExpenseKategori;
import com.example.demo.model.ExpenseTeam;
import com.example.demo.model.Team;

public interface ExpenseTeamDao {
	
	public void saveOrUpdate(ExpenseKategori expense, Team team);
	public void saveOrUpdate(ExpenseTeam et);
	public void hapus(ExpenseTeam et);
	public void delete(ExpenseTeam et);
	public ExpenseTeam getById(ExpenseKategori expense, Team team);
	public ExpenseTeam getById(Long idExpense, Long idTeam);
	public List<ExpenseTeam> getAll();
	public List<ExpenseTeam> getAllActive();
	public List<ExpenseTeam> getByExpense(Long idExpense);
	public List<ExpenseTeam> getByTeam(Long idTeam);

}
