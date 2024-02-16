package com.company.SpringSecurity.Controler;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/control")
public class control {

    @GetMapping("/home")
    public String getHome(){
        System.out.println("home page work");
        return "this is home page";

    }
    @GetMapping("/dashboard")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String getDashboard(){

        return "this is dash board page";
    }

    @GetMapping("/manage")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getManage(){
        System.out.println("this is manage page");
        return "this is manage page";
    }



}

