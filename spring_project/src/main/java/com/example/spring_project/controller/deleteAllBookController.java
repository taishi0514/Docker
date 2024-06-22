package com.example.spring_project.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.spring_project.entity.BookInfo;
import com.example.spring_project.repository.BookInfoRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class deleteAllBookController {

    private final BookInfoRepository bookInfoRepository;
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");



    @Scheduled(fixedRate = 36000)
    public void cleanUpOldBooks() {

        LocalDateTime oneHourAgo = LocalDateTime.now().minusHours(1);
        
        // Fetch books created before one hour ago
        List<BookInfo> books = bookInfoRepository.findAll();

        boolean deleteAll = books.stream().allMatch(book -> {
            LocalDateTime createdAt = LocalDateTime.parse(book.getRegisteredAt(), DATE_TIME_FORMATTER);
            return createdAt.isBefore(oneHourAgo);
        });

        if (deleteAll) {
            bookInfoRepository.deleteAll();
            System.out.println("All books deleted because no new book was added in the last hour.");
        } else {
            System.out.println("Books were not deleted because there are recent entries.");
        }
    }

}
