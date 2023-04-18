package com.example.VisaAPI.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.VisaAPI.model.LoginModel;
import com.example.VisaAPI.service.LoginService;
@RestController
public class LoginController {
	@Resource
	LoginService loginService;

	 @PostMapping("/login")
	   public  ResponseEntity<List<LoginModel>> findByUsername(@RequestBody LoginModel loginModel) {
		 System.out.println(loginModel);
		 //ユーザー情報をチャックします。
		 List<LoginModel> user = loginService.findByUsername(loginModel);
		 	if(user.size()>0) {
//		 		ユーザー名とパスワードが正しい
		 		user.get(0).setPassword("ログインできました");
			 		return ResponseEntity.ok(user);
		 	}else {
//		 		ユーザー名とパスワードが正しくない
				return ResponseEntity.ok(user);
		 	}
	    }
}

