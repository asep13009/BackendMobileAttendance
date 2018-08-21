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
public interface LiburDao {
    public List<Libur> getAllLibur();
    public Libur getById(Long id);
    public void SaveOrUpdate(Libur a);
    public void deleteLibur(Long id);
    public void deleteLibur(Libur a);
}
