package com.example.demo.controller;

import com.example.demo.model.Team;
import com.example.demo.service.TeamServices;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {
    @Autowired
    TeamServices teamServices;
    
    @RequestMapping(value = "/insertteam",method = RequestMethod.POST,headers = "Accept=application/json")
    public boolean insertteam(@RequestParam("nama_team") String nama_team){
        Team team = new Team();
        team.setCreateDate(new Date());
        team.setNama_team(nama_team);
        teamServices.SaveOrUpdate(team);
        return true;
    }
    @RequestMapping(value = "/updateteam",method = RequestMethod.POST,headers = "Accept=application/json")
    public boolean updateteam(@RequestParam("id")long id,@RequestParam("nama_team") String nama_team){
        Team team = teamServices.getById(id);
        team.setId(id);
        team.setUpdateDate(new Date());
        team.setNama_team(nama_team);
        teamServices.SaveOrUpdate(team);
        return true;
    }
    @RequestMapping(value = "/deleteteam",method = RequestMethod.POST,headers = "Accept=application/json")
    public boolean deleteteam(@RequestParam("id")long id){
        Team team = teamServices.getById(id);
        teamServices.deleteTeam(team);
        return true;
    }
    @RequestMapping(value = "/disableteam",method = RequestMethod.POST,headers = "Accept=application/json")
    public boolean disableteam(@RequestParam("id")long id){
        Team team = teamServices.getById(id);
        team.setStatus("disable");
        teamServices.SaveOrUpdate(team);
        return true;
    }
    
    //==============================================GET========================================
    
    @RequestMapping(value = "/teamall",method = RequestMethod.GET)
	 public List<Team> teamList(){
	     return teamServices.getAllTeam();
	 }
   
   @RequestMapping(value = "/teambyid",method = RequestMethod.GET)
   public Team teambyid(@RequestParam("id")long id){
       return teamServices.getById(id);
   }
   
   @RequestMapping(value = "/teamaktif",method = RequestMethod.GET)
   public List<Team> teambystatus(){
       return teamServices.getTeamActive();
   }
}
