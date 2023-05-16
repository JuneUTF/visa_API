//package com.example.VisaAPI.controller;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.VisaAPI.model.UserActiveModel;
//import com.example.VisaAPI.model.UserModel;
//import com.example.VisaAPI.service.UserActiveService;
//
//@RestController
//@CrossOrigin
//public class UserActiveController {
//		@Resource
//		UserActiveService userActiveService;
//		
//		@GetMapping("/delete/{username}")
//		public ResponseEntity<?> SelectDeleteByUsername (@PathVariable String username,UserModel userModel){
//			List<UserModel> user = userActiveService.SelectDeleteByUsername(userModel);
//			return ResponseEntity.ok(user);
//		}
//		@PostMapping("/delete")
//		public ResponseEntity<?> SelectByUsernameRole(@RequestBody UserActiveModel userDeleteModel){
//			LocalDateTime currentDateTime = LocalDateTime.now();
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//			String formattedDateTime = currentDateTime.format(formatter);
//			List<UserActiveModel>  user = userActiveService.CheckDeleteByUsername(userDeleteModel);
//			List<UserActiveModel>  role = userActiveService.CheckRoleLoginUser(userDeleteModel);
//			userDeleteModel.setRole(role.get(0).getRole());
//			if(role.get(0).getRole().equals("ADMIN") || userDeleteModel.getUsername().equals(userDeleteModel.getLoginUsername())) {
//				if(user.size()!=0) {
//					userDeleteModel.setNote(formattedDateTime +"に"+ userDeleteModel.getLoginUsername()+"が削除しました");
//					int userRole = userActiveService.ActiveByUsernameRole(userDeleteModel);
//					if(userRole == 1) {
//							userDeleteModel.setStatusRole("DELETED");
//								userDeleteModel.setStatus("SUCCESS");
//								int information = userActiveService.ActiveByUsernameUser(userDeleteModel);
//									if(information == 1) {
//										userDeleteModel.setStatusInformation("DELETED");
//									}else {
//										userDeleteModel.setStatusInformation("在留カード情報がありません");
//									}
//						}else {
//							userDeleteModel.setNote(formattedDateTime +"に"+ userDeleteModel.getLoginUsername()+"が削除されませんでした");
//							userDeleteModel.setStatusRole("ERROR");
//							userDeleteModel.setStatusInformation("ERROR");
//							userDeleteModel.setStatus("DEFEATED");
//						}
//					}else {
//						userDeleteModel.setStatusRole("ERROR");
//						userDeleteModel.setStatusInformation("ERROR");
//						userDeleteModel.setStatus("DEFEATED");
//						userDeleteModel.setNote(formattedDateTime +"に"+ userDeleteModel.getUsername()+"が削除されたまたは存じません");
//						return ResponseEntity.ok(userDeleteModel);
//					}
//			}else {
//				userDeleteModel.setStatus("DEFEATED");
//				userDeleteModel.setNote(formattedDateTime +"に"+ "権限がないので、削除できませんでした");
//			}
//			return ResponseEntity.ok(userDeleteModel);
//		}
//}
