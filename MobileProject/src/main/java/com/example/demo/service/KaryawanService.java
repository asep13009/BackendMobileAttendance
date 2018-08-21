
package com.example.demo.service;

import com.example.demo.dao.KaryawanDao;
import com.example.demo.model.Karyawan;
import com.example.demo.repository.KaryawanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class KaryawanService implements KaryawanDao {
    @Autowired
    KaryawanRepository karyawanRepository;
    @Override
    public List<Karyawan> getAllKaryawan() {
        List<Karyawan> al = new ArrayList<>();
        karyawanRepository.findAll().forEach(al::add);
        return al;
    }

    @Override
    public Karyawan getById(long id) {
        Karyawan k = karyawanRepository.findById(id).get();
        return k;
    }
    
    public List<Karyawan> getKaryawanActive(){
        return karyawanRepository.findKaryawanActive();
    }

    @Override
    public Karyawan SaveOrUpdate(Karyawan k) {
        karyawanRepository.save(k);
        return k;
    }

    @Override
    public void deleteKaryawan(long id) {
        karyawanRepository.deleteById(id);
    }

    @Override
    public void deleteKaryawan(Karyawan a) {
        karyawanRepository.delete(a);
    }
}