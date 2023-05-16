package com.example.VisaAPI.service;

import com.example.VisaAPI.model.LoginModel;

public interface LoginService {
	LoginModel findByUsername(LoginModel loginModel);
}
