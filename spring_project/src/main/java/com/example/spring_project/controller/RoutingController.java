package com.example.spring_project.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.spring_project.constant.UrlConst;


@Controller
public class RoutingController {

    @GetMapping(UrlConst.MYPAGE)
	public String mypage() {

		return "mypage";
	}

    @GetMapping(UrlConst.LOGOUT)
	public String logout() {

		return "logout";
	}

    
}
