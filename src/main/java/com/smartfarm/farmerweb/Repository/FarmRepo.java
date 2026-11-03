package com.smartfarm.farmerweb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartfarm.farmerweb.Entity.Farm;

public interface FarmRepo extends JpaRepository<Farm,Long>{

}
