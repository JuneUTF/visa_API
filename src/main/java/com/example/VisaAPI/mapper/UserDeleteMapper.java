package com.example.VisaAPI.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.VisaAPI.model.UserDeleteModel;
@Mapper
public interface UserDeleteMapper {
	int DeleteByUsernameRole(UserDeleteModel userDeleteModel);
	int DeleteByUsernameUser(UserDeleteModel userDeleteModel);
}
