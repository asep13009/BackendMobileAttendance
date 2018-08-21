package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Tag;



public interface TagDao {


    public List<Tag> getAllTag();
    public Tag getById(long id);
    public void SaveOrUpdate(Tag a);
    public void deleteTag(long id);
    public void deleteTag(Tag a);
	

	public Tag getTag(Long id);

}
