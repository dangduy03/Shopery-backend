package com.andy.shopery.vn.dto;


import com.andy.shopery.vn.enums.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class UserDTO {
	@Column(length = 64)
	private String fullName;
	
	@Column(length = 64)
	private String username;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(length = 16)
	private String phoneNumber;
	
	@Column(length = 128)
	private String email;
	
	@Column(length = 64)
    private String password;
    
	public UserDTO() {
		super();
	}

	public UserDTO(String fullName, String username, Gender gender, String phoneNumber, String email, String password) {
		super();
		this.fullName = fullName;
		this.username = username;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
