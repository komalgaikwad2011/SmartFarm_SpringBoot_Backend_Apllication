package com.smartfarm.farmerweb.Service;

import org.springframework.stereotype.Service;

import com.smartfarm.farmerweb.Entity.CropCycles;
import com.smartfarm.farmerweb.Entity.parcels;
import com.smartfarm.farmerweb.Exception.FarmerNotFoundException;
import com.smartfarm.farmerweb.Repository.CropCycleRepo;
import com.smartfarm.farmerweb.Repository.parcelsRepository;
import com.smartfarm.farmerweb.dto.CropCycleRequestDto;
import com.smartfarm.farmerweb.dto.CropCycleResponseDto;

@Service
public class CropCycleService {
	
	private final CropCycleRepo CropCyclerepo;
	private final parcelsRepository parselRepository;
	
	public CropCycleService(CropCycleRepo CropCyclerepo,parcelsRepository parselRepository)
	{
		this.CropCyclerepo=CropCyclerepo;
		this.parselRepository=parselRepository;
	}
	public CropCycleResponseDto createCropcycle(CropCycleRequestDto CropCycleRequestdto)
	{
		CropCycles Cropcycle=new CropCycles();
		
		parcels parcel=parselRepository.findById(CropCycleRequestdto.getParcel()).orElseThrow(()->
		new FarmerNotFoundException("not found Farmer"));
		Cropcycle.setParcel(parcel);
		
		Cropcycle.setCropname(CropCycleRequestdto.getCropname());
		Cropcycle.setVarity(CropCycleRequestdto.getVarity());
		Cropcycle.setSowdate(CropCycleRequestdto.getSowdate());
		Cropcycle.setHarvestdate(CropCycleRequestdto.getHarvestdate());
		Cropcycle.setStatus(CropCycleRequestdto.getStatus());
		
		CropCyclerepo.save(Cropcycle);
		
		
		CropCycleResponseDto CropCycleResponsedto=new CropCycleResponseDto();
		CropCycleResponsedto.setMessage("record saved");
		return CropCycleResponsedto;
		
	}

}
