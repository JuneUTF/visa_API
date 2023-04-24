package com.example.VisaAPI.controller;



import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.VisaAPI.model.UpdateUserModel;
import com.example.VisaAPI.service.UpdateUserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UpdateUserController {
	@Resource
	UpdateUserService updateUserService;
//	@GetMapping("update")
//	public String showupdate() {
//		return "redirect:/home";
//	}
	@GetMapping("update/{username}")
	public ResponseEntity<?> Update(@PathVariable("username") String username,@RequestBody UpdateUserModel updateUserModel) {
	List<UpdateUserModel> user =updateUserService.selectuserbyId(updateUserModel);
	return ResponseEntity.ok(user);
	}
	@PostMapping("update/{username}")
	public ResponseEntity<?> Updated(@PathVariable("username") String username,@RequestBody UpdateUserModel updateUserModel) {
	log.info("{}",updateUserModel);
	//birthday DATE型を変更
	String inputbirth = updateUserModel.getBirthday();
	try {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		java.util.Date date = sdf.parse(inputbirth);
		Date sqlDate = new Date(date.getTime());
		log.info("{}",updateUserModel);
		//変更したbirthdayをモデルに設定
		updateUserModel.setDateofbirth(sqlDate);

	}catch (Exception e) {
		//変更できない場合updateできないで、エラー表示します
		return ResponseEntity.status(400).body("birthday誤入力");
	}

	//visa_date DATE型を変更
		String inputkigen = updateUserModel.getVisa_date();
		try {
			SimpleDateFormat sdfkigen = new SimpleDateFormat("yyyy-mm-dd");
			java.util.Date datekigen = sdfkigen.parse(inputkigen);
			Date sqlDatekigen = new Date(datekigen.getTime());
			log.info("{}",updateUserModel);
			//変更したbirthdayをモデルに設定
			updateUserModel.setVisakigen(sqlDatekigen);

		}catch (Exception e) {
			//変更できない場合updateできないで、エラー表示します
			return ResponseEntity.status(400).body("birthday誤入力");

		}
	List<UpdateUserModel> user =updateUserService.selectuserbyId(updateUserModel);
	int count = updateUserService.updateuser(updateUserModel);
	if (count == 1) {
		updateUserModel.setNote("updateできました");
		log.info("{}",updateUserModel);

		return ResponseEntity.ok(updateUserModel);
	}else {
		return ResponseEntity.status(400).body("update できない");
	}

	}

}
