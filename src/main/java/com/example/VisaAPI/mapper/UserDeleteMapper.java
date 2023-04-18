package com.example.VisaAPI.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.VisaAPI.model.UserDeleteModel;
@Mapper
public interface UserDeleteMapper {
	int DeleteByUsernameRole(UserDeleteModel userDeleteModel);
	int DeleteByUsernameUser(UserDeleteModel userDeleteModel);
	List<UserDeleteModel> CheckDeleteByUsername(UserDeleteModel userDeleteModel);
	List<UserDeleteModel> CheckDeleteByUsernameInformation(UserDeleteModel userDeleteModel);
}
