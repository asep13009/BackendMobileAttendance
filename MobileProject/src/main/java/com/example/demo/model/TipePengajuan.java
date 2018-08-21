package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipePengajuan extends Additional implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtipepengajuan")
	private
	Long id;
	@Column(name = "jenis_pengajuan", length = 25, insertable = true, updatable = true)
	private
	String jenisPengajuan;
	public TipePengajuan(){
		this.setStatus("Active");
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getJenisPengajuan() {
		return jenisPengajuan;
	}
	public void setJenisPengajuan(String jenisPengajuan) {
		this.jenisPengajuan = jenisPengajuan;
	}
	public static long getSerialversionuid() {
		return getSerialVersionUID();
	}
}
