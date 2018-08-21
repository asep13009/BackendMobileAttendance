package com.example.demo.controller;

import com.example.demo.model.Venue;
import com.example.demo.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class VenueController {
    @Autowired
    VenueService venueService;
    
   
    @RequestMapping(value = "/insertvenue",method = RequestMethod.POST,headers="Accept=application/json")
    public boolean insertVenue(@RequestParam("nama_venue") String nama_venue, @RequestParam("deskripsi_venue")String deskripsi_venue,
                               @RequestParam("alamat_venue")String alamat_venue, @RequestParam("latitude_venue")Double latitude_venue,
                               @RequestParam("longitude_venue")Double longitude_venue, @RequestParam("radius_venue")Double radius_venue){
        Venue venue= new Venue();
        venue.setNama_venue(nama_venue);
        venue.setDeskripsi_venue(deskripsi_venue);
        venue.setAlamat_venue(alamat_venue);
        venue.setCreateDate(new Date());
        venue.setLatitude_venue(latitude_venue);
        venue.setLongitude_venue(longitude_venue);
        venue.setRadius_venue(radius_venue);
        venue.setStatus("Active");
        venueService.SaveOrUpdate(venue);
        return true;
    }
    @RequestMapping(value = "/updatevenue",method = RequestMethod.POST,headers="Accept=application/json")
    public boolean updateVenue(@RequestParam("id")long id,@RequestParam("nama_venue") String nama_venue, @RequestParam("deskripsi_venue")String deskripsi_venue,
                               @RequestParam("alamat_venue")String alamat_venue, @RequestParam("latitude_venue")Double latitude_venue,
                               @RequestParam("longitude_venue")Double longitude_venue, @RequestParam("radius_venue")Double radius_venue){
        Venue venue= venueService.getById(id);
        venue.setId(id);
        venue.setNama_venue(nama_venue);
        venue.setDeskripsi_venue(deskripsi_venue);
        venue.setAlamat_venue(alamat_venue);
        venue.setLatitude_venue(latitude_venue);
        venue.setLongitude_venue(longitude_venue);
        venue.setRadius_venue(radius_venue);
        venue.setUpdateDate(new Date());
        venueService.SaveOrUpdate(venue);
        return true;
    }
    @RequestMapping(value = "/deletevenue",method = RequestMethod.POST,headers="Accept=application/json")
    public boolean updateVenue(@RequestParam("id")long id){
        Venue venue= venueService.getById(id);
        venueService.deleteVenue(venue);
        return true;
    }
    @RequestMapping(value = "/disablevenue",method = RequestMethod.POST,headers="Accept=application/json")
    public boolean disableVenue(@RequestParam("id")long id){
        Venue venue= venueService.getById(id);
        venue.setStatus("disable");
        venueService.SaveOrUpdate(venue);
        return true;
    }
    
//=============================================GET=============================================
    
    @RequestMapping(value = "/venueall",method = RequestMethod.GET,headers="Accept=application/json")
	 public List<Venue> venueList(){
	     return venueService.getAllVenue();
	 }
   
   @RequestMapping(value = "/venuebyid",method = RequestMethod.GET)
   public Venue venuebyid(@RequestParam("id")long id){
       return venueService.getById(id);
   }
   
   @RequestMapping(value = "/venueaktif",method = RequestMethod.GET)
   public List<Venue> venuebystatus(){
       return venueService.getVenueActive();
   }
   
}
