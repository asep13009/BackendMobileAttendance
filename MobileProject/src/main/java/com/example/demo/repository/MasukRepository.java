/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.*;

/**
 *
 * @author lutfi
 */
@Repository
public interface MasukRepository extends CrudRepository<Masuk,Long>{
	@Query(value = "SELECT a from  Masuk a where a.status='Active'")
    List<Masuk> findMasukActive();
}
