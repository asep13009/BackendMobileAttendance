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
public class AbsenService implements AbsenDao{
	@Autowired
	AbsenRepository absenRepository;
    @Override
    public List<Absen> getAllAbsen() {
        List<Absen> absen = new ArrayList<>();
        absenRepository.findAll().forEach(absen::add);
        return absen;
    }

    @Override
    public Absen getById(Long id) {
        Absen absen = absenRepository.findById(id).get();
        return absen;
    }

    @Override
    public void SaveOrUpdate(Absen a) {
       absenRepository.save(a);
    }

    @Override
    public void deleteAbsen(Long id) {
        absenRepository.deleteById(id);
    }

    @Override
    public void deleteAbsen(Absen a) {
        absenRepository.delete(a); 
    }
    
}
