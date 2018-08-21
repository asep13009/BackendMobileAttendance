package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Pulang;
import com.example.demo.service.PulangService;

import de.odysseus.el.tree.impl.Parser.ParseException;
@RestController
public class CheckoutController {
	@Autowired
	 PulangService pulangService;
	
	 
	 //Insert Pulang
	 @RequestMapping(value = "/insertpulang/",method = RequestMethod.POST,headers="Accept=application/json")
	 public boolean insertPulang(@RequestParam (value = "lattitude_pulang", required = false) Float lattitude_pulang,
	                                     @RequestParam(value = "longitude_pulang", required = false) Float longitude_pulang,
	                                     @RequestParam(value = "status", required = false) Boolean status
	                                    
	    ){
		 	Pulang pulang = new Pulang();
		 	pulang.setCreateDate(new Date());
		 	
		 	pulang.setLatitude_pulang(lattitude_pulang);
		 	pulang.setLongitude_pulang(longitude_pulang);
		 	pulang.setStatus_fraud(status);
		 	pulangService.SaveOrUpdate(pulang);
	        return true;
	    }
	 //Update Pulang
	 @RequestMapping(value = "/updatepulang/",method = RequestMethod.POST,headers="Accept=application/json")
	 public boolean updatePulang(@RequestParam(value = "id",required = false)  Long id,
									    		@RequestParam (value = "lattitude_pulang", required = false) Float lattitude_pulang,
								               @RequestParam(value = "longitude_pulang", required = false) Float longitude_pulang,
								               @RequestParam(value = "status", required = false) Boolean status
	    )throws ParseException {
		 	Pulang pulang = pulangService.getById(id);
		 	pulang.setUpdateDate(new Date());
		 	pulang.setJam_pulang(new Date());
		 	pulang.setLatitude_pulang(lattitude_pulang);
		 	pulang.setLongitude_pulang(longitude_pulang);
		 	pulang.setStatus_fraud(status);
		 	pulangService.SaveOrUpdate(pulang);
		 	return true;
	    }
	 
	 //Delete Pulang
	 @RequestMapping(value = "/deletepulang/",method = RequestMethod.POST,headers="Accept=application/json")
	 public boolean deletePulang(@RequestParam(value = "id",required = false)  Long id)throws ParseException {
		 Pulang pulang = pulangService.getById(id);
		 pulangService.deletePulang(pulang);
		 return true;
	 }
	 @RequestMapping(value = "/disablepulang/",method = RequestMethod.POST,headers="Accept=application/json")
	 public boolean disablePulang(@RequestParam(value = "id",required = false)  Long id)throws ParseException {
		 Pulang pulang = pulangService.getById(id);
		 pulang.setStatus("disable");
		 pulangService.SaveOrUpdate(pulang);
		 return true;
	 
	 }
	 
//=============================================GET==============================================
	 @RequestMapping(value = "/pulangall",method = RequestMethod.GET)
	 public List<Pulang> pulangList(){
	     return pulangService.getAllPulang();
	 }
	 @RequestMapping(value = "/pulangbyid",method = RequestMethod.GET)
	 public Pulang pulangbyid(@RequestParam("id")long id){
	 return pulangService.getById(id);
	 }
	 
	 @RequestMapping(value = "/pulangaktif",method = RequestMethod.GET)
     public List<Pulang> getPulangActive(){
         return pulangService.getPulangActive();
     }
}
