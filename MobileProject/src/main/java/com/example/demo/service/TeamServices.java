package com.example.demo.service;


import com.example.demo.dao.TeamDao;
import com.example.demo.model.Team;

import com.example.demo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TeamServices implements TeamDao {
    @Autowired
    TeamRepository teamRepository;
    @Override
    public List<Team> getAllTeam() {
        List<Team> al = new ArrayList<>();
        teamRepository.findAll().forEach(al::add);
        return al;
    }

    @Override
    public Team getById(long id) {
        Team t = teamRepository.findById(id).get();
        return t;
    }
    
    public List<Team> getTeamActive(){
        return teamRepository.findTeamActive();
    }

    @Override
    public void SaveOrUpdate(Team a) {
        teamRepository.save(a);
    }

    @Override
    public void deleteTeam(long id) {
        teamRepository.deleteById(id);
    }

    @Override
    public void deleteTeam(Team a) {
        teamRepository.delete(a);
    }
}
