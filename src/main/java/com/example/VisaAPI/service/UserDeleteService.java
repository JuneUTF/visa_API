package com.example.VisaAPI.service;

import com.example.VisaAPI.model.UserDeleteModel;

public interface UserDeleteService {
	int DeleteByUsernameRole(UserDeleteModel userDeleteModel);
	int DeleteByUsernameUser(UserDeleteModel userDeleteModel);

}
