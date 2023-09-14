package com.example.spring_project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "user_info")
@Data
@AllArgsConstructor
public class UserInfo {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "created_at")
	private String createdAt;

	@Column(name = "updated_at")
	private String updatedAT;


	public UserInfo() {
	}

    // public UserInfo(String userName, String email, String password, String createdAt,
	// 		String updatedAT) {
	// 	this.userName = userName;
	// 	this.email = email;
	// 	this.password = password;
	// 	this.createdAt = createdAt;
	// 	this.updatedAT = updatedAT;
	// }

}
