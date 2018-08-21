package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Status;

public interface StatusDao {

	public String getNamaStatus(Long id);
	public Status getStatus(Long id);
	public Status getDraft();
	public Status getSent();
	public Status getApproved();
	public Status getRejected();
	public Status getReimbursed();
	public Status getVerified();
	public Status getUnverified();
	public Status getDisbursed();
	public Status getFinished();
	public List<Status> getAllStatus();
    public Status getById(long id);
    public void SaveOrUpdate(Status a);
    public void deleteStatus(long id);
    public void deleteStatus(Status a);
}
