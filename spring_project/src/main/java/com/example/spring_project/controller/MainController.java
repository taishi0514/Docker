package com.example.spring_project.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.spring_project.authentication.UserDetailsImpl;
import com.example.spring_project.constant.UrlConst;
import com.example.spring_project.entity.BookInfo;
import com.example.spring_project.entity.UserInfo;
import com.example.spring_project.repository.BookInfoRepository;
import com.example.spring_project.service.BookService;

import org.springframework.ui.Model;


import lombok.AllArgsConstructor;


@Controller
@AllArgsConstructor
public class MainController {

	private final BookService service;

	private final BookInfoRepository bookInfoRepository;

    @GetMapping(UrlConst.MAIN)
	public String view(Model model,@AuthenticationPrincipal UserDetailsImpl userDetails) {

		UserInfo currentUser = userDetails.getUser();
        List<BookInfo> userBooks = service.getUserId(currentUser);
        
        // モデルにユーザーの投稿を追加
        model.addAttribute("userBooks", userBooks);

		
		return "main";
	}


	@GetMapping("/main/{bookId}")
	public String bookDetails(@PathVariable Integer bookId, Model model) {

		// bookIdを使ってデータベースからブック情報を取得
		BookInfo bookInfo = bookInfoRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book ID: " + bookId));

        model.addAttribute("bookInfo", bookInfo);
		return "bookDetail";
	}
	

    
}
