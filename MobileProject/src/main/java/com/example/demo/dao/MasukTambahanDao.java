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
public interface MasukTambahanDao {
    public List<MasukTambahan> getAllMasukTambahan();
    public MasukTambahan getById(Long id);
    public void SaveOrUpdate(MasukTambahan a);
    public void deleteMasukTambahan(Long id);
    public void deleteMasukTambahan(MasukTambahan a);
}
