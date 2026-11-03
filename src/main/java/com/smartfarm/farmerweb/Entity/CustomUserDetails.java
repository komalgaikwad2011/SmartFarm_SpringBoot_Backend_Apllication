package com.smartfarm.farmerweb.Entity;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import io.micrometer.common.lang.Nullable;

public class CustomUserDetails implements UserDetails {
	
	private User user;
	
	public CustomUserDetails(User user)
	{
		this.user=user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() 
	{
		return user.getRoles()
				.stream()
				.map(role->
						new SimpleGrantedAuthority(
								role.getModule()
								)
						)
				.toList();
	}

	@Override
	public @Nullable String getPassword() 
	{
		return user.getPassword();
	}

	@Override
	public @Nullable String getUsername() 
	{
		return user.getUsername();
	}
	
	

}
