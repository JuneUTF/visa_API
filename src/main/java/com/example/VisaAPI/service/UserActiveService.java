package com.example.VisaAPI.service;

import java.util.List;

import com.example.VisaAPI.model.UserActiveModel;
import com.example.VisaAPI.model.UserModel;

public interface UserActiveService {
	
	int ActiveByUsernameRole(UserActiveModel userDeleteModel);
	int ActiveByUsernameUser(UserActiveModel userDeleteModel);
	List<UserActiveModel> CheckRoleLoginUser(UserActiveModel userDeleteModel);
	List<UserActiveModel> CheckDeleteByUsername(UserActiveModel userDeleteModel);
	List<UserModel> SelectDeleteByUsername(UserModel userModel);

}
