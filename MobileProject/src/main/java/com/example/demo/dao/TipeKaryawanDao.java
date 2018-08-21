package com.example.demo.dao;

import com.example.demo.model.TipeKaryawan;

import java.util.List;

public interface TipeKaryawanDao {
    public List<TipeKaryawan> getAllTipeKaryawan();
    public TipeKaryawan getById(long id);
    public void SaveOrUpdate(TipeKaryawan a);
    public void deleteTipeKaryawan(long id);
    public void deleteTipeKaryawan(TipeKaryawan a);
}
