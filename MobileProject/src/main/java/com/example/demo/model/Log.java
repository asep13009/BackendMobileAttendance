package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Log extends Additional {

	
	@Id
	@Column(name = "timestamp")
	private
	Date timestamp;
	@Column(name = "update_by_histori", length = 35, insertable = true, updatable = false)
	private
	String updateByHistori;
	@Column(name = "next_by", length = 35, insertable = true, updatable = false)
	private
	String nextBy;
	@ManyToOne
	@JoinColumn(name = "next_status", referencedColumnName = "idstatus")
	private
	Status nextStatus;
	@ManyToOne
	@JoinColumn(name = "idpengajuan", referencedColumnName = "idpengajuan")
	private
	PengajuanDana pengajuanDana;
	public Log(){
		this.setStatus("Active");
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getUpdateByHistori() {
		return updateByHistori;
	}
	public void setUpdateByHistori(String updateByHistori) {
		this.updateByHistori = updateByHistori;
	}
	public String getNextBy() {
		return nextBy;
	}
	public void setNextBy(String nextBy) {
		this.nextBy = nextBy;
	}
	public Status getNextStatus() {
		return nextStatus;
	}
	public void setNextStatus(Status nextStatus) {
		this.nextStatus = nextStatus;
	}
	public PengajuanDana getPengajuanDana() {
		return pengajuanDana;
	}
	public void setPengajuanDana(PengajuanDana pengajuanDana) {
		this.pengajuanDana = pengajuanDana;
	}
	
}
