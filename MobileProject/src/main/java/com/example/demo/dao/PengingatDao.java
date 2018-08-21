/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.dao;

import java.util.List;
import com.example.demo.model.*;

/**
 *
 * @author lutfi
 */
public interface PengingatDao {
    public List<Pengingat> getAllPengingat();
    public Pengingat getById(Long id);
    public void SaveOrUpdate(Pengingat a);
    public void deletePengingat(Long id);
    public void deletePengingat(Pengingat a);
}
