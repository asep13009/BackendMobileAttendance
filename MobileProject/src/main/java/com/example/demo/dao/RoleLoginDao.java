package com.example.demo.dao;

import com.example.demo.model.RoleLogin;

import java.util.List;

public interface RoleLoginDao {
    public List<RoleLogin> getAllAdmin();
    public RoleLogin getById(long id);
    public void SaveOrUpdate(RoleLogin a);
    public void deleteRoleLogin(long id);
    public void deleteRoleLogin(RoleLogin a);
}
