package com.smartfarm.farmerweb.Service;

import org.springframework.stereotype.Service;

import com.smartfarm.farmerweb.Entity.Roles;
import com.smartfarm.farmerweb.Repository.roleRepo;

@Service
public class roleService {

	
	private roleRepo rolerepo;
	
	public roleService(roleRepo rolerepo)
	{
		this.rolerepo=rolerepo;
	}
	
	
	public void addRole(Roles role)
	{
		rolerepo.save(role);
	}
}