package com.example.VisaAPI.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.VisaAPI.model.ResetPassModel;
import com.example.VisaAPI.model.Reponse.ReponseModel;
import com.example.VisaAPI.service.ResetPassService;

import lombok.extern.slf4j.Slf4j;


@RestController
@CrossOrigin
@Slf4j
public class RestPassController {
	@Resource
	ResetPassService resetPassService;

	@Autowired
	BCryptPasswordEncoder passwordEncoder; 
	
	@PostMapping("forgetPassword")
	public ResponseEntity<?> selectuser(@RequestBody ResetPassModel resetPassModel, ReponseModel reponseModel){
		log.info("{}", resetPassModel);
		if(resetPassModel.getNewpassword().equals(resetPassModel.getConfirmnewpass())) {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        java.util.Date utilDate = null;
	        try {
	            utilDate = sdf.parse(resetPassModel.getBirthday());
	        } catch (ParseException pass) {
	            pass.printStackTrace();
	            reponseModel.setCode(400);
				reponseModel.setStatus("DEFAIL");
				reponseModel.setInformation("birthdayが正しくありません");
	            return ResponseEntity.status(400).body(reponseModel);
	        }
	        if (utilDate != null) {
	            Date sqlDate = new Date(utilDate.getTime());
	            resetPassModel.setBirthdayDate(sqlDate);
	        }
	        List<ResetPassModel>  checkuser = resetPassService.selectuser(resetPassModel);
	        System.out.println(checkuser);
			if(checkuser.size()>0) {
				//encodePass 作成
				resetPassModel.setEncodePass(passwordEncoder.encode(resetPassModel.getNewpassword()));;
				int checkchange  = resetPassService.resetpass(resetPassModel);
				System.out.println(checkchange);
				if(checkchange==1) {
					reponseModel.setCode(200);
					reponseModel.setStatus("SUCCESS");
					reponseModel.setDataForgetPassword(resetPassModel);
					return ResponseEntity.ok(reponseModel);
				}else {
					return ResponseEntity.status(400).body("");
				}
			}
			reponseModel.setCode(400);
			reponseModel.setStatus("DEFAIL");
			reponseModel.setInformation("UserIDかbirthdayかPasswordが誤入力しました");
            return ResponseEntity.status(400).body(reponseModel);
		}else {
			reponseModel.setCode(400);
			reponseModel.setStatus("DEFAIL");
			reponseModel.setInformation("新しいパスワードと再入力パスワードが違います");
            return ResponseEntity.status(400).body(reponseModel);
		}

	}
}





