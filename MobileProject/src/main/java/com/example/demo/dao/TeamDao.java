package com.example.demo.dao;

import com.example.demo.model.Team;

import java.util.List;

public interface TeamDao {
    public List<Team> getAllTeam();
    public Team getById(long id);
    public void SaveOrUpdate(Team a);
    public void deleteTeam(long id);
    public void deleteTeam(Team a);
}
