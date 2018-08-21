package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Status;
import com.example.demo.model.TipePengajuan;
import com.example.demo.service.RuleService;
import com.example.demo.service.StatusService;
import com.example.demo.service.TipePengajuanService;

@RestController
public class RuleController {

	@Autowired
	RuleService rs;
	
	@Autowired
	StatusService ss;
	
	@Autowired
	TipePengajuanService tps;
	
	@RequestMapping(value="/nextstatus")
	public String nextStep(@RequestParam("tipepengajuan") Long tp, @RequestParam("status") Long s) {
		TipePengajuan tipe  = tps.getTipe(tp);
		Status status = ss.getStatus(s);
		String next = rs.findNextStatus(tipe, status).getNextStatus().getNamaStatus();
		String now = ss.getNamaStatus(s);
		return "setelah " + now + ", selanjutnya adalah " + next;
	}
}
