package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ApprovalDao;
import com.example.demo.model.Approval;
import com.example.demo.repository.ApprovalRepository;

@Service
public class ApprovalService implements ApprovalDao{
	@Autowired
	ApprovalRepository approvalRepository;
	@Override
	public List<Approval> getAllApproval() {
		  List<Approval> al = new ArrayList<>();
		  approvalRepository.findAll().forEach(al::add);
	      return al;
	}

	@Override
	public Approval getById(long id) {
		Approval ak = approvalRepository.findById(id).get();
	     return ak;
	}

	@Override
	public void SaveOrUpdate(Approval a) {
		approvalRepository.save(a);

	}

	@Override
	public void deleteApproval(long id) {
		approvalRepository.deleteById(id);

	}

	@Override
	public void deleteApproval(Approval a) {
		approvalRepository.delete(a);

	}
	public List<Approval>getapprovalactive(){
		return approvalRepository.getapprovalactive();
	}

}
