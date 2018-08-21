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
public class PengingatService implements PengingatDao{
	@Autowired
	PengingatRepository pengingatRepository;
    @Override
    public List<Pengingat> getAllPengingat() {
    	List<Pengingat> pengingat = new ArrayList<>();
    	pengingatRepository.findAll().forEach(pengingat::add);
        return pengingat;
    }

    @Override
    public Pengingat getById(Long id) {
    	Pengingat pengingat = pengingatRepository.findById(id).get();
        return pengingat;
    }

    @Override
    public void SaveOrUpdate(Pengingat a) {
    	pengingatRepository.save(a);
    }

    @Override
    public void deletePengingat(Long id) {
    	pengingatRepository.deleteById(id);
    }

    @Override
    public void deletePengingat(Pengingat a) {
    	pengingatRepository.delete(a);
    }
    public List<Pengingat> getPengingatActive() {
        return pengingatRepository.findPengingatActive();
    }

}
