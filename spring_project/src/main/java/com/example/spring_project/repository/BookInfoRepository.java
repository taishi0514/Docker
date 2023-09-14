package com.example.spring_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_project.entity.BookInfo;

@Repository
public interface BookInfoRepository extends JpaRepository<BookInfo, Integer>{
    
}
