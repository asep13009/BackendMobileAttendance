package com.example.demo.dao;

import com.example.demo.model.Karyawan;


import java.util.List;

public interface KaryawanDao  {
    public List<Karyawan> getAllKaryawan();
    public Karyawan getById(long id);
    public Karyawan SaveOrUpdate(Karyawan a);
    public void deleteKaryawan(long id);
    public void deleteKaryawan(Karyawan a);
}