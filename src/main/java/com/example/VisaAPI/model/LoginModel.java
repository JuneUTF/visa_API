package com.example.VisaAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class LoginModel {
	private String username;
	
	private String password;
	@JsonIgnore
	private String role;
	@JsonIgnore
	private String status;
}
