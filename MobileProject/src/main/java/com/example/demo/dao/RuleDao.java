package com.example.demo.dao;

import com.example.demo.model.Rule;
import com.example.demo.model.Status;
import com.example.demo.model.TipePengajuan;

public interface RuleDao {
	
	public Rule findNextStatus(TipePengajuan tipe, Status status);

}
