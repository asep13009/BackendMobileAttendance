package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Approval;

import java.util.List;

@Repository
public interface ApprovalRepository extends CrudRepository<Approval,Long>{
    @Query(value = "select a from Approval a where a.status='Active'")
    List<Approval> getapprovalactive();
}
