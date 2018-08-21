package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StatusDao;
import com.example.demo.model.Status;
import com.example.demo.repository.StatusRepository;

@Service
public class StatusService implements StatusDao{

	@Autowired
	StatusRepository sr;
	
	@Override
	public String getNamaStatus(Long id) {
		return sr.getById(id).getNamaStatus();
	}
	
	@Override
	public Status getStatus(Long id) {
		return sr.getById(id);
	}
	
	@Override
	public Status getDraft() {
		return sr.getById(1L);
	}
	
	@Override
	public Status getSent() {
		return sr.getById(2L);
	}

	@Override
	public List<Status> getAllStatus() {
		List<Status> ls=new ArrayList<>();
		sr.findAll().forEach(ls::add);
		return ls;
	}

	@Override
	public Status getById(long id) {
		// TODO Auto-generated method stub
		return sr.getById(id);
	}
	
	public List<Status> getStatusActive(){
        return sr.findStatusActive();
    }

	@Override
	public void SaveOrUpdate(Status a) {
		// TODO Auto-generated method stub
		sr.save(a);
	}

	@Override
	public void deleteStatus(long id) {
		// TODO Auto-generated method stub
		sr.deleteById(id);
	}

	@Override
	public void deleteStatus(Status a) {
		// TODO Auto-generated method stub
		sr.delete(a);
	}

	@Override
	public Status getApproved() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status getRejected() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status getReimbursed() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status getVerified() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status getUnverified() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status getDisbursed() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status getFinished() {
		// TODO Auto-generated method stub
		return null;
	}
}
