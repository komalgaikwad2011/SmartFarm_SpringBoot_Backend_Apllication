package com.smartfarm.farmerweb.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "farms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    // A farm is owned by a User (owner_id FK -> users.id)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private User owner;

    
    
    @Column(name = "farm_name")
    private String farmName;

    @Column(name = "address")
    private String address;

    @Column(name = "total_area_acres", precision = 10, scale = 2)
    private BigDecimal totalAreaAcres;


    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Instant createdAt;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public User getOwner() {
		return owner;
	}


	public void setOwner(User owner) {
		this.owner = owner;
	}


	public String getFarmName() {
		return farmName;
	}


	public void setFarmName(String farmName) {
		this.farmName = farmName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public BigDecimal getTotalAreaAcres() {
		return totalAreaAcres;
	}


	public void setTotalAreaAcres(BigDecimal totalAreaAcres) {
		this.totalAreaAcres = totalAreaAcres;
	}


	public Instant getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}


	public Farm(Long id, User owner, String farmName, String address, BigDecimal totalAreaAcres, Instant createdAt) {
		super();
		this.id = id;
		this.owner = owner;
		this.farmName = farmName;
		this.address = address;
		this.totalAreaAcres = totalAreaAcres;
		this.createdAt = createdAt;
	}


	public Farm() {
		super();
	}
    
    
    
}