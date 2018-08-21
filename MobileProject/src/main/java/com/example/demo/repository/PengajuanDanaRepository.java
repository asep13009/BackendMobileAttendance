package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Karyawan;
import com.example.demo.model.PengajuanDana;
import com.example.demo.model.TipePengajuan;

@Repository
public interface PengajuanDanaRepository extends CrudRepository<PengajuanDana, Long>{
	
	List<PengajuanDana> findByKaryawan(Karyawan karyawan);
	List<PengajuanDana> findByTipePengajuan(TipePengajuan tipePengajuan);
	@Query(value = "SELECT a from PengajuanDana a where a.status='Active'")
	List<PengajuanDana>getpengajuandanaactive();

}
