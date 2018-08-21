package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import javax.persistence.*;

/**
 *
 * @author rasyid
 */
@Entity
public class DataLogin extends Additional implements Serializable {
    @JsonIgnore
    @OneToMany(mappedBy = "dataLogin")
    private List<Absen> absens;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private Date lastLogin;
    @OneToOne
    private Karyawan karyawan;
    @ManyToOne
    private RoleLogin roleLogin;


    public DataLogin() {
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
        if (!(object instanceof DataLogin)) {
            return false;
        }
        DataLogin other = (DataLogin) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.DataLogin[ id=" + getId() + " ]";
    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the karyawan
     */
    public Karyawan getKaryawan() {
        return karyawan;
    }

    /**
     * @param karyawan the karyawan to set
     */
    public void setKaryawan(Karyawan karyawan) {
        this.karyawan = karyawan;
    }

    /**
     * @return the roleLogin
     */
    public RoleLogin getRoleLogin() {
        return roleLogin;
    }

    /**
     * @param roleLogin the roleLogin to set
     */
    public void setRoleLogin(RoleLogin roleLogin) {
        this.roleLogin = roleLogin;
    }


    public List<Absen> getAbsens() {
        return absens;
    }

    public void setAbsens(List<Absen> absens) {
        this.absens = absens;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
}
