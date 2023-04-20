package com.example.VisaAPI.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.VisaAPI.model.PassModel;

@Repository
@Mapper
public interface PassMapper {
    List<PassModel> selectuser(PassModel passModel);
    int updateuser(PassModel passModel);
}