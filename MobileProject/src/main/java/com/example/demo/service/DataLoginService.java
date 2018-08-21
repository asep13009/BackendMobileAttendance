
package com.example.demo.service;

import com.example.demo.dao.DataLoginDao;
import com.example.demo.model.DataLogin;
import com.example.demo.model.Karyawan;
import com.example.demo.repository.DataLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DataLoginService implements DataLoginDao {
    @Autowired
    DataLoginRepository dataLoginRepository;
    @Override
    public List<DataLogin> getAllDataLogin() {
        List<DataLogin> al = new ArrayList<>();
        dataLoginRepository.findAll().forEach(al::add);
        return al;
    }

    @Override
    public DataLogin getById(long id) {
        DataLogin dl = dataLoginRepository.findById(id).get();
        return  dl;
    }

    @Override
    public void SaveOrUpdate(DataLogin a) {
        dataLoginRepository.save(a);
    }

    @Override
    public void deleteDataLogin(long id) {
        dataLoginRepository.deleteById(id);
    }

    @Override
    public void deleteDataLogin(DataLogin a) {
        dataLoginRepository.delete(a);
    }
    public DataLogin getByKaryawan(Karyawan karyawan){
        return dataLoginRepository.getByKaryawan(karyawan);
    }

    public DataLogin getLogin(String email, String password){
        return dataLoginRepository.findByPassword(email,password);
    }
}

