package com.example.demo.repository;

import com.example.demo.model.DataLogin;
import com.example.demo.model.Karyawan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DataLoginRepository extends CrudRepository<DataLogin,Long> {
    DataLogin getByKaryawan(Karyawan karyawan);

    @Query(value = "Select a.password from DataLogin a where a.email=:email and a.password=:password")
    public DataLogin findByPassword(@Param("password") String password,@Param("email")String email);
}
