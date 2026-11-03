package com.smartfarm.farmerweb.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartfarm.farmerweb.Entity.parcels;
import com.smartfarm.farmerweb.Service.parcelsService;
import com.smartfarm.farmerweb.dto.parcelsRequestDto;
import com.smartfarm.farmerweb.dto.parcelsResponseDto;

@RestController
@RequestMapping("/api/parcels")
public class parcelsController {
	
	
	private parcelsService ParcelsService;
	
	public parcelsController(parcelsService ParcelsService)
	{
		this.ParcelsService=ParcelsService;
	}
	@PostMapping("/add")
	public ResponseEntity<parcelsResponseDto> createParcels(@RequestBody parcelsRequestDto parcelsRequest)
	{
		parcelsResponseDto parcelsResponse=ParcelsService.CreateParsel(parcelsRequest);
		return ResponseEntity.ok(parcelsResponse);
	}

}
