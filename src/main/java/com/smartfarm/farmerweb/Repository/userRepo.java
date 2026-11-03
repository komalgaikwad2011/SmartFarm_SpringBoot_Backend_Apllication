package com.smartfarm.farmerweb.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartfarm.farmerweb.Entity.User;


public interface userRepo extends JpaRepository<User,Long>{
	
	Optional<User> findByUsername(String name);
	boolean existsByEmail(String email);

}
