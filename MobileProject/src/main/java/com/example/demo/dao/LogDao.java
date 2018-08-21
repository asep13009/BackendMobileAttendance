package com.example.demo.dao;

import com.example.demo.model.Log;
import com.example.demo.model.PengajuanDana;

public interface LogDao {
	
	public Log saveLog(Log l, PengajuanDana pd);

}
