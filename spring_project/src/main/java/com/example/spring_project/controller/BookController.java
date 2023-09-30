package com.example.spring_project.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.spring_project.constant.UrlConst;
import com.example.spring_project.entity.BookInfo;
import com.example.spring_project.form.BookForm;
import com.example.spring_project.service.BookService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BookController {

	private final BookService service;

    @GetMapping(UrlConst.POST)
	public String viewPost(Model model, BookForm form) {
		return "post";
	}

    @PostMapping("/post")
	public String post(Model model, @Validated BookForm form, BindingResult bdResult) {
		if (bdResult.hasErrors()) {
			model.addAttribute("error", "文字数制限です");
		}

		Optional<BookInfo> bookInfoOpt = service.bookRegister(form);
		model.addAttribute("bookName", bookInfoOpt);

        return "main";
        }
}
