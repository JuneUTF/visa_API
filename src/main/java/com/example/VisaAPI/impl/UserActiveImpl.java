package com.example.VisaAPI.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.VisaAPI.mapper.UserActiveMapper;
import com.example.VisaAPI.model.UserActiveModel;
import com.example.VisaAPI.model.UserModel;
import com.example.VisaAPI.service.UserActiveService;

@Service
public class UserActiveImpl implements UserActiveService{
	@Autowired 
	UserActiveMapper mapper;
	@Override
	public int ActiveByUsernameRole(UserActiveModel userDeleteModel) {
		return mapper.ActiveByUsernameRole(userDeleteModel);
	}

	@Override
	public int ActiveByUsernameUser(UserActiveModel userDeleteModel) {
		return mapper.ActiveByUsernameUser(userDeleteModel);
	}

	@Override
	public List<UserActiveModel> CheckRoleLoginUser(UserActiveModel userDeleteModel) {
		return mapper.CheckRoleLoginUser(userDeleteModel);
	}

	@Override
	public List<UserActiveModel> CheckDeleteByUsername(UserActiveModel userDeleteModel) {
		return mapper.CheckDeleteByUsername(userDeleteModel);
	}

	@Override
	public List<UserModel> SelectDeleteByUsername(UserModel userModel) {
		return mapper.SelectDeleteByUsername(userModel);
	}



}
