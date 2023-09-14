package com.example.spring_project.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.TimeZone;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.spring_project.entity.UserInfo;
import com.example.spring_project.form.SignupForm;
import com.example.spring_project.repository.UserInfoRepository;
import com.github.dozermapper.core.Mapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SignupService {

    private final UserInfoRepository userInfoRepository;

	/** Dozer Mapper */
	private final Mapper mapper;

	/** PasswordEncoder */
	private final PasswordEncoder passwordEncoder;

    public Optional<UserInfo> resistUserInfo(SignupForm form) {
		var userInfoExistedOpt = userInfoRepository.findByEmail(form.getEmail());
		if (userInfoExistedOpt.isPresent()) {
			return Optional.empty();
		}


		Date nowDate = new Date();
		TimeZone jp = TimeZone.getTimeZone("Asia/Tokyo");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		sdf.setTimeZone(jp);
		String createdat = sdf.format(nowDate);

		UserInfo userInfo = mapper.map(form, UserInfo.class);
		String encodedPassword = passwordEncoder.encode(form.getPassword());
		// userInfo.setUserName(form.getUserName());
		// userInfo.setEmail(form.getEmail());
		userInfo.setPassword(encodedPassword);
		userInfo.setCreatedAt(createdat);

		return Optional.of(userInfoRepository.save(userInfo));
	}
	
}
