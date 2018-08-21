package com.example.demo.repository;

import com.example.demo.model.RoleLogin;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleLoginRepository extends CrudRepository<RoleLogin,Long> {
	 @Query(value = "SELECT r from  RoleLogin r where r.status='Active'")
	    List<RoleLogin> findRoleLoginActive();
}
