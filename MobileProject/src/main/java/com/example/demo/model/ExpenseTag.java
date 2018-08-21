package com.example.demo.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ExpenseTag extends Additional{
	
	@EmbeddedId
	ExpenseTagPK id;
	@ManyToOne
	@JoinColumn(name = "idexpense",referencedColumnName = "idexpense",insertable=false,updatable=false)
	private ExpenseKategori expense;
	@ManyToOne
	@JoinColumn(name = "idtag",referencedColumnName = "idtag",insertable=false,updatable=false)
	private Tag tag;
	
	public ExpenseTag() {
		this.setStatus("Active");
	}
	
	public ExpenseTag(Long idExpense, Long idTag) {
		this.id = new ExpenseTagPK(idExpense, idTag);
		this.setStatus("Active");
	}
	
	public ExpenseTagPK getId() {
		return id;
	}
	public void setId(ExpenseTagPK id) {
		this.id = id;
	}
	public ExpenseKategori getExpense() {
		return expense;
	}
	public void setExpense(ExpenseKategori expense) {
		this.expense = expense;
	}
	public Tag getTag() {
		return tag;
	}
	public void setTag(Tag tag) {
		this.tag = tag;
	}

}
