package com.smartfarm.farmerweb.Service;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;


@Service
public class jwtService {
	
	@Autowired
	private JwtEncoder jwtEncoder;
	
	@Value("${jwt.issuer}")
	private String issuer;
	
	@Value("${jwt.expiry}")
	private Long expiry;
	
	
	public String generatedToken(Authentication authentication)
	{
		Instant now=Instant.now();
		List<String> authorities=
				authentication.getAuthorities()
					.stream()
					.map(GrantedAuthority::getAuthority)
					.toList();
		
		JwtClaimsSet claims=JwtClaimsSet.builder()
				.issuer(issuer)
				.issuedAt(now)
				.expiresAt(
						now.plusSeconds(expiry)
				)
				.subject(
						authentication.getName()
				)
				.claim("authorities", authorities
				)
				.build();
		JwsHeader jwsHeader=JwsHeader.with(MacAlgorithm.HS256).build();
		
		Jwt jwt=jwtEncoder.encode(
				JwtEncoderParameters.from(jwsHeader,claims)
				);
				
		return jwt.getTokenValue();
	}

}
