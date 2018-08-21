package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TeamTagDao;
import com.example.demo.model.Tag;
import com.example.demo.model.Team;
import com.example.demo.model.TeamTag;
import com.example.demo.repository.TeamTagRepository;

@Service
public class TeamTagService implements TeamTagDao{

	@Autowired
	TeamTagRepository teamTagRepository;
	
	@Autowired
	TeamServices teamService;
	
	@Autowired
	TagService tagService;
	
	@Override
	public void saveOrUpdate(Team idTeam, Tag idTag) {
		TeamTag tt = new TeamTag(idTeam.getId(), idTag.getId());
		teamTagRepository.save(tt);		
	}

	@Override
	public void delete(TeamTag tt) {
		teamTagRepository.delete(tt);
	}

	@Override
	public List<TeamTag> getAll() {
		List<TeamTag> ltt = new ArrayList<>();
		teamTagRepository.findAll().forEach(ltt::add);
		return ltt;
	}

	@Override
	public List<TeamTag> getAllActive() {
		List<TeamTag> ltt = new ArrayList<>();
		teamTagRepository.findByStatus().forEach(ltt::add);
		return ltt;
	}

	@Override
	public List<TeamTag> getByTeam(Long idTeam) {
		List<TeamTag> ltt = new ArrayList<>();
		teamTagRepository.findByIdIdTeam(idTeam).forEach(ltt::add);
		return ltt;
	}

	@Override
	public List<TeamTag> getByTag(Long idTag) {
		List<TeamTag> ltt = new ArrayList<>();
		teamTagRepository.findByIdIdTag(idTag).forEach(ltt::add);
		return ltt;
	}

	@Override
	public TeamTag getById(Team idTeam, Tag idTag) {
		TeamTag tt = teamTagRepository.getByIdIdTeamAndIdIdTag(idTeam.getId(), idTag.getId());
		return tt;
	}

	@Override
	public void saveOrUpdate(TeamTag tt) {
		teamTagRepository.save(tt);		
	}

	@Override
	public TeamTag getById(Long idTeam, Long idTag) {
		return teamTagRepository.getByIdIdTeamAndIdIdTag(idTeam, idTag);
	}

	@Override
	public void hapus(TeamTag tt) {
		tt.setStatus("Not Active");
		teamTagRepository.save(tt);	
	}

}
