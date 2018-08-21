package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ExpenseKategori;
import com.example.demo.service.ExpenseKategoriService;
import com.example.demo.service.TipePengajuanService;

import de.odysseus.el.tree.impl.Parser.ParseException;
@RestController
public class ExpenseKategoriController {
	@Autowired
	ExpenseKategoriService expenseKategoriService;
	@Autowired
	TipePengajuanService  tipepengajuanservice;
	 
	 //Insert ExpenseKategori
	@RequestMapping(value = "/insertexpensekategori/",method = RequestMethod.POST,headers="Accept=application/json")
	public boolean inserExpenseKategori(          @RequestParam (value = "idtipepengajuan", required = false) Long idtipepengajuan,
	                                     @RequestParam(value = "nama_expense", required = false) String nama_expense,
	                                     @RequestParam(value = "budget_maks", required = false) int  budget_maks,
	                                     @RequestParam(value = "maks_transaksi", required = false) int maks_transaksi){
		
		ExpenseKategori expensekategori = new ExpenseKategori();
		
		expensekategori.setTipePengajuan(tipepengajuanservice.getById(idtipepengajuan));
		expensekategori.setNamaExpense(nama_expense);
		expensekategori.setBudgetMaks(budget_maks);
		expensekategori.setMaksTransaksi(maks_transaksi);
		expensekategori.setCreateDate(new Date());
		expenseKategoriService.SaveOrUpdate(expensekategori);
	     return true;
	}
	 //Update ExpenseKategori
	@RequestMapping(value = "/updateexpensekategori/",method = RequestMethod.POST,headers="Accept=application/json")
    public boolean updateExpenseKategori(@RequestParam(value = "id",required = false)  Long id,
    		 @RequestParam (value = "idtipepengajuan", required = false) Long idtipepengajuan,
             @RequestParam(value = "nama_expense", required = false) String nama_expense,
             @RequestParam(value = "budget_maks", required = false) int  budget_maks,
             @RequestParam(value = "maks_transaksi", required = false) int maks_transaksi
	    )throws ParseException {
		ExpenseKategori expenseKategori = expenseKategoriService.getKategori(id);
		expenseKategori.setTipePengajuan(tipepengajuanservice.getById(idtipepengajuan));
		expenseKategori.setNamaExpense(nama_expense);
		expenseKategori.setBudgetMaks(budget_maks);
		expenseKategori.setMaksTransaksi(maks_transaksi);
		expenseKategori.setUpdateDate(new Date());
	 	expenseKategoriService.SaveOrUpdate(expenseKategori);
	 	return true;
	 }
	 
	 //Delete ExpenseKategori
	 @RequestMapping(value = "/deleteexpensekategori/",method = RequestMethod.POST,headers="Accept=application/json")
	 public boolean deleteMasuk(@RequestParam(value = "id",required = false)  Long id)throws ParseException {
		 ExpenseKategori expenseKategori = expenseKategoriService.getKategori(id);
		expenseKategoriService.deleteExpenseKategori(expenseKategori);
		return true;
	 }
	 @RequestMapping(value = "/disableexpensekategori/",method = RequestMethod.POST,headers="Accept=application/json")
	 public boolean disableMasuk(@RequestParam(value = "id",required = false)  Long id)throws ParseException {
		 ExpenseKategori expenseKategori = expenseKategoriService.getKategori(id);
		 expenseKategori.setStatus("disable");
		expenseKategoriService.SaveOrUpdate(expenseKategori);
		return true;
	 }	    
	 
//================================================================GET===================================
		@RequestMapping(value = "/expensekategoriall",method = RequestMethod.GET)
		public List<ExpenseKategori> expensekategoriList(){
			return expenseKategoriService.getAllExpenseKategori();
		}
		
	 @RequestMapping(value = "/expensekategoribyid",method = RequestMethod.GET)
	 public ExpenseKategori expensekategoribyid(@RequestParam("id")long id){
	 return expenseKategoriService.getKategori(id);
	 }
	 
	 @RequestMapping(value = "/expensekategoriaktif",method = RequestMethod.GET)
	 public List<ExpenseKategori> getExpenseKategoriActive(){
	 return expenseKategoriService.getexpensekategoriactive();
	 }
}
