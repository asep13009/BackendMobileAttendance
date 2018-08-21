package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Rule;
import com.example.demo.model.Status;
import com.example.demo.model.TipePengajuan;

@Repository
public interface RuleRepository extends CrudRepository<Rule, Long>{
	
	Rule findNextStatusByTipePengajuanAndStatusNow(TipePengajuan tipePengajuan, Status status);

}
