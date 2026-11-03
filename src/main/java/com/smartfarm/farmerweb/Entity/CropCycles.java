package com.smartfarm.farmerweb.Entity;


import java.time.Instant;
import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CropCycles {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String cropname;
	private String varity;
	private LocalDate sowdate;
	private LocalDate harvestdate;
	private String status;
	
	@ManyToOne
	@JoinColumn(name="parcels_id")
	private parcels parcel;
	
	
	@CreationTimestamp
    @Column(name = "created_at", updatable = false)
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


	public parcels getParcel() {
		return parcel;
	}


	public void setParcel(parcels parcel) {
		this.parcel = parcel;
	}


	public Instant getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}


	public CropCycles(Long id, String cropname, String varity, LocalDate sowdate, LocalDate harvestdate, String status,
			parcels parcel, Instant createdAt) {
		super();
		this.id = id;
		this.cropname = cropname;
		this.varity = varity;
		this.sowdate = sowdate;
		this.harvestdate = harvestdate;
		this.status = status;
		this.parcel = parcel;
		this.createdAt = createdAt;
	}


	public CropCycles() {
		super();
	}
	
	


	
	

}
