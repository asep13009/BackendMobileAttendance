package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class TeamTagPK implements Serializable{
	
	@Basic(optional = false)
    @Column(name = "idteam", insertable = false,updatable = false)
	private Long idTeam;
	@Basic(optional = false)
    @Column(name = "idtag", insertable = false,updatable = false)
	private Long idTag;
	
	public TeamTagPK() {
		
	}
	
	public TeamTagPK(Long idTeam, Long idTag) {
		this.idTeam = idTeam;
		this.idTag = idTag;
	}

	public Long getIdTeam() {
		return idTeam;
	}

	public void setIdTeam(Long idTeam) {
		this.idTeam = idTeam;
	}

	public Long getIdTag() {
		return idTag;
	}

	public void setIdTag(Long idTag) {
		this.idTag = idTag;
	}

	
}
