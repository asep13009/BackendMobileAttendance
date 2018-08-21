package com.example.demo.dao;

import com.example.demo.model.DataLogin;

import java.util.List;

public interface DataLoginDao {
    public List<DataLogin> getAllDataLogin();
    public DataLogin getById(long id);
    public void SaveOrUpdate(DataLogin a);
    public void deleteDataLogin(long id);
    public void deleteDataLogin(DataLogin a);
}
