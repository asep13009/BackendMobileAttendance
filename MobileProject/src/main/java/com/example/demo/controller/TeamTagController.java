package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Tag;
import com.example.demo.model.Team;
import com.example.demo.model.TeamTag;
import com.example.demo.service.TagService;
import com.example.demo.service.TeamServices;
import com.example.demo.service.TeamTagService;

@RestController
public class TeamTagController {

	@Autowired
	TeamTagService teamTagService;
	
	@Autowired
	TeamServices teamService;
	
	@Autowired
	TagService tagService;
	
	
	// Insert teamtag
	@PostMapping(value = "/insertteamtag")
	public boolean insertTeamTag(@RequestParam("idTeam") long idTeam, @RequestParam("idTag") long idTag) {
		Team team = teamService.getById(idTeam);
		Tag tag = tagService.getById(idTag);
		teamTagService.saveOrUpdate(team, tag);
		return true;
	}
	
	// Get teamtag by id
	@GetMapping(value = "/getteamtag")
	public TeamTag getTeamTag(@RequestParam("idTeam") long idTeam, @RequestParam("idTag") long idTag) {
		Team team = teamService.getById(idTeam);
		Tag tag = tagService.getById(idTag);
		return teamTagService.getById(team, tag);
	}
	
//	@PutMapping(value = "/updateteamtag")
//	public boolean updateTeamTag(@RequestParam("idTeam") long idTeam, @RequestParam("idTag") long idTag) {
//		TeamTag tt = teamTagService.getById(idTeam, idTag);
//		Team team = teamService.getById(idTeam);
//		Tag tag = tagService.getById(idTag);
//		tt.se
//		teamTagService.saveOrUpdate(tt);
//		return true;
//	}
	
	// Non aktifkan teamtag
	@PostMapping(value = "/deleteteamtag")
	public boolean deleteTeamTag(@RequestParam("idTeam") long idTeam, @RequestParam("idTag") long idTag) {
		TeamTag tt = teamTagService.getById(idTeam, idTag);
		teamTagService.hapus(tt);
		return true;
	}
	
	// Tampilkan semua teamtag
	@GetMapping(value = "/teamtagall")
	public List<TeamTag> getAllTeamTag(){
		return teamTagService.getAll();
	}
	
	// Tampilkan semua teamtag aktif
	@GetMapping(value = "/teamtagactive")
	public List<TeamTag> getActiveTeamTag(){
		return teamTagService.getAllActive();
	}
	
	// Tampilkan teamtag berdassarkan team
	@GetMapping(value = "/teamtagbyteam")
	public List<TeamTag> getTeamTagByTeam(@RequestParam("idTeam") long idTeam){
		return teamTagService.getByTeam(idTeam);
	}
	
	// Tampilkan teamtag berdassarkan tag
	@GetMapping(value = "/teamtagbytag")
	public List<TeamTag> getTeamTagByTag(@RequestParam("idTag") long idTag){
		return teamTagService.getByTag(idTag);
	}
}
