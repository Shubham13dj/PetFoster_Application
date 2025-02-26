package com.petfoster.utils;

import java.security.Key;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
/**
 * Utility class for generating and validating JSON Web Tokens (JWT).
 */
@Component
public class JWTUtils {
	/**
     * Secret key used for signing JWT tokens.
     */
	private final Key SECRETKEY = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);
	/**
     * Generates a JWT token for the specified username.
     * 
     * @param username the username for which the token is generated
     * @return the generated JWT token
     */
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
	/**
     * Extracts claims from the specified JWT token.
     * 
     * @param token the JWT token from which claims are extracted
     * @return the extracted claims
     */
	private Claims extractClaims(String token)
	{
		return  Jwts.parserBuilder()
                .setSigningKey(SECRETKEY)  
                .build()
                .parseClaimsJws(token)  
                .getBody();
	}
	/**
     * Validates the specified JWT token by checking its username and expiration status.
     * 
     * @param token the JWT token to validate
     * @param username the username to validate against the token
     * @return true if the token is valid, false otherwise
     */
	public boolean validateToken(String token, String username)
	{
		return (username.equals(extractUsername(token))) && !isTokenExpired(token);
		
	}
	/**
     * Extracts the username from the specified JWT token.
     * 
     * @param token the JWT token from which the username is extracted
     * @return the extracted username
     */
	public String extractUsername(String token) {
		return extractClaims(token).getSubject();
	}
	/**
     * Checks if the specified JWT token is expired.
     * 
     * @param token the JWT token to check
     * @return true if the token is expired, false otherwise
     */
    public boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());  // Check if the expiration date is before current time
    }
}
