package com.example.demo.service;

import com.example.demo.dao.JabatanDao;
import com.example.demo.model.Jabatan;
import com.example.demo.repository.JabatanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class JabatanService implements JabatanDao {
    @Autowired
    JabatanRepository jabatanRepository;
    @Override
    public List<Jabatan> getAllJabatan() {
        List<Jabatan> al = new ArrayList<>();
       jabatanRepository.findAll().forEach(al::add);
        return al;
    }

    @Override
    public Jabatan getById(long id) {
       Jabatan j = jabatanRepository.findById(id).get();
       return  j;
    }

    @Override
    public void SaveOrUpdate(Jabatan a) {
        jabatanRepository.save(a);
    }

    @Override
    public void deleteJabatan(long id) {
        jabatanRepository.deleteById(id);
    }

    @Override
    public void deleteJabatan(Jabatan a) {
        jabatanRepository.delete(a);
    }
    public List<Jabatan> getJabatanActive(){
    	return jabatanRepository.findJabatanActive();
    }
    
}
