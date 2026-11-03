package com.smartfarm.farmerweb.dto;

import java.time.Instant;
import java.time.LocalDate;


import com.smartfarm.farmerweb.Entity.parcels;


public class CropCycleRequestDto {
	
	private Long id;
	private String cropname;
	private String varity;
	private LocalDate sowdate;
	private LocalDate harvestdate;
	private String status;
	private Long parcel;
    private Instant createdAt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCropname() {
		return cropname;
	}
	public void setCropname(String cropname) {
		this.cropname = cropname;
	}
	public String getVarity() {
		return varity;
	}
	public void setVarity(String varity) {
		this.varity = varity;
	}
	public LocalDate getSowdate() {
		return sowdate;
	}
	public void setSowdate(LocalDate sowdate) {
		this.sowdate = sowdate;
	}
	public LocalDate getHarvestdate() {
		return harvestdate;
	}
	public void setHarvestdate(LocalDate harvestdate) {
		this.harvestdate = harvestdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getParcel() {
		return parcel;
	}
	public void setParcel(Long parcel) {
		this.parcel = parcel;
	}
	public Instant getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}
    


}
