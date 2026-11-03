package com.smartfarm.farmerweb.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartfarm.farmerweb.Entity.Roles;


public interface roleRepo extends JpaRepository<Roles,Long>{
	


}
