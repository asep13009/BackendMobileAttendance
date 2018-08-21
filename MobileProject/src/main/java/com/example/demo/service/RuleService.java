package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RuleDao;
import com.example.demo.model.Rule;
import com.example.demo.model.Status;
import com.example.demo.model.TipePengajuan;
import com.example.demo.repository.RuleRepository;

@Service
public class RuleService implements RuleDao{
	
	@Autowired
	RuleRepository rr;
	
	@Override
	public Rule findNextStatus(TipePengajuan tipe, Status status) {
		return rr.findNextStatusByTipePengajuanAndStatusNow(tipe, status);
	}

}
