package com.example.demo.dao;

import com.example.demo.model.AkunBank;

import java.util.List;

public interface AkunBankDao {
    public List<AkunBank> getAllAkunBank();
    public AkunBank getById(long id);
    public void SaveOrUpdate(AkunBank a);
    public void deleteAkunBank(long id);
    public void deleteAkunBank(AkunBank a);
}
