
package com.example.demo.service;

import com.example.demo.dao.AkunBankDao;
import com.example.demo.model.AkunBank;
import com.example.demo.repository.AkunBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AkunBankService implements AkunBankDao {
    @Autowired
    AkunBankRepository akunBankRepository;
    @Override
    public List<AkunBank> getAllAkunBank() {
        List<AkunBank> al = new ArrayList<>();
        akunBankRepository.findAll().forEach(al::add);
        return al;
    }

    @Override
    public AkunBank getById(long id) {
        AkunBank ak = akunBankRepository.findById(id).get();
        return ak;
    }

    @Override
    public void SaveOrUpdate(AkunBank a) {
        akunBankRepository.save(a);
    }

    @Override
    public void deleteAkunBank(long id) {
        akunBankRepository.deleteById(id);
    }

    @Override
    public void deleteAkunBank(AkunBank a) {
        akunBankRepository.delete(a);
    }

    public List<AkunBank> getAkunBankActive(){
        return akunBankRepository.findAkunBankActive();
    }
}
