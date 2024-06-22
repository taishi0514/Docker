// package com.example.spring_project.service;

// import java.text.SimpleDateFormat;
// import java.util.Date;
// import java.util.Optional;
// import java.util.TimeZone;

// import org.springframework.security.core.annotation.AuthenticationPrincipal;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// import com.example.spring_project.entity.UserInfo;
// import com.example.spring_project.form.SignupForm;
// import com.example.spring_project.repository.UserInfoRepository;
// import com.github.dozermapper.core.Mapper;

// import lombok.RequiredArgsConstructor;

// @Service
// @RequiredArgsConstructor
// public class UserUpdateService {

//     private final UserInfoRepository userInfoRepository;

//     private final SignupService service;

// 	/** Dozer Mapper */
// 	private final Mapper mapper;

// 	/** PasswordEncoder */
// 	private final PasswordEncoder passwordEncoder;

//     public Optional<UserInfo> editUserInfo(@AuthenticationPrincipal SignupForm form) {
// 		Optional<UserInfo> userInfoExistedOpt = userInfoRepository.findByEmail(form.getEmail());
// 		if (userInfoExistedOpt.isPresent()) {
// 			return Optional.empty();
// 		}


// 		UserInfo userInfo = mapper.map(form, UserInfo.class);
// 		String encodedPassword = passwordEncoder.encode(form.getPassword());

// 		userInfo.setPassword(encodedPassword);
// 		// userInfo.setUpdatedAT(updatedAt);
//         userInfo.setUpdatedAT(service.getTime());


// 		return Optional.of(userInfoRepository.save(userInfo));
// 	}
    
// }
