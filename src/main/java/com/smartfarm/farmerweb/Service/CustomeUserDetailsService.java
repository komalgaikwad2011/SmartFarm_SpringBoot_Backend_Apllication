package com.smartfarm.farmerweb.Service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.smartfarm.farmerweb.Entity.CustomUserDetails;
import com.smartfarm.farmerweb.Entity.User;
import com.smartfarm.farmerweb.Repository.userRepo;


@Service
public class CustomeUserDetailsService implements UserDetailsService {

	private userRepo userrepo;
	
	public CustomeUserDetailsService(userRepo userrepo)
	{
		this.userrepo=userrepo;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User user=userrepo.findByUsername(username)
				.orElseThrow(()-> new UsernameNotFoundException("User not found"));
		return new CustomUserDetails(user);
	}
	
	

}
