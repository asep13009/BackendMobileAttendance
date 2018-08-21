package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Tag;
import com.example.demo.model.Team;
import com.example.demo.model.TeamTag;

public interface TeamTagDao {

	public void saveOrUpdate(Team team, Tag tag);
	public void saveOrUpdate(TeamTag tt);
	public void hapus(TeamTag tt);
	public void delete(TeamTag tt);
	public TeamTag getById(Team team, Tag tag);
	public TeamTag getById(Long idTeam, Long idTag);
	public List<TeamTag> getAll();
	public List<TeamTag> getAllActive();
	public List<TeamTag> getByTeam(Long idTeam);
	public List<TeamTag> getByTag(Long idTag);
}
