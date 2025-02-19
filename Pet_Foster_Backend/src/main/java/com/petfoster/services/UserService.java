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

@Service
public class UserService {
	
	/*
	 * 	Register new users
	Update user profile
	Retrieve user details
	Authentication and authorization (Login, Reset Password)

	 */

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private JWTUtils jwtUtils;
	
	
	
	

	@Transactional
	public UserDTO signup(UserDTO userDTO)
	{
		User user = modelMapper.map(userDTO, User.class);
		if(userRepository.findUserByEmail(user.getEmail()) != null)
			throw new RuntimeException("Username already registerd please login ");
		
		user.setPassword(PasswordUtils.hashPassword(user.getPassword()));
		return modelMapper.map(userRepository.save(user), UserDTO.class);
	}
	
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
	
	@Cacheable("user")
	public UserDTO getUserDetails(Long userId)
	{
		User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found"));
		user.setPassword(null);
		return modelMapper.map(user, UserDTO.class);
	}
	
}
