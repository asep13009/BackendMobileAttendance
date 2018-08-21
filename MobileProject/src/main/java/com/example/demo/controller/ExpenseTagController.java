package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ExpenseKategori;
import com.example.demo.model.ExpenseTag;
import com.example.demo.model.Tag;
import com.example.demo.service.ExpenseKategoriService;
import com.example.demo.service.ExpenseTagService;
import com.example.demo.service.TagService;

@RestController
public class ExpenseTagController {
	
	@Autowired
	ExpenseTagService expenseTagService;
	
	@Autowired
	ExpenseKategoriService expenseKategoriService;
	
	@Autowired
	TagService tagService;
	
	// Insert expensetag
	@PostMapping(value = "/insertexpensetag")
	public boolean insertExpenseTag(@RequestParam("idExpense") long idExpense, @RequestParam("idTag") long idTag) {
		ExpenseKategori expense = expenseKategoriService.getKategori(idExpense);
		Tag tag = tagService.getById(idTag);
		expenseTagService.saveOrUpdate(expense, tag);
		return true;
	}
	
	// Get expensetag by id
	@GetMapping(value = "/getexpensetag")
	public ExpenseTag getExpenseTag(@RequestParam("idExpense") long idExpense, @RequestParam("idTag") long idTag) {
		ExpenseKategori expense = expenseKategoriService.getKategori(idExpense);
		Tag tag = tagService.getById(idTag);
		return expenseTagService.getById(expense, tag);
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
	
	// Non aktifkan expensetag
	@PostMapping(value = "/deleteexpensetag")
	public ExpenseTag deleteExpenseTag(@RequestParam("idExpense") long idExpense, @RequestParam("idTag") long idTag) {
		ExpenseTag et = expenseTagService.getById(idExpense, idTag);
		expenseTagService.hapus(et);
		return et;
	}
	
	// Tampilkan semua expensetag
	@GetMapping(value = "/expensetagall")
	public List<ExpenseTag> getAllExpenseTag(){
		return expenseTagService.getAll();
	}
	
	// Tampilkan semua expensetag aktif
	@GetMapping(value = "/expensetagactive")
	public List<ExpenseTag> getActiveExpenseTag(){
		return expenseTagService.getAllActive();
	}
	
	// Tampilkan expensetag berdassarkan expense
	@GetMapping(value = "/expensetagbyexpense")
	public List<ExpenseTag> getExpenseTagByExpense(@RequestParam("idExpense") long idExpense){
		return expenseTagService.getByExpense(idExpense);
	}
	
	// Tampilkan expensetag berdassarkan tag
	@GetMapping(value = "/expensetagbytag")
	public List<ExpenseTag> getExpenseTagByTag(@RequestParam("idTag") long idTag){
		return expenseTagService.getByTag(idTag);
	}

	

}
