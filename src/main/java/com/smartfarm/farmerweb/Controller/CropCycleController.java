package com.smartfarm.farmerweb.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartfarm.farmerweb.Service.CropCycleService;
import com.smartfarm.farmerweb.dto.CropCycleRequestDto;
import com.smartfarm.farmerweb.dto.CropCycleResponseDto;

@RestController
@RequestMapping("/api/cropcycle")
public class CropCycleController {
	
	private CropCycleService CropCycleservice;
	
	public CropCycleController(CropCycleService CropCycleservice)
	{
		this.CropCycleservice=CropCycleservice;
	}
	@PostMapping("/add")
	public ResponseEntity<CropCycleResponseDto> createCropCycle(@RequestBody CropCycleRequestDto CropCycleRquestdto)
	{
		CropCycleResponseDto CropCycleResponsedto=CropCycleservice.createCropcycle(CropCycleRquestdto);
		return ResponseEntity.ok(CropCycleResponsedto);
	}

}
