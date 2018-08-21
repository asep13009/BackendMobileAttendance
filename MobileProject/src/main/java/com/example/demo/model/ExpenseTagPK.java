package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ExpenseTagPK implements Serializable{
	
	@Basic(optional = false)
    @Column(name = "idexpense", insertable = false,updatable = false)
	private Long idExpense;
	@Basic(optional = false)
    @Column(name = "idtag", insertable = false,updatable = false)
	private Long idTag;
	
	public ExpenseTagPK() {
		
	}
	
	public ExpenseTagPK(Long idExpense, Long idTag) {
		this.idExpense = idExpense;
		this.idTag = idTag;
	}
	
	public Long getIdExpense() {
		return idExpense;
	}
	public void setIdExpense(Long idExpense) {
		this.idExpense = idExpense;
	}
	public Long getIdTag() {
		return idTag;
	}
	public void setIdTag(Long idTag) {
		this.idTag = idTag;
	}
	
	

}
