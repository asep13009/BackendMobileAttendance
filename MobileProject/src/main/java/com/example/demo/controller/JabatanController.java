package com.example.demo.controller;

import com.example.demo.model.Jabatan;
import com.example.demo.service.JabatanService;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JabatanController {
    @Autowired
    JabatanService jabatanService;
    @RequestMapping(value = "/insertjabatan",method = RequestMethod.POST,headers = "Accept=application/json")
    public  boolean insertJabatan(@RequestParam("nama_jabatan") String nama_jabatan){
        Jabatan jabatan = new Jabatan();
        jabatan.setNama_jabatan(nama_jabatan);
        jabatan.setCreateDate(new Date());
        jabatanService.SaveOrUpdate(jabatan);
        return true;
    }
    @RequestMapping(value = "/updatejabatan",method = RequestMethod.POST,headers = "Accept=application/json")
    public  boolean updateJabatan(@RequestParam("id")long id,@RequestParam("nama_jabatan") String nama_jabatan){
        Jabatan jabatan = jabatanService.getById(id);
        jabatan.setId(id);
        jabatan.setNama_jabatan(nama_jabatan);
        jabatan.setUpdateDate(new Date());
        jabatanService.SaveOrUpdate(jabatan);
        return true;
    }
    @RequestMapping(value = "/deletejabatan",method = RequestMethod.POST,headers = "Accept=application/json")
    public  boolean deleteJabatan(@RequestParam("id")long id,@RequestParam("nama_jabatan") String nama_jabatan){
        Jabatan jabatan = jabatanService.getById(id);
        jabatanService.deleteJabatan(jabatan);
        return true;
    }
    @RequestMapping(value = "/disablejabatan",method = RequestMethod.POST,headers = "Accept=application/json")
    public  boolean disableJabatan(@RequestParam("id")long id){
        Jabatan jabatan = jabatanService.getById(id);
        jabatan.setStatus("Disable");
        jabatanService.SaveOrUpdate(jabatan);
        return true;
    }

//===================================================GET==================================================
    @RequestMapping(value = "/jabatanall",method = RequestMethod.GET,headers = "Accept=application/json")
    public  List<Jabatan> getAllJabatan(){
        return jabatanService.getAllJabatan();
    }
    @RequestMapping(value = "/jabatanbyid",method = RequestMethod.GET,headers = "Accept=application/json")
    public  Jabatan byIdJabatan(@RequestParam("id")long id){
        
        return jabatanService.getById(id);
        
    }
    @RequestMapping(value = "/jabatanaktif",method = RequestMethod.GET)
    public List<Jabatan> getJabatanActive(){
        return jabatanService.getJabatanActive();
    }
}
