package com.example.demo.dao;

import com.example.demo.model.Jabatan;

import java.util.List;

public interface JabatanDao {
    public List<Jabatan> getAllJabatan();
    public Jabatan getById(long id);
    public void SaveOrUpdate(Jabatan a);
    public void deleteJabatan(long id);
    public void deleteJabatan(Jabatan a);
}
