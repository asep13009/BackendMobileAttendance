package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TimeGroup extends Additional implements Serializable {

	@JsonIgnore
    @OneToMany(mappedBy = "timeGroup")
    private List<Karyawan> karyawans;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    String nama;
    @Temporal (TemporalType.TIME)
    Date jam_masuk;
    @Temporal (TemporalType.TIME)
    Date jam_keluar;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public Date getJam_masuk() {
		return jam_masuk;
	}
	public void setJam_masuk(Date jam_masuk) {
		this.jam_masuk = jam_masuk;
	}
	public Date getJam_keluar() {
		return jam_keluar;
	}
	public void setJam_keluar(Date jam_keluar) {
		this.jam_keluar = jam_keluar;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public TimeGroup() {
		this.setStatus("Active");
	}
}