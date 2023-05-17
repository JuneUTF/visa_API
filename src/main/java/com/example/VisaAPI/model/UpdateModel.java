package com.example.VisaAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class UpdateModel {
	    private String username;
	    private String password;
	    private String newpassword;
	    private String confirmpassword;
	    @JsonIgnore
		private String encodePass;
}
