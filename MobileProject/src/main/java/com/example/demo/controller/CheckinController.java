package com.example.demo.controller;

import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.*;
import com.example.demo.service.*;

import de.odysseus.el.tree.impl.Parser.ParseException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import sun.misc.BASE64Decoder;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;

import javax.imageio.ImageIO;



import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

@RestController
public class CheckinController {
	String currentDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	@Autowired
	PulangService pulangService;
	@Autowired
	FileStorageService fileStorageService;
	@Autowired
	DataLoginService dataLoginService;
	@Autowired
	MasukService masukService;
	@Autowired
	AbsenService absenService;
	 //Insert Masuk
	public final String SaveDirectory= "D:/LawenconBootcamp/GitProjek/MobileProject/MobileProject/uploads/";
	       @RequestMapping(value = "/insertmasuk",method = RequestMethod.POST,headers="Accept=application/json")
	public String insertMasuk(@RequestParam (value = "lattitude_masuk", required = false) Double lattitude_masuk,
							  @RequestParam(value = "longitude_masuk", required = false) Double longitude_masuk,
							  @RequestParam(value = "status", required = false) Boolean status, @ModelAttribute("Masuk")Masuk masuk,
							  @ModelAttribute("Absen")Absen absen, @RequestParam("file")String file, HttpServletRequest request,
							  @ModelAttribute("Pulang")Pulang pulang) throws IOException {

		//====================================menghilankan header=============================
		 String mix = String.valueOf(Math.random());
		 String max = mix.replace(".","");
		 String cleanbase64 = fileStorageService.removeBase64Header(file);
         BASE64Decoder decoder = new BASE64Decoder();
		 byte[] decodeBytes = decoder.decodeBuffer(cleanbase64);
		 FileOutputStream fileOutputStream = new FileOutputStream(SaveDirectory +"halo".concat(max.concat(currentDate))+".png");
		 fileOutputStream.write(decodeBytes);
		 String lcal= "halo".concat(max.concat(currentDate))+".png";
		 masuk.setLattitude_masuk(lattitude_masuk);
		 masuk.setLongitude_masuk(longitude_masuk);
		 masuk.setStatus_fraud(status);
		 masuk = masukService.SaveOrUpdate(masuk);
		 pulang.setCreateBy("halloo");
		 pulang = pulangService.SaveOrUpdate(pulang);
		 absen.setPulang(pulang);
		 absen.setMasuk(masuk);
		 absen.setTanggal(new Date());
		 absen.setTotal_jam_kerja(new Date());
		 absen.setFoto_path(lcal);
//		 absen.setDataLogin(dataLoginService.getById(1));
		 absenService.SaveOrUpdate(absen);
		 System.out.println(decodeBytes);
	     return cleanbase64;
	}
	 //Update Masuk
	@RequestMapping(value = "/updatemasuk/",method = RequestMethod.POST,headers="Accept=application/json")
    public boolean updatePengingat(@RequestParam(value = "id",required = false)  Long id,
									    		@RequestParam(value = "jam_masuk",required = false) @DateTimeFormat(pattern="HH:mm:dd") Date jam_masuk,
								                @RequestParam (value = "lattitude_masuk", required = false) Double lattitude_masuk,
								               	@RequestParam(value = "longitude_masuk", required = false) Double longitude_masuk,
								               	@RequestParam(value = "status", required = false) Boolean status
	    )throws ParseException {
		Masuk masuk = masukService.getById(id);
	 	masuk.setJam_masuk(jam_masuk);
		masuk.setLattitude_masuk(lattitude_masuk);
	 	masuk.setLongitude_masuk(longitude_masuk);
	 	masuk.setStatus_fraud(status);
	 	masukService.SaveOrUpdate(masuk);
	 	return true;
	 }
	//Delete Masuk
	@RequestMapping(value = "/deletemasuk/",method = RequestMethod.POST,headers="Accept=application/json")
	public boolean deleteMasuk(@RequestParam(value = "id",required = false)  Long id)throws ParseException {
		Masuk masuk = masukService.getById(id);
		masukService.deleteMasuk(masuk);
		return true;
	}
	@RequestMapping(value = "/disablemasuk/",method = RequestMethod.POST,headers="Accept=application/json")
	public boolean disableMasuk(@RequestParam(value = "id",required = false)  Long id)throws ParseException {
		Masuk masuk = masukService.getById(id);
		masuk.setStatus("status");
		masukService.SaveOrUpdate(masuk);
		return true;
	 }	    
	 
//================================================================GET===================================
	@RequestMapping(value = "/masukall",method = RequestMethod.GET)
		public List<Absen> masukList(){
			return absenService.getAllAbsen();
		}
		
	 @RequestMapping(value = "/masukbyid",method = RequestMethod.GET)
	 public Masuk masukbyid(@RequestParam("id")long id){
	 return masukService.getById(id);
	 }
	 
	 @RequestMapping(value = "/masukaktif",method = RequestMethod.GET)
	 public List<Masuk> getMasukActive(){
	 return masukService.getMasukActive();
	 }
}
