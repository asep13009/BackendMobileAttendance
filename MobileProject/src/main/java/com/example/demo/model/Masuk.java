/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author lutfi
 */
@Entity
public class Masuk extends Additional implements Serializable {
    @JsonIgnore
    @OneToMany(mappedBy = "masuk")
    private List<Absen> absen;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Temporal(TemporalType.TIME)
    @Column(name = "jam_masuk")
    private Date jam_masuk;
    @Column(name = "lattitude_masuk")
    private Double lattitude_masuk;
    @Column(name = "longitude_masuk")
    private Double longitude_masuk;
    @Column(name = "status_fraud")
    private Boolean status_fraud;

    public Masuk(){
        this.setStatus("Active");
        this.setJam_masuk(new Date());
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Masuk)) {
            return false;
        }
        Masuk other = (Masuk) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Masuk[ id=" + getId() + " ]";
    }

//    /**
//     * @return the absen
//     */
//    public List<Absen> getAbsen() {
//        return absen;
//    }
//
//    /**
//     * @param absen the absen to set
//     */
//    public void setAbsen(List<Absen> absen) {
//        this.absen = absen;
//    }


    /**
     * @return the status
     */

    /**
     * @return the jam_masuk
     */
    public Date getJam_masuk() {
        return jam_masuk;
    }

    /**
     * @param jam_masuk the jam_masuk to set
     */
    public void setJam_masuk(Date jam_masuk) {
        this.jam_masuk = jam_masuk;
    }

    public List<Absen> getAbsen() {
        return absen;
    }

    public void setAbsen(List<Absen> absen) {
        this.absen = absen;
    }

    public Boolean getStatus_fraud() {
        return status_fraud;
    }

    public void setStatus_fraud(Boolean status_fraud) {
        this.status_fraud = status_fraud;
    }

    public Double getLattitude_masuk() {
        return lattitude_masuk;
    }

    public void setLattitude_masuk(Double lattitude_masuk) {
        this.lattitude_masuk = lattitude_masuk;
    }

    public Double getLongitude_masuk() {
        return longitude_masuk;
    }

    public void setLongitude_masuk(Double longitude_masuk) {
        this.longitude_masuk = longitude_masuk;
    }
}
