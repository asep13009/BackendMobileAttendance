package com.example.demo.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Status;
import com.example.demo.service.StatusService;

@RestController
public class StatusCrudController {
    @Autowired
    StatusService statusService;
    @RequestMapping(value = "/insertstatus",method = RequestMethod.POST,headers="Accept=application/json")
    public boolean insertStatus(@RequestParam("nama_status") String nama_status){
        Status status= new Status();
        status.setCreateDate(new Date());
        status.setNamaStatus(nama_status);
        statusService.SaveOrUpdate(status);
        return true;
    }
    @RequestMapping(value = "/updatestatus",method = RequestMethod.POST,headers="Accept=application/json")
    public boolean updateStatus(@RequestParam("id")long id,@RequestParam("nama_status") String nama_status){
        Status status= statusService.getById(id);
        status.setId(id);
        status.setUpdateDate(new Date());
        status.setNamaStatus(nama_status);
        statusService.SaveOrUpdate(status);
        return true;
    }
    @RequestMapping(value = "/deletestatus",method = RequestMethod.POST,headers="Accept=application/json")
    public boolean updateStatus(@RequestParam("id")long id){
        Status status= statusService.getById(id);
        statusService.deleteStatus(status);
        return true;
    }
    @RequestMapping(value = "/disablestatus",method = RequestMethod.POST,headers="Accept=application/json")
    public boolean disableStatus(@RequestParam("id")long id){
        Status status= statusService.getById(id);
        status.setStatus("disable");
        statusService.SaveOrUpdate(status);
        return true;
    }
    
//====================================GET================================================================
    @RequestMapping(value = "/statusall",method = RequestMethod.GET)
	 public List<Status> statusList(){
	     return statusService.getAllStatus();
	 }
   
   @RequestMapping(value = "/statusbyid",method = RequestMethod.GET)
   public Status statusbyid(@RequestParam("id")long id){
       return statusService.getById(id);
   }
   
   @RequestMapping(value = "/statusaktif",method = RequestMethod.GET)
   public List<Status> statusbystatus(){
       return statusService.getStatusActive();
   }
}
