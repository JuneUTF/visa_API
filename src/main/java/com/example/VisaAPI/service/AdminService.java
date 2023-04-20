package com.example.VisaAPI.service;

import java.util.List;

import com.example.VisaAPI.model.AdminModel;


	public interface AdminService {
		

		public List<AdminModel> selectAll(AdminModel adminModel);
		public List<AdminModel> selectuser(AdminModel adminModel);
	
	}
		
