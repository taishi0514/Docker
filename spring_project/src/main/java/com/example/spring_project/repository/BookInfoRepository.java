package com.example.spring_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.spring_project.entity.BookInfo;
import com.example.spring_project.entity.UserInfo;

@Repository
public interface BookInfoRepository extends JpaRepository<BookInfo, Integer>{

    List<BookInfo> findByUserInfo(UserInfo user);

    
}
