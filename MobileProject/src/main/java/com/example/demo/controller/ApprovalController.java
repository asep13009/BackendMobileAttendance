package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Approval;
import com.example.demo.service.ApprovalService;

import de.odysseus.el.tree.impl.Parser.ParseException;

@RestController
public class ApprovalController {
	 @Autowired
	 ApprovalService approvalService;
	 
	 //Select All Approval

	 
	 //Insert Approval
	 @RequestMapping(value = "/insertapproval/",method = RequestMethod.POST,headers="Accept=application/json")
	    public boolean insertApproval(   @RequestParam (value = "tipe_approval", required = false) String tipe_approval                          
	    ){
		 	Approval approval = new Approval();
		 	approval.setCreateDate(new Date());
		 	approval.setTipe_approval(tipe_approval);
		 	approvalService.SaveOrUpdate(approval);
	        return true;
	    }
	 //Update Approval
	 @RequestMapping(value = "/updateapproval/",method = RequestMethod.POST,headers="Accept=application/json")
	    public boolean updateApproval(@RequestParam(value = "id",required = false)  Long id,
	    		 	@RequestParam (value = "tipe_approval", required = false) String tipe_approval
	    )throws ParseException {
		 	Approval approval = approvalService.getById(id);
		 	approval.setUpdateDate(new Date());
		 	approval.setTipe_approval(tipe_approval);
		 	approvalService.SaveOrUpdate(approval);
		 	return true;
	    }
	 
	 //Delete Approval
	 @RequestMapping(value = "/deleteapproval/",method = RequestMethod.POST,headers="Accept=application/json")
	    public boolean deleteApproval(@RequestParam(value = "id",required = false)  Long id)throws ParseException {
		 Approval approval = approvalService.getById(id);

		 approvalService.deleteApproval(approval);
		 return true;
	    }
	 
	 @RequestMapping(value = "/disableapproval/",method = RequestMethod.POST,headers = "Accept=application/json")
	    public boolean disableApproval(@RequestParam("id")long id){
		 	Approval approval = approvalService.getById(id);
		 	approval.setStatus("disable");
		 	approvalService.SaveOrUpdate(approval);
	        return true;
	    }
	 
	 //=============================Read=============================================
	@RequestMapping(value = "/approvalall",method = RequestMethod.GET)
	public List<Approval> approvalList(){
	return approvalService.getAllApproval();
	}
	@RequestMapping(value = "/approvalbyid",method = RequestMethod.GET)
	public Approval approvalbyid(@RequestParam("id")long id){
		return approvalService.getById(id);
	}
	@RequestMapping(value = "/approvalactive",method = RequestMethod.GET)
	public List<Approval> approvalactive(){
		return approvalService.getapprovalactive();
	}
}
