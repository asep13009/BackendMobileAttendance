package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.TipePengajuan;

public interface TipePengajuanDao {
	
	public TipePengajuan getTipe(Long id);
	public List<TipePengajuan> getAllTipePengajuan();
    public TipePengajuan getById(long id);
    public void SaveOrUpdate(TipePengajuan a);
    public void deleteTipePengajuan(long id);
    public void deleteTipePengajuan(TipePengajuan a);

}
