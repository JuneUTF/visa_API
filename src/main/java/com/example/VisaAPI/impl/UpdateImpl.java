package com.example.VisaAPI.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.VisaAPI.mapper.UpdateMapper;
import com.example.VisaAPI.model.UpdateModel;
import com.example.VisaAPI.service.UpdateService;

@Service
public class UpdateImpl implements UpdateService {

    @Resource
    private UpdateMapper mapper;


    @Override
    public UpdateModel selectuser(UpdateModel updateModel){
        return mapper.selectuser(updateModel);
    }

    @Override
    public int updateuser(UpdateModel updateModel){
        return mapper.updateuser(updateModel);
    }
}
