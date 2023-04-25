package com.example.VisaAPI.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.VisaAPI.model.MypageModel;
import com.example.VisaAPI.service.MypageService;

@RestController
public class MypageController {

	@Resource
	MypageService mypageService;
	@GetMapping("/mypage/{username}")
	public ResponseEntity<?> SelectByUsername (@RequestBody @PathVariable String username, MypageModel mypageModel){
		List<MypageModel> user = mypageService.SelectByUsername(username);
		return ResponseEntity.ok(user);
	}
}
