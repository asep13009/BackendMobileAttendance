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
public interface AbsenDao {
    public List<Absen> getAllAbsen();
    public Absen getById(Long id);
    public void SaveOrUpdate(Absen a);
    public void deleteAbsen(Long id);
    public void deleteAbsen(Absen a);
}
