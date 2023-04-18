package com.example.VisaAPI.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.VisaAPI.mapper.UserDeleteMapper;
import com.example.VisaAPI.model.UserDeleteModel;
import com.example.VisaAPI.service.UserDeleteService;

@Service
public class UserDeleteImpl implements UserDeleteService{
		@Resource
		UserDeleteMapper mapper;
		@Override
		public int  DeleteByUsernameRole(UserDeleteModel userDeleteModel){
			return mapper.DeleteByUsernameRole(userDeleteModel);
		}
		public int  DeleteByUsernameUser(UserDeleteModel userDeleteModel){
			return mapper.DeleteByUsernameUser(userDeleteModel);
		}
}
