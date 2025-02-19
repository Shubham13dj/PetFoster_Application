package com.petfoster.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


public class PasswordUtils {
	
	private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	public static String hashPassword(String password)
	{
		return encoder.encode(password);
	}
	
	public static boolean validatePassword(String password, String hashedPassword)
	{
		return encoder.matches(password, hashedPassword);
	}
}
