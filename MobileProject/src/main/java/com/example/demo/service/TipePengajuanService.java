package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TipePengajuanDao;
import com.example.demo.model.TipePengajuan;
import com.example.demo.repository.TipePengajuanRepository;

@Service
public class TipePengajuanService implements TipePengajuanDao{
	
	@Autowired
	TipePengajuanRepository tpr;
	
	@Override
	public TipePengajuan getTipe(Long id) {
		return tpr.getById(id);
	}

	@Override
	public List<TipePengajuan> getAllTipePengajuan() {
		// TODO Auto-generated method stub
		List<TipePengajuan> lt=new ArrayList<>();
		tpr.findAll().forEach(lt::add);
		return lt;
	}

	@Override
	public TipePengajuan getById(long id) {
		// TODO Auto-generated method stub
		return tpr.getById(id);
	}

	@Override
	public void SaveOrUpdate(TipePengajuan a) {
		// TODO Auto-generated method stub
		tpr.save(a);
	}

	@Override
	public void deleteTipePengajuan(long id) {
		// TODO Auto-generated method stub
		tpr.deleteById(id);
	}

	@Override
	public void deleteTipePengajuan(TipePengajuan a) {
		// TODO Auto-generated method stub
		tpr.delete(a);
	}

	public List<TipePengajuan>gettipePengajuanactive(){
		return tpr.gettipePengajuanactive();
	}

}
