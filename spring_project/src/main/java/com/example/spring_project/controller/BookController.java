package com.example.spring_project.controller;

import java.util.Optional;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.spring_project.authentication.UserDetailsImpl;
import com.example.spring_project.constant.UrlConst;
import com.example.spring_project.entity.BookInfo;
import com.example.spring_project.form.BookForm;
import com.example.spring_project.service.BookService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BookController {

	private final BookService service;


    @GetMapping(UrlConst.POST)
	public String viewPost(Model model, BookForm form) {
		return "post";
	}

    @PostMapping("/post")
	public String post(Model model, @Validated BookForm form, BindingResult bdResult,@AuthenticationPrincipal UserDetailsImpl userDetails) {
		if (bdResult.hasErrors()) {
			model.addAttribute("error", "文字数制限です");
			return "post";
		}


		Optional<BookInfo> bookInfoOpt = service.bookRegister(form,userDetails);
		
		// 多重送信防止のため、リダイレクト
        return "redirect:/main";


    }



}
