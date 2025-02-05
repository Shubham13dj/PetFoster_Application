package com.petfoster.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.petfoster.model.User;
import com.petfoster.modelDTO.UserDTO;
import com.petfoster.repository.UserRepository;

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

	public UserDTO addNewUser(UserDTO userDTO)
	{
		User user = modelMapper.map(userDTO, User.class);
		
		return modelMapper.map(userRepository.save(user), UserDTO.class);
	}
	
	public UserDTO updateUserProfile( Long id,UserDTO userDTO)
	{
		User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		user.setEmail(userDTO.getEmail());
		user.setPhoneNumber(userDTO.getPhoneNumber());
		user.setGender(userDTO.getGender());
		user.setEnabled(userDTO.isEnabled());
		
		return modelMapper.map(userRepository.save(user), UserDTO.class);
	}
	
	public UserDTO authenticateUser(String email, String password)
	{
		User user = userRepository.findUserByEmail(email);
		if(user.getPassword().equals(password)) {
			return modelMapper.map(user, UserDTO.class);
		}else {
			throw new RuntimeException("Unauthorized user");
		}
	
	}
	
	public UserDTO getUserDetails(Long userId)
	{
		User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found"));
		user.setPassword(null);
		return modelMapper.map(user, UserDTO.class);
	}
}
