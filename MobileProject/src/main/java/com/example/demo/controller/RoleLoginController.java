package com.example.demo.controller;

import com.example.demo.model.RoleLogin;
import com.example.demo.service.RoleLoginService;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleLoginController {
    @Autowired
    RoleLoginService roleLoginService;
    
    @RequestMapping(value = "/insertrolelogin",method = RequestMethod.POST,headers = "Accept=application/json")
    public boolean insertRoleLogin( @RequestParam("nama_role")String nama_role){
        RoleLogin roleLogin =new RoleLogin();
        roleLogin.setNama_role(nama_role);
        roleLogin.setCreateDate(new Date());
        roleLoginService.SaveOrUpdate(roleLogin);
        return true;
    }
    @RequestMapping(value = "/updatetrolelogin",method = RequestMethod.POST,headers = "Accept=application/json")
    public boolean updateRoleLogin(@RequestParam("id")long id,@RequestParam("nama_role")String nama_role){
        RoleLogin roleLogin =roleLoginService.getById(id);
        roleLogin.setId(id);
        roleLogin.setUpdateDate(new Date());
        roleLogin.setNama_role(nama_role);
        roleLoginService.SaveOrUpdate(roleLogin);
        return true;
    }
    @RequestMapping(value = "/deleterolelogin",method = RequestMethod.POST,headers = "Accept=application/json")
    public boolean deleteRoleLogin(@RequestParam("id")long id){
        RoleLogin roleLogin =roleLoginService.getById(id);
        roleLoginService.deleteRoleLogin(roleLogin);
        return true;
    }
    @RequestMapping(value = "/disablerolelogin",method = RequestMethod.POST,headers = "Accept=application/json")
    public boolean disableRoleLogin(@RequestParam("id")long id){
        RoleLogin roleLogin =roleLoginService.getById(id);
        roleLogin.setStatus("Disable");
        roleLoginService.SaveOrUpdate(roleLogin);
        return true;
    }
    
//===========================================GET======================================================
    @RequestMapping(value = "/roleloginall",method = RequestMethod.GET,headers="Accept=application/json")
	 public List<RoleLogin> roleloginList(){
	     return roleLoginService.getAllAdmin();
	 }
   
   @RequestMapping(value = "/roleloginbyid",method = RequestMethod.GET)
   public RoleLogin roleLoginbyid(@RequestParam("id")long id){
       return roleLoginService.getById(id);
   }
   
   @RequestMapping(value = "/roleloginaktif",method = RequestMethod.GET)
   public List<RoleLogin> roleLoginbystatus(){
       return roleLoginService.getRoleLoginActive();
   }
}
