package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
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
public class TipeKaryawan extends Additional implements Serializable {
    @JsonIgnore
    @OneToMany(mappedBy = "tipeKaryawan")
    private List<Karyawan> karyawans;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nama_typekaryawan;
    public TipeKaryawan(){
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
        if (!(object instanceof TipeKaryawan)) {
            return false;
        }
        TipeKaryawan other = (TipeKaryawan) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TipeKaryawan[ id=" + getId() + " ]";
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

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @return the nama_typekaryawan
     */
    public String getNama_typekaryawan() {
        return nama_typekaryawan;
    }

    /**
     * @param nama_typekaryawan the nama_typekaryawan to set
     */
    public void setNama_typekaryawan(String nama_typekaryawan) {
        this.nama_typekaryawan = nama_typekaryawan;
    }

}
