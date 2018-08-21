package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PengajuanDanaDao;
import com.example.demo.model.PengajuanDana;
import com.example.demo.repository.LogRepository;
import com.example.demo.repository.PengajuanDanaRepository;
import com.example.demo.repository.TipePengajuanRepository;

@Service
public class PengajuanDanaService implements PengajuanDanaDao{

	@Autowired
	PengajuanDanaRepository pdr;
	
	@Autowired
	LogRepository lr;
	
	@Autowired
	TipePengajuanRepository tpr;
	
	@Override
	public PengajuanDana savePengajuan(PengajuanDana pd) {
		return pdr.save(pd);
	}
	
	@Override
	public PengajuanDana getPengajuan(Long id) {
		return pdr.findById(id).get();
	}
	
	@Override
	public List<PengajuanDana> getAll(){
		List<PengajuanDana> lpd = new ArrayList<>();
		pdr.findAll().forEach(lpd::add);
		return lpd;
	}
	
	@Override
	public List<PengajuanDana> getReimbursement(){
		List<PengajuanDana> lpd = new ArrayList<>();
		pdr.findByTipePengajuan(tpr.getById(1L));
		return lpd;
	}
	
	@Override
	public List<PengajuanDana> getCashAdvance(){
		List<PengajuanDana> lpd = new ArrayList<>();
		pdr.findByTipePengajuan(tpr.getById(2L));
		return lpd;
	}
	public List<PengajuanDana>getpengajuandanaactive(){
		return pdr.getpengajuandanaactive();
	}
}
