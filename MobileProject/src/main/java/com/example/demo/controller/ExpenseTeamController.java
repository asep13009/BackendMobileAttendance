package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ExpenseKategori;
import com.example.demo.model.ExpenseTeam;
import com.example.demo.model.Team;
import com.example.demo.service.ExpenseKategoriService;
import com.example.demo.service.ExpenseTeamService;
import com.example.demo.service.TeamServices;

@RestController
public class ExpenseTeamController {
	
	@Autowired
	ExpenseTeamService expenseTeamService;
	
	@Autowired
	ExpenseKategoriService expenseKategoriService;
	
	@Autowired
	TeamServices teamService;
	
	// Insert expenseteam
	@PostMapping(value = "/insertexpenseteam")
	public boolean insertExpenseTeam(@RequestParam("idExpense") long idExpense, @RequestParam("idTeam") long idTeam) {
		ExpenseKategori expense = expenseKategoriService.getKategori(idExpense);
		Team team = teamService.getById(idTeam);
		expenseTeamService.saveOrUpdate(expense, team);
		return true;
	}
	
	// Get expenseteam by id
	@GetMapping(value = "/getexpenseteam")
	public ExpenseTeam getExpenseTeam(@RequestParam("idExpense") long idExpense, @RequestParam("idTeam") long idTeam) {
		ExpenseKategori expense = expenseKategoriService.getKategori(idExpense);
		Team team = teamService.getById(idTeam);		
		return expenseTeamService.getById(expense, team);
	}
	
//	@PutMapping(value = "/updateteamtag")
//	public boolean updateTeamTag(@RequestParam("idTeam") long idTeam, @RequestParam("idTag") long idTag) {
//		TeamTag tt = teamTagService.getById(idTeam, idTag);
//		Team team = teamService.getById(idTeam);
//		Tag tag = tagService.getById(idTag);
//		tt.se
//		teamTagService.saveOrUpdate(tt);
//		return true;
//	}
	
	// Non aktifkan expenseteam
	@PostMapping(value = "/deleteexpenseteam")
	public ExpenseTeam deleteExpenseTeam(@RequestParam("idExpense") long idExpense, @RequestParam("idTeam") long idTeam) {
		ExpenseTeam et = expenseTeamService.getById(idExpense, idTeam);
		expenseTeamService.hapus(et);
		return et;
	}
	
	// Tampilkan semua expenseteam
	@GetMapping(value = "/expenseteamall")
	public List<ExpenseTeam> getAllExpenseTeam(){
		return expenseTeamService.getAll();
	}
	
	// Tampilkan semua expenseteam aktif
	@GetMapping(value = "/expenseteamactive")
	public List<ExpenseTeam> getActiveExpenseTeam(){
		return expenseTeamService.getAllActive();
	}
	
	// Tampilkan expenseteam berdasarkan expense
	@GetMapping(value = "/expenseteambyexpense")
	public List<ExpenseTeam> getExpenseTeamByExpense(@RequestParam("idExpense") long idExpense){
		return expenseTeamService.getByExpense(idExpense);
	}
	
	// Tampilkan expenseteam berdassarkan team
	@GetMapping(value = "/expenseteambyteam")
	public List<ExpenseTeam> getExpenseTagByTag(@RequestParam("idTeam") long idTeam){
		return expenseTeamService.getByTeam(idTeam);
	}

}
