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
public interface MasukDao {
    public List<Masuk> getAllMasuk();
    public Masuk getById(Long id);
    public Masuk SaveOrUpdate(Masuk a);
    public void deleteMasuk(Long id);
    public void deleteMasuk(Masuk a);
}
