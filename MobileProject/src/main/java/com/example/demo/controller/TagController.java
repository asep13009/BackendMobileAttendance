package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Tag;
import com.example.demo.service.TagService;

@RestController
public class TagController {

   

	@Autowired
	TagService ts;
	
	// Menyimpan tag baru
//	@PostMapping(value = "/inserttag")
//	public Tag saveTag(@ModelAttribute("tag") Tag t) {
//		return ts.saveTag(t);
//	}
	
	@RequestMapping(value = "/inserttag", method = RequestMethod.POST)
	public Tag saveTag(@RequestParam("namaTag") String namaTag) {
		Tag t = new Tag();
		t.setCreateDate(new Date());
		t.setNamaTag(namaTag);
		ts.saveTag(t);
		return t;
	}
	
	// Update tag
	@RequestMapping(value = "/updatetag", method = RequestMethod.POST)
	public Tag updateTag(@RequestParam("id") Long id, @RequestParam("namaTag") String namaTag) {
		Tag t = ts.getTag(id);
		t.setUpdateDate(new Date());
		t.setNamaTag(namaTag);
		ts.saveTag(t);
		return t;
	}
	
	// Hapus tag
	@RequestMapping(value = "/hapustag", method = RequestMethod.POST)
	public boolean hapusTag(@RequestParam("id") Long id) {
		Tag t = ts.getTag(id);
		ts.deleteTag(t);
		return true;
	}
	@RequestMapping(value = "/disabletag", method = RequestMethod.POST)
	public boolean disableTag(@RequestParam("id") Long id) {
		Tag t = ts.getTag(id);
		t.setStatus("disable");
		ts.SaveOrUpdate(t);
		return true;
	}
	
	//===========================================GET======================================================	

	 @RequestMapping(value = "/tagall",method = RequestMethod.GET)
     public List<Tag> tagList(){
         return ts.getAllTag();
     }
     @RequestMapping(value = "/tagbyid",method = RequestMethod.GET)
     public Tag tagbyid(@RequestParam("id")long id){
     return ts.getById(id);
     }
     
     @RequestMapping(value = "/tagaktif",method = RequestMethod.GET)
     public List<Tag> getTagActive(){
         return ts.getTagActive();
     }
}
