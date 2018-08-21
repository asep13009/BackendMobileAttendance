package com.example.demo.controller;

import com.example.demo.helper.enkriphelper;
import com.example.demo.model.DataLogin;
import com.example.demo.service.DataLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
@RestController
public class LoginController {
    @Autowired
    DataLoginService dataLoginService;
    @RequestMapping(value="login", method = RequestMethod.POST)
    public String login(@ModelAttribute("DataLogin")DataLogin dataLogin, @RequestParam("password")String password, @RequestParam("email")String email, ModelMap mm)  {
        String page;
        DataLogin p = null;
//		p = adminService.getLogin(email,password);
        try {
            p = dataLoginService.getLogin(email,enkriphelper.md5(password));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if(p == null || p.getStatus().equals("Disable")) {
            page="redirect:/adminlogin";
        }
        else {
            mm.put("penggunaaktif",p);
            page="redirect:loginn";
        }
        return page;
    }

}
