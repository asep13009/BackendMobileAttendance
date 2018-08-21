package com.example.demo.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ExpenseTeam extends Additional{
	
	@EmbeddedId
	private ExpenseTeamPK id;
	@ManyToOne
	@JoinColumn(name = "idexpense",referencedColumnName = "idexpense",insertable=false,updatable=false)
	private ExpenseKategori expense;
	@ManyToOne(optional = false)
	@JoinColumn(name = "idteam",referencedColumnName = "id",insertable=false,updatable=false)
	private Team team;
	
	public ExpenseTeam() {
		this.setStatus("Active");
	}
	
	public ExpenseTeam(Long idExpense, Long idTeam) {
		this.id = new ExpenseTeamPK(idExpense, idTeam);
		this.setStatus("Active");
	}

	public ExpenseTeamPK getId() {
		return id;
	}

	public void setId(ExpenseTeamPK id) {
		this.id = id;
	}

	public ExpenseKategori getExpense() {
		return expense;
	}

	public void setExpense(ExpenseKategori expense) {
		this.expense = expense;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

}
