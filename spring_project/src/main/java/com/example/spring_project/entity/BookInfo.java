package com.example.spring_project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "book_info")
@Data
public class BookInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private int book_id;

	@Column(name = "book_name")
	private String bookName;

	@Column(name = "contents")
	private String contents;

	@Column(name = "registered_at")
	private String registeredAt;

	@Column(name = "updated_time")
	private String updatedTime;

	public BookInfo(int book_id, String bookName, String contents, String registeredAt, String updatedTime) {
		this.book_id = book_id;
		this.bookName = bookName;
		this.contents = contents;
		this.registeredAt = registeredAt;
		this.updatedTime = updatedTime;
	}
    
}
