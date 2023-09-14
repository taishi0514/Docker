package com.example.spring_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.spring_project.constant.UrlConst;

@Controller
public class MainController {

    @GetMapping(UrlConst.MAIN)
	public String view() {

		return "main";
	}

    
}
