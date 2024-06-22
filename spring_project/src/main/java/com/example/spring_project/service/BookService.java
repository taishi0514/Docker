package com.example.spring_project.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import com.example.spring_project.authentication.UserDetailsImpl;
import com.example.spring_project.entity.BookInfo;
import com.example.spring_project.entity.UserInfo;
import com.example.spring_project.form.BookForm;
import com.example.spring_project.repository.BookInfoRepository;
import com.example.spring_project.repository.UserInfoRepository;
import com.github.dozermapper.core.Mapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {


    private final BookInfoRepository bookInfoRepository;

    private final UserInfoRepository userInfoRepository;

    /** Dozer Mapper */
	private final Mapper mapper;


    /** ブックテーブルに登録されている値を取得 */
    public List<BookInfo> getAllBooks(){
        return bookInfoRepository.findAll();
    }


    public Optional<BookInfo> bookRegister(BookForm form, @AuthenticationPrincipal UserDetailsImpl userDetails) {

       

        TimeZone jp = TimeZone.getTimeZone("Asia/Tokyo");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		sdf.setTimeZone(jp);
		String createdat = sdf.format(new Date());

		BookInfo bookInfo = mapper.map(form, BookInfo.class);
        bookInfo.setRegisteredAt(createdat);

        // ２０日に追加
        // Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        Integer userId = userDetails.getUserId();

        UserInfo currentUser = userInfoRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        bookInfo.setUserInfo(currentUser);
        
        return Optional.of(bookInfoRepository.save(bookInfo));
    }


    public List<BookInfo> getUserId(UserInfo user) {
        return bookInfoRepository.findByUserInfo(user);
    }
    
}
