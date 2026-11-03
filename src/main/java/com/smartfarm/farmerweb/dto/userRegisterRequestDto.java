package com.smartfarm.farmerweb.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;

public class userRegisterRequestDto {

	
	private String username;
	private String password;
	private String email;
	private Long phone;
	private String role;	
	private String lang;
	private String FarmName;
	private String addrs;
	private BigDecimal totalAreaAcres;
	private LocalDate created_at;

	
	
	
	public String getAddrs() {
		return addrs;
	}
	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}
	public BigDecimal getTotalAreaAcres() {
		return totalAreaAcres;
	}
	public void setTotalAreaAcres(BigDecimal totalAreaAcres) {
		this.totalAreaAcres = totalAreaAcres;
	}
	public String getFarmName() {
		return FarmName;
	}
	public void setFarmName(String farmName) {
		FarmName = farmName;
	}
	public LocalDate getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDate created_at) {
		this.created_at = created_at;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
