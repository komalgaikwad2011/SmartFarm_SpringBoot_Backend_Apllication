package com.smartfarm.farmerweb.dto;

public class loginResponseDto {

	
	private String accessToken;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public loginResponseDto(String accessToken) {
		super();
		this.accessToken = accessToken;
	}
	
	
	
}
