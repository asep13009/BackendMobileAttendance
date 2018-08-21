package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ExpenseKategori extends Additional implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idexpense")
	private
	Long id;
	@ManyToOne
	private TipePengajuan tipePengajuan;
	@Column(name = "nama_expense", length = 35, insertable = true, updatable = true)
	private
	String namaExpense;
	@Column(name = "budget_maks", insertable = true, updatable = true)
	private
	Integer budgetMaks;
	@Column(name = "maks_transaksi", insertable = true, updatable = true)
	private
	Integer maksTransaksi;
	public ExpenseKategori(){
		this.setStatus("Active");
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public TipePengajuan getIdTipePengajuan() {
		return tipePengajuan;
	}
	public void setTipePengajuan(TipePengajuan tipePengajuan) {
		this.tipePengajuan = tipePengajuan;
	}
	public String getNamaExpense() {
		return namaExpense;
	}
	public void setNamaExpense(String namaExpense) {
		this.namaExpense = namaExpense;
	}
	public Integer getBudgetMaks() {
		return budgetMaks;
	}
	public void setBudgetMaks(Integer budgetMaks) {
		this.budgetMaks = budgetMaks;
	}
	public Integer getMaksTransaksi() {
		return maksTransaksi;
	}
	public void setMaksTransaksi(Integer maksTransaksi) {
		this.maksTransaksi = maksTransaksi;
	}
	public static long getSerialversionuid() {
		return getSerialVersionUID();
	}
}
