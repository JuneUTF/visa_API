package com.example.VisaAPI.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.VisaAPI.model.UpdateModel;
import com.example.VisaAPI.model.Reponse.ReponseModel;
import com.example.VisaAPI.service.UpdateService;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@Slf4j
public class UpdateController {

	@Resource
	private UpdateService updateService;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@PostMapping("/passchange")
	public ResponseEntity<?> changePassword(@RequestBody UpdateModel updateModel, ReponseModel reponseModel) {
		BCryptPasswordEncoder brcypt = new BCryptPasswordEncoder();
		UpdateModel user = updateService.selectuser(updateModel);
		log.info("{}",updateModel);
		if (!user.equals(null)) {
			if (!brcypt.matches(updateModel.getPassword(), user.getPassword())) {
				reponseModel.setCode(400);
				reponseModel.setStatus("DEFAIL");
				reponseModel.setInformation("パスワードが正しくありません");
				return ResponseEntity.status(400).body(reponseModel);
			}else if (updateModel.getNewpassword().equals(updateModel.getConfirmpassword())) {
				//encodePass 作成
				updateModel.setEncodePass(passwordEncoder.encode(updateModel.getNewpassword()));
				int rowsUpdated = updateService.updateuser(updateModel);
				if (rowsUpdated == 1) {
					reponseModel.setCode(200);
					reponseModel.setStatus("SUCCESS");
					reponseModel.setInformation("パスワードが変更できました");
					reponseModel.setDataPasschange(updateModel);
					return ResponseEntity.ok(reponseModel);
				} else {
					reponseModel.setCode(400);
					reponseModel.setStatus("DEFAIL");
					reponseModel.setInformation("パスワードが変更できませんでした");
					return ResponseEntity.status(400).body(reponseModel);
				}
			} else {
				reponseModel.setCode(400);
				reponseModel.setStatus("DEFAIL");
				reponseModel.setInformation("新しいパスワードが一致しません");
				return ResponseEntity.status(400).body(reponseModel);
			}

		} else {
			reponseModel.setCode(400);
			reponseModel.setStatus("DEFAIL");
			reponseModel.setInformation("ユーザーIDが存在しません");
			return ResponseEntity.status(400).body(reponseModel);
		}

	}
}
