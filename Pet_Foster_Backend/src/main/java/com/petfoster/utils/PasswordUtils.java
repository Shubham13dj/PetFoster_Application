package com.petfoster.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Utility class for password hashing and validation using BCrypt.
 */
public class PasswordUtils {
	 /**
     * BCrypt password encoder used for hashing and validating passwords.
     */
	private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	 /**
     * Hashes the given password using BCrypt.
     * 
     * @param password the password to be hashed
     * @return the hashed password
     */
	public static String hashPassword(String password)
	{
		return encoder.encode(password);
	}
	/**
     * Validates the given password against the hashed password using BCrypt.
     * 
     * @param password the plain-text password to validate
     * @param hashedPassword the hashed password to validate against
     * @return true if the password matches the hashed password, false otherwise
     */
	public static boolean validatePassword(String password, String hashedPassword)
	{
		return encoder.matches(password, hashedPassword);
	}
}
