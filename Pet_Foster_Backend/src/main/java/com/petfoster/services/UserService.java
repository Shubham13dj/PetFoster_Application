package com.petfoster.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.petfoster.model.User;
import com.petfoster.modelDTO.UserDTO;
import com.petfoster.repository.UserRepository;
import com.petfoster.utils.JWTUtils;
import com.petfoster.utils.PasswordUtils;

import jakarta.transaction.Transactional;
/**
 * Service class for managing users and their authentication.
 */
@Service
public class UserService {
	
	/*
	 * 	Register new users
	Update user profile
	Retrieve user details
	Authentication and authorization (Login, Reset Password)

	 */

	 /**
     * Repository for accessing user data.
     */
	@Autowired
	private UserRepository userRepository;
	 /**
     * Model mapper for mapping DTOs to entities and vice versa.
     */
	@Autowired
	private ModelMapper modelMapper;
	 /**
     * Utility for handling JWT token generation and validation.
     */
	@Autowired
	private JWTUtils jwtUtils;
	/**
     * Registers a new user.
     * 
     * @param userDTO the user data transfer object containing user details
     * @return the registered user's data transfer object
     */
	@Transactional
	public UserDTO signup(UserDTO userDTO)
	{
		User user = modelMapper.map(userDTO, User.class);
		if(userRepository.findUserByEmail(user.getEmail()) != null)
			throw new RuntimeException("Username already registerd please login ");
		
		user.setPassword(PasswordUtils.hashPassword(user.getPassword()));
		return modelMapper.map(userRepository.save(user), UserDTO.class);
	}
	/**
     * Updates the profile of an existing user.
     * 
     * @param id the user ID
     * @param userDTO the user data transfer object containing updated user details
     * @return the updated user's data transfer object
     */
	@Transactional
	public UserDTO updateUserProfile( Long id,UserDTO userDTO)
	{
		User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
		user.setEmail(userDTO.getEmail());
		user.setPassword(PasswordUtils.hashPassword(userDTO.getPassword()));
		user.setEmail(userDTO.getEmail());
		user.setPhoneNumber(userDTO.getPhoneNumber());
		user.setGender(userDTO.getGender());
		user.setEnabled(userDTO.isEnabled());
		
		return modelMapper.map(userRepository.save(user), UserDTO.class);
	}
	
	/**
     * Authenticates a user and generates a JWT token.
     * 
     * @param userDTO the user data transfer object containing login credentials
     * @return the authenticated user's data transfer object with a JWT token
     */
	public UserDTO login( UserDTO userDTO)
	{
		
		User user = userRepository.findUserByEmail(userDTO.getEmail());
		if(PasswordUtils.validatePassword(userDTO.getPassword(), user.getPassword())) {
			
			userDTO = modelMapper.map(user, UserDTO.class);
			userDTO.setJsonToken(jwtUtils.generateToken(userDTO.getEmail()));
			
			return userDTO;
		}else {
			throw new RuntimeException("Unauthorized user");
		}
	
	}
	/**
     * Retrieves the details of a user by their ID.
     * 
     * @param userId the user ID
     * @return the user's data transfer object
     */
	@Cacheable("user")
	public UserDTO getUserDetails(Long userId)
	{
		User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found"));
		user.setPassword(null);
		return modelMapper.map(user, UserDTO.class);
	}
	
}
