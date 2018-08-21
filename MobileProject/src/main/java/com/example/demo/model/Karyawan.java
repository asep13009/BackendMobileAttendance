package com.example.demo.model;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author rasyid
 */
@Entity
public class Karyawan extends Additional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String last_name;
    private String first_name;
    private String kode_karyawan;
    private String no_rekening;
    private String nama_rekening;
    private Date join_date;
    @ManyToOne
    private Venue venue;
    @OneToOne(mappedBy = "karyawan")
    private DataLogin dataLogin;
    @ManyToOne
    private AkunBank akunBank;
    @ManyToOne
    private Jabatan jabatan;
    @ManyToOne
    private Team team;
    @ManyToOne
    private TipeKaryawan tipeKaryawan;
    @ManyToOne
    private TimeGroup timeGroup;

    public TimeGroup getTimeGroup() {
		return timeGroup;
	}

	public void setTimeGroup(TimeGroup timeGroup) {
		this.timeGroup = timeGroup;
	}

	public Karyawan(Long id, String last_name, String first_name, String kode_karyawan, String no_rekening, String nama_rekening) {
        this.setId(id);
        this.setLast_name(last_name);
        this.setFirst_name(first_name);
        this.setKode_karyawan(kode_karyawan);
        this.setNo_rekening(no_rekening);
        this.setNama_rekening(nama_rekening);
        this.setStatus("Active");
    }

    public Karyawan(Long id, String last_name, String first_name, String kode_karyawan) {
        this.setId(id);
        this.setLast_name(last_name);
        this.setFirst_name(first_name);
        this.setKode_karyawan(kode_karyawan);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    public Karyawan(Long id, String last_name) {
        this.setId(id);
        this.setLast_name(last_name);
    }

    public Karyawan() {
    }
    
    public String getFullName() {
		return this.getFirst_name()+" "+this.getLast_name();
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
        if (!(object instanceof Karyawan)) {
            return false;
        }
        Karyawan other = (Karyawan) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Karyawan[ id=" + getId() + " ]";
    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @return the last_name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * @param last_name the last_name to set
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * @return the first_name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * @param first_name the first_name to set
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * @return the kode_karyawan
     */
    public String getKode_karyawan() {
        return kode_karyawan;
    }

    /**
     * @param kode_karyawan the kode_karyawan to set
     */
    public void setKode_karyawan(String kode_karyawan) {
        this.kode_karyawan = kode_karyawan;
    }

    /**
     * @return the no_rekening
     */
    public String getNo_rekening() {
        return no_rekening;
    }

    /**
     * @param no_rekening the no_rekening to set
     */
    public void setNo_rekening(String no_rekening) {
        this.no_rekening = no_rekening;
    }

    /**
     * @return the nama_rekening
     */
    public String getNama_rekening() {
        return nama_rekening;
    }

    /**
     * @param nama_rekening the nama_rekening to set
     */
    public void setNama_rekening(String nama_rekening) {
        this.nama_rekening = nama_rekening;
    }

    /**
     * @return the venue
     */
    public Venue getVenue() {
        return venue;
    }

    /**
     * @param venue the venue to set
     */
    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    /**
     * @return the dataLogin
     */
    public DataLogin getDataLogin() {
        return dataLogin;
    }

    /**
     * @param dataLogin the dataLogin to set
     */
    public void setDataLogin(DataLogin dataLogin) {
        this.dataLogin = dataLogin;
    }

    /**
     * @return the akunBank
     */
    public AkunBank getAkunBank() {
        return akunBank;
    }

    /**
     * @param akunBank the akunBank to set
     */
    public void setAkunBank(AkunBank akunBank) {
        this.akunBank = akunBank;
    }

    /**
     * @return the jabatan
     */
    public Jabatan getJabatan() {
        return jabatan;
    }

    /**
     * @param jabatan the jabatan to set
     */
    public void setJabatan(Jabatan jabatan) {
        this.jabatan = jabatan;
    }

    /**
     * @return the team
     */
    public Team getTeam() {
        return team;
    }

    /**
     * @param team the team to set
     */
    public void setTeam(Team team) {
        this.team = team;
    }

    /**
     * @return the tipeKaryawan
     */
    public TipeKaryawan getTipeKaryawan() {
        return tipeKaryawan;
    }

    /**
     * @param tipeKaryawan the tipeKaryawan to set
     */
    public void setTipeKaryawan(TipeKaryawan tipeKaryawan) {
        this.tipeKaryawan = tipeKaryawan;
    }

    public Date getJoin_date() {
        return join_date;
    }

    public void setJoin_date(Date join_date) {
        this.join_date = join_date;
    }
}
