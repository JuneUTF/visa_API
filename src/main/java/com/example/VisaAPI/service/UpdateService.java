package com.example.VisaAPI.service;

import com.example.VisaAPI.model.UpdateModel;

public interface UpdateService {

	public UpdateModel selectuser(UpdateModel updateModel);
    public int updateuser(UpdateModel updateModel);

}

