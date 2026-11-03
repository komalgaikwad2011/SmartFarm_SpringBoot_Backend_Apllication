package com.smartfarm.farmerweb.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartfarm.farmerweb.Service.jwtService;
import com.smartfarm.farmerweb.dto.loginRequestDto;
import com.smartfarm.farmerweb.dto.loginResponseDto;

@RestController
@RequestMapping("/auth")
public class authController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private jwtService JwtService;
	
	@PostMapping("/login")
	public loginResponseDto login(@RequestBody loginRequestDto loginRequestDto)
	{
		Authentication authenticationRequest=
				UsernamePasswordAuthenticationToken.unauthenticated(
						loginRequestDto.getUsername(),
						loginRequestDto.getPassword()
						);
		
		Authentication authentication=
				authenticationManager.authenticate(authenticationRequest);
		
		
		String token=JwtService.generatedToken(authentication);
		return new loginResponseDto(token);
	}
	

}
