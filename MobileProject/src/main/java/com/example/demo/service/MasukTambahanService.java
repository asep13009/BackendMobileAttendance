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
public class MasukTambahanService implements MasukTambahanDao{
	@Autowired
	MasukTambahanRepository masuktambahanRepository;
    @Override
    public List<MasukTambahan> getAllMasukTambahan() {
    	List<MasukTambahan> masuktambahan = new ArrayList<>();
    	masuktambahanRepository.findAll().forEach(masuktambahan::add);
        return masuktambahan;
    }

    @Override
    public MasukTambahan getById(Long id) {
    	MasukTambahan masuktambahan = masuktambahanRepository.findById(id).get();
        return masuktambahan;
    }
    
    public List<MasukTambahan> getMasukTambahanActive(){
        return masuktambahanRepository.findMasukTambahanActive();
    }

    @Override
    public void SaveOrUpdate(MasukTambahan a) {
    	masuktambahanRepository.save(a);
    }

    @Override
    public void deleteMasukTambahan(Long id) {
    	masuktambahanRepository.deleteById(id);
    }

    @Override
    public void deleteMasukTambahan(MasukTambahan a) {
    	masuktambahanRepository.delete(a);
    }
    
}
