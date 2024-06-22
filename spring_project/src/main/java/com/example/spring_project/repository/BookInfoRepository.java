package com.example.spring_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.spring_project.entity.BookInfo;
import com.example.spring_project.entity.UserInfo;

@Repository
public interface BookInfoRepository extends JpaRepository<BookInfo, Integer>{

    List<BookInfo> findByUserInfo(UserInfo user);

    // List<BookInfo> findALLByBookName(String bookName);
    // List<BookInfo> findByUserId(Integer userId);
    

    // @Query(value = "SELECT user_id FROM book_info b JOIN user_info u ON b.user_id = u.user_id WHERE u.user_id = :userId", nativeQuery = true)
        // List<BookInfo> findByUserId(@Param("userId")Integer userId);

    // List<BookInfo> findByUserIdAndBookName(@Param("userId")Integer userId, @Param("bookName")String bookName);

    // List<BookInfo> findByUserId(Integer userId);

    
}
