package com.example.spring_project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.example.spring_project.constant.UrlConst;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

    private final String USERNAME_PARAMETER = "email";

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http
            .authorizeHttpRequests(
                authorize -> authorize.requestMatchers(UrlConst.NO_AUTHENTICATION).permitAll()
                    .anyRequest().authenticated())
            .formLogin(
				login -> login.loginPage(UrlConst.LOGIN)
						.usernameParameter(USERNAME_PARAMETER)
						.defaultSuccessUrl(UrlConst.MAIN, true));
                        

		return http.build();


    }
    
}
 