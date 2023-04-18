package com.example.VisaAPI.controller;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.VisaAPI.model.UserDeleteModel;
import com.example.VisaAPI.service.UserDeleteService;

@RestController
public class UserDeleteController {
		@Resource
		UserDeleteService userDeleteService;
		@PostMapping("/delete")
		public ResponseEntity<UserDeleteModel> SelectByUsernameRole(@RequestBody UserDeleteModel userDeleteModel){

			int userRole = userDeleteService.DeleteByUsernameRole(userDeleteModel);
			if(userRole == 1) {
				userDeleteModel.setStatusRole("DELETED");
				userDeleteModel.setStatus("SUCCESS");
				int information = userDeleteService.DeleteByUsernameUser(userDeleteModel);
				if(information == 1) {
					userDeleteModel.setStatusInformation("DELETED");
				}else {
					userDeleteModel.setStatusInformation("在留カード情報がありません");
				}
			}else {
				userDeleteModel.setStatusRole("ERROR");
				userDeleteModel.setStatusInformation("ERROR");
				userDeleteModel.setStatus("DEFEATED");
			}
			return ResponseEntity.ok(userDeleteModel);
		}
}
