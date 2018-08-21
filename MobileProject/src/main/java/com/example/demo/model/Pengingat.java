/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author lutfi
 */
@Entity
public class Pengingat extends Additional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nama_pengingat")
    private String nama_pengingat;
    @Temporal(TemporalType.TIME)
    @Column(name = "waktu_pengingat")
    private Date waktu_pengingat;
    @Column(name = "deskripsi_pengingat")
    private String deskripsi_pengingat;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Pengingat(){
        this.setStatus("Active");
        this.setWaktu_pengingat(new Date());
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pengingat)) {
            return false;
        }
        Pengingat other = (Pengingat) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Pengingat[ id=" + getId() + " ]";
    }

    /**
     * @return the nama_pengingat
     */
    public String getNama_pengingat() {
        return nama_pengingat;
    }

    /**
     * @param nama_pengingat the nama_pengingat to set
     */
    public void setNama_pengingat(String nama_pengingat) {
        this.nama_pengingat = nama_pengingat;
    }

    /**
     * @return the waktu_pengingat
     */
    public Date getWaktu_pengingat() {
        return waktu_pengingat;
    }

    /**
     * @param waktu_pengingat the waktu_pengingat to set
     */
    public void setWaktu_pengingat(Date waktu_pengingat) {
        this.waktu_pengingat = waktu_pengingat;
    }

    /**
     * @return the deskripsi_pengingat
     */
    public String getDeskripsi_pengingat() {
        return deskripsi_pengingat;
    }

    /**
     * @param deskripsi_pengingat the deskripsi_pengingat to set
     */
    public void setDeskripsi_pengingat(String deskripsi_pengingat) {
        this.deskripsi_pengingat = deskripsi_pengingat;
    }
    
}
