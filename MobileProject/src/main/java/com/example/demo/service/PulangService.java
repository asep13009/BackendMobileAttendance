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
import com.example.demo.repository.PulangRepository;

/**
 *
 * @author lutfi
 */
@Service
public class PulangService implements PulangDao{
	@Autowired
	PulangRepository pulangRepository;
    @Override
    public List<Pulang> getAllPulang() {
    	 List<Pulang> pulang = new ArrayList<>();
    	 pulangRepository.findAll().forEach(pulang::add);
         return pulang;
    }

    @Override
    public Pulang getById(Long id) {
    	Pulang pulang = pulangRepository.findById(id).get();
         return pulang;
    }

    @Override
    public Pulang SaveOrUpdate(Pulang a) {
    	pulangRepository.save(a);
        return a;
    }

    @Override
    public void deletePulang(Long id) {
    	pulangRepository.deleteById(id);
    }

    @Override
    public void deletePulang(Pulang a) {
    	pulangRepository.delete(a);
    }
    public List<Pulang> getPulangActive() {
        return pulangRepository.findPulangActive();
    }

}
