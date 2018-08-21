package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author rasyid
 */
@Entity
public class Venue extends Additional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nama_venue;
    private String deskripsi_venue;
    private String alamat_venue;
    private Double latitude_venue;
    private Double longitude_venue;
    private Double radius_venue;
    @JsonIgnore
    @OneToMany(mappedBy = "venue")
    private List<Karyawan> karyawans;


    public Venue(Long id, String nama_venue, String deskripsi_venue, String alamat_venue,DecimalFormat latitude_venue) {
        this.setId(id);
        this.setNama_venue(nama_venue);
        this.setDeskripsi_venue(deskripsi_venue);
        this.setAlamat_venue(alamat_venue);
        this.setStatus("Active");
    }

    public Venue(Long id, String nama_venue, String deskripsi_venue, String alamat_venue) {
        this.setId(id);
        this.setNama_venue(nama_venue);
        this.setDeskripsi_venue(deskripsi_venue);
        this.setAlamat_venue(alamat_venue);
    }

    public Venue() {
    	this.setStatus("Active");
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
        if (!(object instanceof Venue)) {
            return false;
        }
        Venue other = (Venue) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Venue[ id=" + getId() + " ]";
    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @return the nama_venue
     */
    public String getNama_venue() {
        return nama_venue;
    }

    /**
     * @param nama_venue the nama_venue to set
     */
    public void setNama_venue(String nama_venue) {
        this.nama_venue = nama_venue;
    }

    /**
     * @return the deskripsi_venue
     */
    public String getDeskripsi_venue() {
        return deskripsi_venue;
    }

    /**
     * @param deskripsi_venue the deskripsi_venue to set
     */
    public void setDeskripsi_venue(String deskripsi_venue) {
        this.deskripsi_venue = deskripsi_venue;
    }

    /**
     * @return the alamat_venue
     */
    public String getAlamat_venue() {
        return alamat_venue;
    }

    /**
     * @param alamat_venue the alamat_venue to set
     */
    public void setAlamat_venue(String alamat_venue) {
        this.alamat_venue = alamat_venue;
    }


    /**
     * @return the karyawans
     */
    public List<Karyawan> getKaryawans() {
        return karyawans;
    }

    /**
     * @param karyawans the karyawans to set
     */
    public void setKaryawans(List<Karyawan> karyawans) {
        this.karyawans = karyawans;
    }


    public Double getLatitude_venue() {
        return latitude_venue;
    }

    public void setLatitude_venue(Double latitude_venue) {
        this.latitude_venue = latitude_venue;
    }

    public Double getLongitude_venue() {
        return longitude_venue;
    }

    public void setLongitude_venue(Double longitude_venue) {
        this.longitude_venue = longitude_venue;
    }

    public Double getRadius_venue() {
        return radius_venue;
    }

    public void setRadius_venue(Double radius_venue) {
        this.radius_venue = radius_venue;
    }
}
