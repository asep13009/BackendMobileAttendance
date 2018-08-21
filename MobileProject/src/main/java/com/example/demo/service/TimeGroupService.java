package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TimeGroupDao;
import com.example.demo.model.TimeGroup;
import com.example.demo.repository.TimeGroupRepository;

@Service
public class TimeGroupService implements TimeGroupDao {
    @Autowired
    TimeGroupRepository timeGroupRepository;
    @Override
    public List<TimeGroup> getAllTimeGroup() {
        List<TimeGroup> al = new ArrayList<>();
        timeGroupRepository.findAll().forEach(al::add);
        return al;
    }    
    @Override
    public void deleteTimeGroup(TimeGroup a) {
        timeGroupRepository.delete(a);
    }

	@Override
	public TimeGroup getById(Long id) {
		
		return timeGroupRepository.findById(id).get();
	}

	@Override
	public void deleteTimeGroup(Long id) {
		timeGroupRepository.deleteById(id);
		
	}


	@Override
	public void SaveOrUpdate(TimeGroup t) {
		timeGroupRepository.save(t);
		
	}
	public List<TimeGroup> getTimeGroupActive() {
		return timeGroupRepository.findTimeGroupActive();
	}

	
}
