package com.example.VisaAPI.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.VisaAPI.model.MypageModel;
import com.example.VisaAPI.service.MypageService;

@RestController
public class MypageController {

	@Resource
	MypageService mypageService;
	@GetMapping("/mypage")
	public ResponseEntity<List<MypageModel>> SelectByUsername (@RequestBody MypageModel mypageModel){
		List<MypageModel> user = mypageService.SelectByUsername(mypageModel);
		return ResponseEntity.ok(user);
	}
}
