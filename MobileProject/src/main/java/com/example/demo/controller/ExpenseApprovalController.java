package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ExpenseApproval;
import com.example.demo.service.ApprovalService;
import com.example.demo.service.ExpenseApprovalService;
import com.example.demo.service.ExpenseKategoriService;
import com.example.demo.service.KaryawanService;

@RestController
public class ExpenseApprovalController {
	
	@Autowired
	ExpenseApprovalService expenseApprovalService;
	
	@Autowired
	KaryawanService karyawanService;
	
	@Autowired
	ApprovalService approvalService;
	
	@Autowired
	ExpenseKategoriService expenseKategoriService;
	
	// Insert expense approval
	@PostMapping(value = "/insertexpenseapproval")
	public boolean insertExpenseApproval(@RequestParam("namaApproval") String namaApproval, @RequestParam("rule") String rule, 
											@RequestParam("idExpense") Long idExpense, 
											@RequestParam("idApproval") Long idApproval,
											@RequestParam("idKaryawan") Long idKaryawan) {
		ExpenseApproval ea = new ExpenseApproval(idExpense, idApproval);
		ea.setIdKaryawan(karyawanService.getById(idKaryawan));
		ea.setNamaApproval(namaApproval);
		ea.setRule(rule);
		expenseApprovalService.SaveOrUpdate(ea);
		return true;
	}
	
	// Update expense approval
	@PutMapping(value = "/updateexpenseapproval")
	public boolean updateExpenseApproval(@RequestParam("namaApproval") String namaApproval, @RequestParam("rule") String rule, 
											@RequestParam("idExpense") long idExpense, 
											@RequestParam("idApproval") long idApproval
											) {
		ExpenseApproval ex = expenseApprovalService.getById(idExpense, idApproval);
		ex.setIdKaryawan(karyawanService.getById(1L));
		ex.setNamaApproval(namaApproval);
		ex.setRule(rule);
		expenseApprovalService.SaveOrUpdate(ex);
		return true;
	}
	
	// Menampilkan expense approval by approval
	@GetMapping(value = "/expenseapprovalbyapproval")
	public List<ExpenseApproval> getExpenseApprovalByApproval(@RequestParam("idApproval") Long idApproval) {
		return expenseApprovalService.getExpenseApprovalByApproval(idApproval);
	}
	
	// Menampilkan expense approval by expense
	@GetMapping(value = "/expenseapprovalbyexpense")
	public List<ExpenseApproval> getExpenseApprovalByExpense(@RequestParam("idExpense") Long idExpense){
		return expenseApprovalService.getExpenseApprovalByExpense(idExpense);
	}
	
	// Disable expense approval
	@PostMapping(value = "/deleteexpenseapproval")
	public boolean deleteExpenseApproval(@RequestParam("idExpense") Long idExpense, 
											@RequestParam("idApproval") Long idApproval) {
		ExpenseApproval ex = expenseApprovalService.getById(idExpense, idApproval);
		ex.setStatus("Not Active");
		expenseApprovalService.SaveOrUpdate(ex);
		return true;
	}
	
	// Menampilkan expense approval yang aktif
	@GetMapping(value = "/activeexpenseapproval")
	public List<ExpenseApproval> getActiveExpenseApproval(){
		return expenseApprovalService.getActiveExpenseApproval();
	}
	
	

}
