package com.example.backoffice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminResource {

    @Autowired
    AdminRepository adminRepo;


    @RequestMapping("/admin")
    public List<Admin> getAdmin(){
        return adminRepo.findAll();
    }

    @RequestMapping("/admin/{id}")
    public Admin getAdmin(@PathVariable("id") long id){
        return adminRepo.findById(id);
    }

}
