package com.example.VisaAPI.controller;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.VisaAPI.model.LoginModel;
import com.example.VisaAPI.model.Reponse.ReponseModel;
import com.example.VisaAPI.service.LoginService;

import lombok.extern.slf4j.Slf4j;
@RestController
@CrossOrigin
@Slf4j
public class LoginController {
	@Resource
	LoginService loginService;
	 @PostMapping("/login")
	   public  ResponseEntity<?> findByUsername(@RequestBody LoginModel loginModel,ReponseModel reponseModel) {
		 //ユーザー情報をチャックします。
		 BCryptPasswordEncoder brcypt = new BCryptPasswordEncoder();
		 LoginModel user = loginService.findByUsername(loginModel);
		 if (!brcypt.matches(loginModel.getPassword(), user.getPassword())) {
			 	reponseModel.setCode(400);
		 		reponseModel.setStatus("Fail");
		 		reponseModel.setInformation("パスワードが正しくありません");
		 		reponseModel.setLoginData(loginModel);
			 		return ResponseEntity.ok(reponseModel);
		 }else if(!user.equals(null)) {
//		 		ユーザー名とパスワードが正しい
		 		reponseModel.setCode(200);
		 		reponseModel.setStatus("SUCCESS");
		 		reponseModel.setInformation("ログインができました");
		 		reponseModel.setUsername(loginModel.getUsername());
		 		log.info("{}",reponseModel);
		 		return ResponseEntity.ok(reponseModel);
		 	}else {
//		 		ユーザー名とパスワードが正しくない
//		 		status 設定
		 		reponseModel.setCode(400);
		 		reponseModel.setStatus("Fail");
		 		reponseModel.setInformation("ユーザー名が正しくない");
				return ResponseEntity.status(400).body(reponseModel);
		 	}
	    }
}

