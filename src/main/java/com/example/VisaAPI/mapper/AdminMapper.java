package com.example.VisaAPI.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.VisaAPI.model.AdminModel;

@Repository
@Mapper
public interface AdminMapper {	



		List<AdminModel> selectAll(AdminModel adminModel);
		List<AdminModel> selectuser(AdminModel adminModel);
	
		
	}

 