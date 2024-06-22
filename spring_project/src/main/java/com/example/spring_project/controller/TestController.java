package com.example.spring_project.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.spring_project.authentication.UserDetailsImpl;
import com.example.spring_project.constant.UrlConst;


@Controller
public class TestController {


    @GetMapping(UrlConst.MYPAGE)
    public String index(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        
        System.out.println(userDetails.getUsername());
        System.out.println(userDetails.getPassword());
        System.out.println(userDetails.getUserId());

        return "mypage";
    
    }
}