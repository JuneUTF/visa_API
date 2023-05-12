
package com.example.VisaAPI.model;

import lombok.Data;

@Data
public class ResLoginModel {
	private String code;
	private String status;
	private resData data;
  @Data
  public class resData{
    private String username;
	  private String role;
}
