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
public interface PulangDao {
    public List<Pulang> getAllPulang();
    public Pulang getById(Long id);
    public Pulang SaveOrUpdate(Pulang a);
    public void deletePulang(Long id);
    public void deletePulang(Pulang a);
}
