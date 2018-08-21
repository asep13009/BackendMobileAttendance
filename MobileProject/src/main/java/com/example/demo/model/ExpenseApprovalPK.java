package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ExpenseApprovalPK implements Serializable{
	
	@Basic(optional = false)
    @Column(insertable = false,updatable = false)
	Long idExpense;
	@Basic(optional = false)
    @Column(insertable = false,updatable = false)
	Long idApproval;
	
	public ExpenseApprovalPK () {
		
	}
	
	public ExpenseApprovalPK(Long idExpense, Long idApproval) {
		this.idExpense = idExpense;
		this.idApproval = idApproval;
	}
	public Long getIdExpense() {
		return idExpense;
	}

	public void setIdExpense(Long idExpense) {
		this.idExpense = idExpense;
	}

	public Long getIdApproval() {
		return idApproval;
	}

	public void setIdApproval(Long idApproval) {
		this.idApproval = idApproval;
	}

}
