package com.example.demo.controller;

import com.example.demo.model.TipeKaryawan;
import com.example.demo.service.TipeKaryawanService;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TipeKaryawanController {
    @Autowired
    TipeKaryawanService tipeKaryawanService;
    
    @RequestMapping(value = "/inserttipekaryawan",method = RequestMethod.POST,headers = "Accept=application/json")
    public boolean insertTipeKayawan(@RequestParam("nama_tipekaryawan")String nama_typekaryawan){
        TipeKaryawan tipeKaryawan = new TipeKaryawan();
        tipeKaryawan.setCreateDate(new Date());
        tipeKaryawan.setNama_typekaryawan(nama_typekaryawan);
        tipeKaryawanService.SaveOrUpdate(tipeKaryawan);
        return true;
    }
    @RequestMapping(value = "/updatetipekaryawan",method = RequestMethod.POST,headers = "Accept=application/json")
    public boolean updateTipeKayawan(@RequestParam("id")long id,@RequestParam("nama_tipekaryawan")String nama_typekaryawan){
        TipeKaryawan tipeKaryawan = tipeKaryawanService.getById(id);
        tipeKaryawan.setId(id);
        tipeKaryawan.setUpdateDate(new Date());
        tipeKaryawan.setNama_typekaryawan(nama_typekaryawan);
        tipeKaryawanService.SaveOrUpdate(tipeKaryawan);
        return true;
    }
    @RequestMapping(value = "/deletetipekaryawan",method = RequestMethod.POST,headers = "Accept=application/json")
    public boolean deleteTipeKayawan(@RequestParam("id")long id){
        TipeKaryawan tipeKaryawan =tipeKaryawanService.getById(id);
        tipeKaryawanService.deleteTipeKaryawan(tipeKaryawan);
        return true;
    }
    @RequestMapping(value = "/disabletipekaryawan",method = RequestMethod.POST,headers = "Accept=application/json")
    public boolean disableTipeKayawan(@RequestParam("id")long id){
        TipeKaryawan tipeKaryawan =tipeKaryawanService.getById(id);
        tipeKaryawan.setStatus("Disable");
        tipeKaryawanService.SaveOrUpdate(tipeKaryawan);
        return true;
    }
    
//==============================================GET===========================================
    
    @RequestMapping(value = "/tipekaryawanall",method = RequestMethod.GET,headers="Accept=application/json")
	 public List<TipeKaryawan> tipekaryawanList(){
	     return tipeKaryawanService.getAllTipeKaryawan();
	 }
   
   @RequestMapping(value = "/tipekaryawanbyid",method = RequestMethod.GET)
   public TipeKaryawan tipekaryawbyid(@RequestParam("id")long id){
       return tipeKaryawanService.getById(id);
   }
   
   @RequestMapping(value = "/tipekaryawanaktif",method = RequestMethod.GET)
   public List<TipeKaryawan> tipekaryawbystatus(){
       return tipeKaryawanService.getTipeKaryawanActive();
   }
}
