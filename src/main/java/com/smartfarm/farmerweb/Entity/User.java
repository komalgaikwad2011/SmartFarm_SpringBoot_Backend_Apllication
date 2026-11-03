package com.smartfarm.farmerweb.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false,unique=true)
	private String username;
	
	@Column(nullable=false)
	private String email;
	
	@Column(nullable=false)
	private Long phone;
	
	@Column(nullable=false)
	private String role;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false)
	private String lang;
	
	@Column(nullable=false)
	@CreationTimestamp
	private LocalDate created_at;
	
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Roles> roles=new ArrayList<>();
	
	@OneToMany(mappedBy="owner")
	private List<Farm> ownedFarms=new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "farm_id", nullable = true) 
	private Farm farm;
	
	
	
	public Farm getFarm() {
		return farm;
	}


	public void setFarm(Farm farm) {
		this.farm = farm;
	}


	public List<Farm> getOwnedFarms() {
		return ownedFarms;
	}


	public void setOwnedFarms(List<Farm> ownedFarms) {
		this.ownedFarms = ownedFarms;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public LocalDate getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDate created_at) 
	{
		this.created_at = created_at;
	}
	
	public List<Roles> getRoles() 
	{
		return roles;
	}
	public void setRoles(List<Roles> roles) 
	{
		this.roles = roles;
	}
	
	
	

}
