package com.example.VisaAPI.service;

import java.util.List;

import com.example.VisaAPI.model.PassModel;


	public interface PassService {
	    public List<PassModel> selectuser(PassModel passModel);
	    public int updateuser(PassModel passModel);
		
	}


