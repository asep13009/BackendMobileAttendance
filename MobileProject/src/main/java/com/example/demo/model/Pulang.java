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
public class Pulang extends Additional implements Serializable {
    @JsonIgnore
    @OneToMany(mappedBy = "pulang")
    private List<Absen> absen;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Temporal(TemporalType.TIME)
    @Column(name = "jam_pulang")
    private Date jam_pulang;
    @Column(name = "latitude_pulang")
    private Float latitude_pulang;
    @Column(name = "longitude_pulang")
    private Float longitude_pulang;
    @Column(name = "status_fraud")
    private Boolean status_fraud;
    public Pulang(){
        this.setStatus("Active");
        this.setJam_pulang(new Date());
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
        if (!(object instanceof Pulang)) {
            return false;
        }
        Pulang other = (Pulang) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Pulang[ id=" + getId() + " ]";
    }

    /**
     * @return the absen
     */
    public List<Absen> getAbsen() {
        return absen;
    }

    /**
     * @param absen the absen to set
     */
    public void setAbsen(List<Absen> absen) {
        this.absen = absen;
    }

    /**
     * @return the latitude_pulang
     */
    public Float getLatitude_pulang() {
        return latitude_pulang;
    }

    /**
     * @param latitude_pulang the latitude_pulang to set
     */
    public void setLatitude_pulang(Float latitude_pulang) {
        this.latitude_pulang = latitude_pulang;
    }

    /**
     * @return the longitude_pulang
     */
    public Float getLongitude_pulang() {
        return longitude_pulang;
    }

    /**
     * @param longitude_pulang the longitude_pulang to set
     */
    public void setLongitude_pulang(Float longitude_pulang) {
        this.longitude_pulang = longitude_pulang;
    }


    /**
     * @return the jam_pulang
     */
    public Date getJam_pulang() {
        return jam_pulang;
    }

    /**
     * @param jam_pulang the jam_pulang to set
     */
    public void setJam_pulang(Date jam_pulang) {
        this.jam_pulang = jam_pulang;
    }

    public Boolean getStatus_fraud() {
        return status_fraud;
    }

    public void setStatus_fraud(Boolean status_fraud) {
        this.status_fraud = status_fraud;
    }
}
