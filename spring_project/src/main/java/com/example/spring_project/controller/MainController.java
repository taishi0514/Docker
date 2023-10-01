package com.example.spring_project.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.spring_project.constant.UrlConst;
import com.example.spring_project.entity.BookInfo;
import com.example.spring_project.form.BookForm;
import com.example.spring_project.service.BookService;

import org.springframework.ui.Model;


import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MainController {

	private final BookService service;

    @GetMapping(UrlConst.MAIN)
	public String view(Model model, BookForm form) {

		List<BookInfo> allBooks = service.getAllBooks();
		model.addAttribute("books", allBooks);

		return "main";
	}


    
}
