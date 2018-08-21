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
public class MasukService implements MasukDao{
	@Autowired
	MasukRepository masukRepository;
    @Override
    public List<Masuk> getAllMasuk() {
    	List<Masuk> masuk = new ArrayList<>();
    	masukRepository.findAll().forEach(masuk::add);
        return masuk;
    }

    @Override
    public Masuk getById(Long id) {
    	Masuk masuk = masukRepository.findById(id).get();
        return masuk;
    }

    @Override
    public Masuk SaveOrUpdate(Masuk a) {
    	masukRepository.save(a);
        return a;
    }

    @Override
    public void deleteMasuk(Long id) {
    	masukRepository.deleteById(id);
    }

    @Override
    public void deleteMasuk(Masuk a) {
    	masukRepository.delete(a);
    }
    public List<Masuk> getMasukActive() {
    	return masukRepository.findMasukActive();
    }
}
