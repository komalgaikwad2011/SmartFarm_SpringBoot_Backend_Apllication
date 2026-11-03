package com.smartfarm.farmerweb.Service;


import org.springframework.stereotype.Service;

import com.smartfarm.farmerweb.Entity.Farm;
import com.smartfarm.farmerweb.Entity.parcels;
import com.smartfarm.farmerweb.Repository.FarmRepo;
import com.smartfarm.farmerweb.Repository.parcelsRepository;
import com.smartfarm.farmerweb.dto.parcelsRequestDto;
import com.smartfarm.farmerweb.dto.parcelsResponseDto;

@Service
public class parcelsService {
	
    private final parcelsRepository pacelRepo;
    private final FarmRepo farmRepo;

    public parcelsService(parcelsRepository pacelRepo, FarmRepo farmRepo) {
        this.pacelRepo = pacelRepo;
        this.farmRepo = farmRepo;
    }
	
    public parcelsResponseDto CreateParsel(parcelsRequestDto parcelsRequest) {
        parcels parcel = new parcels();

      
        Farm farm = farmRepo.findById(parcelsRequest.getFarmId()).orElse(null);
        parcel.setFarm(farm);
    
        parcel.setOwner_name(farm.getOwner().getUsername());
        
        
        parcel.setParcelName(parcelsRequest.getParcelName());
        parcel.setArea_value(parcelsRequest.getArea_value());
        parcel.setArea_unit(parcelsRequest.getArea_unit());
        
		
        pacelRepo.save(parcel);
		
        parcelsResponseDto parcelsResponsedto = new parcelsResponseDto();
        parcelsResponsedto.setMessage("parcels saved");
		
        return parcelsResponsedto;
    }
}