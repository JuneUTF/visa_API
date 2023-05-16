package com.example.VisaAPI.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.VisaAPI.model.UserActiveModel;
import com.example.VisaAPI.model.UserModel;
@Mapper
public interface UserActiveMapper {

	int ActiveByUsernameRole(UserActiveModel userDeleteModel);
	int ActiveByUsernameUser(UserActiveModel userDeleteModel);
	List<UserActiveModel> CheckRoleLoginUser(UserActiveModel userDeleteModel);
	List<UserActiveModel> CheckDeleteByUsername(UserActiveModel userDeleteModel);
	List<UserModel> SelectDeleteByUsername(UserModel userModel);
}
