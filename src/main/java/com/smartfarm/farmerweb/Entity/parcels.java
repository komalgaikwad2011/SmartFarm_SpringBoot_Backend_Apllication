package com.smartfarm.farmerweb.Entity;

import java.time.Instant;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class parcels {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "farm_id", nullable = false)
    private Farm farm;
	
	private String ParcelName;
	private int area_value;
	private String area_unit;
	private String owner_name;
	
	@CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Instant createdAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	

	public Farm getFarm() {
		return farm;
	}

	public void setFarm(Farm farm) {
		this.farm = farm;
	}

	public String getParcelName() {
		return ParcelName;
	}

	public void setParcelName(String ParcelName) {
		this.ParcelName = ParcelName;
	}

	public int getArea_value() {
		return area_value;
	}

	public void setArea_value(int area_value) {
		this.area_value = area_value;
	}

	public String getArea_unit() {
		return area_unit;
	}

	public void setArea_unit(String area_unit) {
		this.area_unit = area_unit;
	}

	public String getOwner_name() {
		return owner_name;
	}

	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	

	
	public parcels() {
		
	}
	
	
	

}
