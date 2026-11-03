package com.smartfarm.farmerweb.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class parcelsRequestDto {

	private Long id;
    private Long farmId;
	@NotBlank(message="parcel name is requred") 
	@Size(min=2,max=30,message="name must be in 2 and 30 charecters")
    private String ParcelName;
	private int area_value;
	private String area_unit;
	private String owner_name;


	    // Getters and Setters
	   
	    
	    
		public Long getId() {
			return id;
		}
		public Long getFarmId() {
			return farmId;
		}
		public void setFarmId(Long farmId) {
			this.farmId = farmId;
		}
		public String getParcelName() {
			return ParcelName;
		}
		public void setParcelName(String ParcelName) {
			this.ParcelName = ParcelName;
		}
		public void setId(Long id) {
			this.id = id;
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

	   
}

