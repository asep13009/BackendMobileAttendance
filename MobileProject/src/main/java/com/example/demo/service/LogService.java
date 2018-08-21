package com.example.demo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LogDao;
import com.example.demo.model.Log;
import com.example.demo.model.PengajuanDana;
import com.example.demo.repository.LogRepository;
import com.example.demo.repository.RuleRepository;

@Service
public class LogService implements LogDao{
	
	@Autowired
	LogRepository lr;
	
	@Autowired
	RuleRepository rr;
	
	@Override
	public Log saveLog(Log l, PengajuanDana pd) {
		l.setPengajuanDana(pd);
		l.setTimestamp(new Date());
		l.setNextStatus(rr.findNextStatusByTipePengajuanAndStatusNow(pd.getTipePengajuan(), pd.getStatus_pengajuan()).getNextStatus());
		l.setNextBy(rr.findNextStatusByTipePengajuanAndStatusNow(pd.getTipePengajuan(), pd.getStatus_pengajuan()).getNextBy().getFullName());
		l.setUpdateByHistori(pd.getUpdateBy());
		return lr.save(l);
	}

}
