package com.example.VisaAPI.model;

import lombok.Data;

@Data
public class UserActiveModel {
	private String loginUsername;
	private String username;
	private String role;
	private String statusRole;
	private String statusInformation;
	private String note;
	private String status;
}
