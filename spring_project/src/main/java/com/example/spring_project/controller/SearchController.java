package com.example.spring_project.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.spring_project.entity.BookInfo;
import com.example.spring_project.repository.BookInfoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class SearchController {

    private final BookInfoRepository bookInfoRepository;

    @GetMapping("/bookSearch")
    public String bookSearch(@RequestParam("bookName") String bookName, Model model, Principal principal) {

    // Integer userId = Integer.parseInt(principal.getName());
    // List<BookInfo> books = bookInfoRepository.findByUserId(userId);

    // List<BookInfo> bookList = bookInfoRepository.findALLByBookName(bookName);
    // model.addAttribute("bookName", bookList);
    Integer userId = Integer.parseInt(principal.getName());

    // List<BookInfo> books = bookInfoRepository.findByUserId(userId);
    // model.addAttribute("books", books);

    return "main";

    }

    
}
