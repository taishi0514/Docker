package com.example.spring_project.service;

import org.springframework.stereotype.Service;

import com.example.spring_project.entity.UserInfo;
import com.example.spring_project.repository.UserInfoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    
    private final UserInfoRepository userInfoRepository;

    public UserInfo findById(Integer userId) {
        return userInfoRepository.findById(userId).orElse(null);
    }
    
}
