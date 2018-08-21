package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.TimeGroup;

public interface TimeGroupDao {
	public List<TimeGroup> getAllTimeGroup();
    public TimeGroup getById(Long id);
    public void SaveOrUpdate(TimeGroup t);
    public void deleteTimeGroup(Long id);
    public void deleteTimeGroup(TimeGroup t);
}
