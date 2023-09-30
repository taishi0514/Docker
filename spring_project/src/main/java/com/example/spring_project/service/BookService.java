package com.example.spring_project.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.TimeZone;

import org.springframework.stereotype.Service;

import com.example.spring_project.entity.BookInfo;
import com.example.spring_project.form.BookForm;
import com.example.spring_project.repository.BookInfoRepository;
import com.github.dozermapper.core.Mapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookInfoRepository bookInfoRepository;

    /** Dozer Mapper */
	private final Mapper mapper;


    public Optional<BookInfo> bookRegister(BookForm form) {

        TimeZone jp = TimeZone.getTimeZone("Asia/Tokyo");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		sdf.setTimeZone(jp);
		String createdat = sdf.format(new Date());

		BookInfo bookInfo = mapper.map(form, BookInfo.class);
        bookInfo.setRegisteredAt(createdat);

        return Optional.of(bookInfoRepository.save(bookInfo));
    }
    
}
