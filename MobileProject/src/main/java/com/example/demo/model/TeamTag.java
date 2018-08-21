package com.example.demo.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TeamTag extends Additional{
	
	
	@EmbeddedId
	private TeamTagPK id;
	@ManyToOne(optional = false)
	@JoinColumn(name = "idteam",referencedColumnName = "id",insertable=false,updatable=false)
	private Team team;
	@ManyToOne(optional = false)
	@JoinColumn(name = "idtag",referencedColumnName = "idtag",insertable=false,updatable=false)
	private Tag tag;
	
	public TeamTag() {
		this.setStatus("Active");
	}
	
	public TeamTag(Long idTeam, Long idTag) {
		this.id = new TeamTagPK(idTeam, idTag);
		this.setStatus("Active");
	}
	
	public TeamTagPK getId() {
		return id;
	}

	public void setId(TeamTagPK id) {
		this.id = id;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}
	
}
