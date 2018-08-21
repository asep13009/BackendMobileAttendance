
package com.example.demo.service;

import com.example.demo.dao.RoleLoginDao;
import com.example.demo.model.RoleLogin;
import com.example.demo.repository.RoleLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RoleLoginService implements RoleLoginDao {
    @Autowired
    RoleLoginRepository roleLoginRepository;
    @Override
    public List<RoleLogin> getAllAdmin() {
        List<RoleLogin> al = new ArrayList<>();
        roleLoginRepository.findAll().forEach(al::add);
        return al;
    }

    @Override
    public RoleLogin getById(long id) {
        RoleLogin lg = roleLoginRepository.findById(id).get();
        return lg;
    }
    
    public List<RoleLogin> getRoleLoginActive(){
        return roleLoginRepository.findRoleLoginActive();
    }

    @Override
    public void SaveOrUpdate(RoleLogin a) {
        roleLoginRepository.save(a);
    }

    @Override
    public void deleteRoleLogin(long id) {
        roleLoginRepository.deleteById(id);
    }

    @Override
    public void deleteRoleLogin(RoleLogin a) {
        roleLoginRepository.delete(a);
    }
}
