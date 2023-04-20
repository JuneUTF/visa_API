package com.example.VisaAPI.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.VisaAPI.mapper.AdminMapper;
import com.example.VisaAPI.model.AdminModel;
import com.example.VisaAPI.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper mapper;


     
     @Override
     public  List<AdminModel> selectAll(AdminModel adminModel){
    	 return mapper.selectAll(adminModel);
     }
     @Override
     public  List<AdminModel> selectuser(AdminModel adminModel){
    	 return mapper.selectuser(adminModel);
     }
}