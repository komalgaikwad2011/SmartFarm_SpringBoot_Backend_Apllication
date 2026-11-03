package com.smartfarm.farmerweb.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartfarm.farmerweb.Service.AuthService;
import com.smartfarm.farmerweb.dto.userRegisterRequestDto;
import com.smartfarm.farmerweb.dto.userRegisterResponseDto;

@RestController
@RequestMapping("/api/user")
public class userController {
	
	private AuthService authService;
	
	public userController(AuthService authService)
	{
		this.authService=authService;
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<userRegisterResponseDto> register(
			@RequestBody userRegisterRequestDto registerRequestDto)
	{
		userRegisterResponseDto userRegisterResponsedto=authService.register(registerRequestDto);
		return ResponseEntity.ok(userRegisterResponsedto);
	}
	
	
	
}
