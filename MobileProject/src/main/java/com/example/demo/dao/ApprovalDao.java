package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Approval;

public interface ApprovalDao {
	 public List<Approval> getAllApproval();
	    public Approval getById(long id);
	    public void SaveOrUpdate(Approval a);
	    public void deleteApproval(long id);
	    public void deleteApproval(Approval a);
}
