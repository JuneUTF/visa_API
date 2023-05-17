package com.example.VisaAPI.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.VisaAPI.model.UpdateModel;
@Repository
@Mapper
public interface UpdateMapper {	

	public UpdateModel selectuser(UpdateModel updateModel);
	int  updateuser(UpdateModel updateModel);
    
 }
