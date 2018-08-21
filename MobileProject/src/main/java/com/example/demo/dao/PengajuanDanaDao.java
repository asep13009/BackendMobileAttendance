package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.PengajuanDana;

public interface PengajuanDanaDao {

	public PengajuanDana savePengajuan(PengajuanDana pd);
	public PengajuanDana getPengajuan(Long id);
	public List<PengajuanDana> getAll();
	public List<PengajuanDana> getReimbursement();
	public List<PengajuanDana> getCashAdvance();
}
