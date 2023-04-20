package com.example.VisaAPI.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.VisaAPI.mapper.PassMapper;
import com.example.VisaAPI.model.PassModel;
import com.example.VisaAPI.service.PassService;



	@Service
	public class PassServiceImpl implements PassService {
	    @Autowired
	    private PassMapper passMapper;

	    @Override
	    public List<PassModel> selectuser(PassModel passModel) {
	        return passMapper.selectuser(passModel);
	    }

	    @Override
	    public int updateuser(PassModel passModel) {
	        return passMapper.updateuser(passModel);
	    }
	}