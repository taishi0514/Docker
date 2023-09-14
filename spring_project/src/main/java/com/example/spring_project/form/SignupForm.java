package com.example.spring_project.form;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

/**
 * ユーザー登録画面 form
 * 
 * @author ys-fj
 *
 */
@Data
public class SignupForm {

	@Length(min = 1, max = 40)
	private String userName;

	@Length(min = 10, max = 30)
	private String email;

	@Length(min = 10, max = 30)
	private String password;	

}