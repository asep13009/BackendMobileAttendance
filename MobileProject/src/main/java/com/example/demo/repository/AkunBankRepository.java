package com.example.demo.repository;

import com.example.demo.model.AkunBank;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AkunBankRepository extends CrudRepository<AkunBank,Long> {
    @Query(value = "SELECT a from  AkunBank a where a.status='Active'")
    List<AkunBank> findAkunBankActive();
}
