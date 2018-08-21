/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.dao.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.*;
import com.example.demo.repository.*;

/**
 *
 * @author lutfi
 */
@Service
public class LiburService implements LiburDao{
	@Autowired
	LiburRepository liburRepository;
    @Override
    public List<Libur> getAllLibur() {
    	List<Libur> libur = new ArrayList<>();
    	liburRepository.findAll().forEach(libur::add);
        return libur;
    }

    @Override
    public Libur getById(Long id) {
    	Libur libur = liburRepository.findById(id).get();
        return libur;
    }
    
    public List<Libur> getLiburActive(){
        return liburRepository.findLiburActive();
    }

    @Override
    public void SaveOrUpdate(Libur a) {
    	liburRepository.save(a);
    }

    @Override
    public void deleteLibur(Long id) {
    	liburRepository.deleteById(id);
    }

    @Override
    public void deleteLibur(Libur a) {
    	liburRepository.delete(a); 
    }
    
}
