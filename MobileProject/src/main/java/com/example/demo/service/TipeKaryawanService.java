
package com.example.demo.service;

import com.example.demo.dao.TipeKaryawanDao;
import com.example.demo.model.TipeKaryawan;

import com.example.demo.repository.TipeKaryawanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TipeKaryawanService implements TipeKaryawanDao {
    @Autowired
    TipeKaryawanRepository tipeKaryawanRepository;
    @Override
    public List<TipeKaryawan> getAllTipeKaryawan() {
        List<TipeKaryawan> al = new ArrayList<>();
        tipeKaryawanRepository.findAll().forEach(al::add);
        return al;
    }

    @Override
    public TipeKaryawan getById(long id) {
        TipeKaryawan tk = tipeKaryawanRepository.findById(id).get();
        return tk;
    }
    
    public List<TipeKaryawan> getTipeKaryawanActive(){
        return tipeKaryawanRepository.findTipeKaryawanActive();
    }

    @Override
    public void SaveOrUpdate(TipeKaryawan a) {
        tipeKaryawanRepository.save(a);
    }

    @Override
    public void deleteTipeKaryawan(long id) {
        tipeKaryawanRepository.deleteById(id);
    }

    @Override
    public void deleteTipeKaryawan(TipeKaryawan a) {
        tipeKaryawanRepository.delete(a);
    }
}