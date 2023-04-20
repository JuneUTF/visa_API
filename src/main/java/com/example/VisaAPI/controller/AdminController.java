package com.example.VisaAPI.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.VisaAPI.model.AdminModel;
import com.example.VisaAPI.service.AdminService;

@RestController
public class AdminController {

    @Resource
    private AdminService adminService;

    @GetMapping("/admin")
    public ResponseEntity<List<AdminModel>> admin( AdminModel adminModel) {
        List<AdminModel> userList = adminService.selectAll(adminModel);
        return ResponseEntity.ok(userList);
    }
    @PostMapping("/admin/{username}")
    public ResponseEntity<List<AdminModel>> adminonly( AdminModel adminModel) {
        List<AdminModel> userList = adminService.selectuser(adminModel);
        return ResponseEntity.ok(userList);
    }
}
