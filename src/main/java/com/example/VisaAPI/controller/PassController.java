//package com.example.VisaAPI.controller;
//
//
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.VisaAPI.model.PassModel;
//import com.example.VisaAPI.service.PassService;
//
//@RestController
//@RequestMapping("/api/password")
//public class PassController {
//
//       @Resource
//       private PassService passService;
//
//       @PostMapping("/change")
//       public ResponseEntity<List<PassModel>> changePassword(@RequestBody PassModel passModel) {
//           boolean passwordChanged = passService.changePassword(passModel);
//           if (passwordChanged) {
//               List<PassModel> userList = passService.selectuser(passModel);
//               return ResponseEntity.ok(userList);
//           } else {
//               return ResponseEntity.badRequest().build();
//           }
//       }
//   }
//
//       