package com.example.VisaAPI.model.Reponse;

import java.util.List;

import com.example.VisaAPI.model.LoginModel;
import com.example.VisaAPI.model.RegisterModel;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
public class ReponseModel {
	private int code;
	private String status;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String information;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private RegisterModel data;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private LoginModel loginData;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<String> errorlist;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String username;
}
