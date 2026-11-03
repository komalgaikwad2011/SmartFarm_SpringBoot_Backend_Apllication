package com.smartfarm.farmerweb.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartfarm.farmerweb.Entity.parcels;

public interface parcelsRepository extends JpaRepository<parcels,Long>{

	
	List<parcels> findByFarmId(Long farmId);
	
}
