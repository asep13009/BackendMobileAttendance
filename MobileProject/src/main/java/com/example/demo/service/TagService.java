package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TagDao;
import com.example.demo.model.Tag;
import com.example.demo.repository.TagRepository;


@Service
public class TagService implements TagDao{
	
	@Autowired
	TagRepository tr;
	


	@Override
	public List<Tag> getAllTag() {
		List<Tag> lt =new ArrayList<>();
		tr.findAll().forEach(lt::add);
		return lt;
	}

	@Override

	public Tag getById(long id) {
		// TODO Auto-generated method stub
		return tr.findById(id).get();
	}

	public Tag getTag(Long id) {
		return tr.getById(id);
	}

	
	
	public Tag saveTag(Tag t) {
		return tr.save(t);
	}
	
	public void deleteTag(Tag t) {
		tr.delete(t);
	}

	

	@Override
	public void SaveOrUpdate(Tag a) {
		// TODO Auto-generated method stub
		tr.save(a);
	}

	@Override
	public void deleteTag(long id) {
		// TODO Auto-generated method stub
		tr.deleteById(id);
	}
	public List<Tag> getTagActive() {
        return tr.findTagActive();
    }

	
}
