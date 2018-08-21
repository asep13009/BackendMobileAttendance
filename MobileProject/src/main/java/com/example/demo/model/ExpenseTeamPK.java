package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ExpenseTeamPK implements Serializable{
	
	@Basic(optional = false)
    @Column(name = "idexpense", insertable = false,updatable = false)
	private Long idExpense;
	@Basic(optional = false)
    @Column(name = "idteam", insertable = false,updatable = false)
	private Long idTeam;
	
	public ExpenseTeamPK() {
		
	}
	
	public ExpenseTeamPK(Long idExpense, Long idTeam) {
		this.idExpense = idExpense;
		this.idTeam = idTeam;
	}

	public Long getIdExpense() {
		return idExpense;
	}

	public void setIdExpense(Long idExpense) {
		this.idExpense = idExpense;
	}

	public Long getIdTeam() {
		return idTeam;
	}

	public void setIdTeam(Long idTeam) {
		this.idTeam = idTeam;
	}

}
