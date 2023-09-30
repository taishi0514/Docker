package com.example.spring_project.form;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class BookForm {

    @Length(min = 1, max = 40)
	private String bookName;

	@Length(min = 1, max = 90)
	private String contents;    
}
