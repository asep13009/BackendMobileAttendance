package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author rasyid
 */
@Entity
public class AkunBank extends Additional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nama_bank;
    @JsonIgnore
    @OneToMany(mappedBy = "akunBank")
    private List<Karyawan> karyawans;

    public AkunBank(){
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
        if (!(object instanceof AkunBank)) {
            return false;
        }
        AkunBank other = (AkunBank) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.AkunBank[ id=" + getId() + " ]";
    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @return the nama_bank
     */
    public String getNama_bank() {
        return nama_bank;
    }

    /**
     * @param nama_bank the nama_bank to set
     */
    public void setNama_bank(String nama_bank) {
        this.nama_bank = nama_bank;
    }

    public List<Karyawan> getKaryawans() {
        return karyawans;
    }

    public void setKaryawans(List<Karyawan> karyawans) {
        this.karyawans = karyawans;
    }

    /**
     * @return the karyawan
     */


}
