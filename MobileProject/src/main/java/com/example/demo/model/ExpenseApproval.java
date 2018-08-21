package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class ExpenseApproval extends Additional implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ExpenseApprovalPK id;
	@ManyToOne
	@JoinColumn(name = "idkaryawan", referencedColumnName = "id")
	@JsonIgnore
	private Karyawan idKaryawan;
	@Column(name = "nama_approval", length = 35, insertable = true, updatable = true)
	private String namaApproval;
	@Column(name = "rule", length = 35, insertable = true, updatable = true)
	private String rule;
	
	public ExpenseApproval(){
		this.setStatus("Active");
    	  
    }
	public ExpenseApproval(Long idExpense,Long idApproval){
    	this.id = new ExpenseApprovalPK(idExpense, idApproval); 
    	this.setStatus("Active");
    }
	
	public ExpenseApprovalPK getId() {
		return id;
	}
	public void setId(ExpenseApprovalPK id) {
		this.id = id;
	}
	public Karyawan getIdKaryawan() {
		return idKaryawan;
	}
	public void setIdKaryawan(Karyawan idKaryawan) {
		this.idKaryawan = idKaryawan;
	}
	public String getNamaApproval() {
		return namaApproval;
	}
	public void setNamaApproval(String namaApproval) {
		this.namaApproval = namaApproval;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}