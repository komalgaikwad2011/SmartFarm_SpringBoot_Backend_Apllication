package com.smartfarm.farmerweb.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.smartfarm.farmerweb.Entity.Farm;
import com.smartfarm.farmerweb.Entity.Roles;
import com.smartfarm.farmerweb.Entity.User;
import com.smartfarm.farmerweb.Exception.DublicateEmailException;
import com.smartfarm.farmerweb.Repository.FarmRepo;
import com.smartfarm.farmerweb.Repository.roleRepo;
import com.smartfarm.farmerweb.Repository.userRepo;
import com.smartfarm.farmerweb.dto.userRegisterRequestDto;
import com.smartfarm.farmerweb.dto.userRegisterResponseDto;

@Service
public class AuthService {
	
	private userRepo userrepo;
	private roleRepo relorepo;
	private FarmRepo farmRepo;
	private PasswordEncoder passwordEncoder;

	public AuthService(userRepo userrepo, roleRepo relorepo, PasswordEncoder passwordEncoder,FarmRepo farmRepo) 
	{

		this.userrepo = userrepo;
		this.relorepo = relorepo;
		this.passwordEncoder = passwordEncoder;
		this.farmRepo=farmRepo;
	}
	
	public userRegisterResponseDto register(userRegisterRequestDto UserRegisterRequestdto)
	{
		if(userrepo.existsByEmail(UserRegisterRequestdto.getEmail()))
		{
			throw new DublicateEmailException("Student alread exits:"+UserRegisterRequestdto.getEmail());
		}
		User user=new User();
		user.setUsername(UserRegisterRequestdto.getUsername());
		
		
		String encodedPassword=passwordEncoder.encode(UserRegisterRequestdto.getPassword());
		
		user.setPassword(encodedPassword);
		user.setEmail(UserRegisterRequestdto.getEmail());
		user.setPhone(UserRegisterRequestdto.getPhone());
		user.setLang(UserRegisterRequestdto.getLang());
		user.setCreated_at(UserRegisterRequestdto.getCreated_at());
		user.setRole(UserRegisterRequestdto.getRole());
		
		 user = userrepo.save(user);
		// 2. Create the Farm and assign the user as owner
        Farm farm = new Farm();
        farm.setFarmName(UserRegisterRequestdto.getFarmName()); // or from DTO
        farm.setAddress(UserRegisterRequestdto.getAddrs());
        farm.setTotalAreaAcres(UserRegisterRequestdto.getTotalAreaAcres());
        farm.setOwner(user);                       // fills owner_id in 'farms' table
        farm = farmRepo.save(farm);
        
        // 3. Link the saved Farm back to the User
        user.setFarm(farm);                         // fills farm_id in 'users' table
        user = userrepo.save(user);
		
		Roles roles=new Roles();
		roles.setUser(user);
		roles.setModule(UserRegisterRequestdto.getRole());
		roles.setCanRead(true);
		roles.setCanWrite(true);
		
		
		
		userrepo.save(user);
		relorepo.save(roles);
		
		userRegisterResponseDto responseDto=new userRegisterResponseDto();
		
		responseDto.setUsername(user.getUsername());
		responseDto.setMessage("User saved Successfully");
		
		return responseDto;
		
	}
	
	
	

}
