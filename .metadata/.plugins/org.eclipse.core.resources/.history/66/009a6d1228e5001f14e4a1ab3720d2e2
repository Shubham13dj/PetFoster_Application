package com.petfoster.utils;
//
import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTUtils {
	
	private final Key SECRETKEY = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);
//	
	public String generateToken(String username)
	{
		return Jwts.builder()
				.setSubject(username)
				.setIssuedAt(new Date())
				.setExpiration( new Date(System.currentTimeMillis() + 1000 * 60 * 60))
//				.claim("sub", username)
//				.claim("iat", new Date())
//				.claim("exp", new Date(System.currentTimeMillis() + 1000 * 60 * 60))
				.signWith(SECRETKEY)
				.compact();
	}
//	
	private Claims extractClaims(String token)
	{
		return  Jwts.parserBuilder()
                .setSigningKey(SECRETKEY)  
                .build()
                .parseClaimsJws(token)  
                .getBody();
	}
	public boolean validateToken(String token, String username)
	{
		return (username.equals(extractUsername(token))) && !isTokenExpired(token);
		
	}
	
	public String extractUsername(String token) {
		return extractClaims(token).getSubject();
	}
	
    public boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());  // Check if the expiration date is before current time
    }
//	
//
}
