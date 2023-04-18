package com.example.VisaAPI.model;

import lombok.Data;

@Data
public class UserDeleteModel {
	private String loginUsername;
	private String username;
	private String statusRole;
	private String statusInformation;
	private String status;
	private String note;
}
