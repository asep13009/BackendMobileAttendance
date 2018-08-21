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
public interface LiburRepository extends CrudRepository<Libur,Long> {
	 @Query(value = "SELECT l from  Libur l where l.status='Active'")
	    List<Libur> findLiburActive();
}
