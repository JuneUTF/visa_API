package com.example.VisaAPI.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.VisaAPI.model.LoginModel;

@Mapper
public interface LoginMapper {
	 LoginModel  findByUsername(LoginModel loginModel);
}
