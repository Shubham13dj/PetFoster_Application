package com.petfoster.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petfoster.model.Foster;
import com.petfoster.modelDTO.FosterDTO;
import com.petfoster.repository.FosterRepository;

import jakarta.transaction.Transactional;

@Service
public class FosterService {

	@Autowired
	private FosterRepository fosterRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public List<FosterDTO> getAllFoster()
	{
		List<Foster> fosters = fosterRepository.findAll();
		
		return fosters.stream()
				.map(foster -> modelMapper.map(fosters, FosterDTO.class))
				.collect(Collectors.toList());
	}
	
	public FosterDTO getFosterById(Long id)
	{
		Foster foster= fosterRepository.findById(id).orElseThrow(()->new RuntimeException("Foster Not found"));
		return modelMapper.map(foster, FosterDTO.class);
	}
	
	@Transactional
	public FosterDTO addFoster(FosterDTO fosterDTO)
	{
		Foster foster = modelMapper.map(fosterDTO, Foster.class);
		return modelMapper.map(fosterRepository.save(foster), FosterDTO.class);
	}
	
	@Transactional
	public FosterDTO updateFoster(Long id, FosterDTO fosterDTO)
	{
		Foster foster = fosterRepository.findById(id).orElseThrow(()->new RuntimeException("Foster not found"));
		foster.setName(fosterDTO.getName());
		foster.setContactDetails(fosterDTO.getContactDetails());
		foster = fosterRepository.save(foster);
		
		return modelMapper.map(foster, FosterDTO.class);
	}
	
	@Transactional
	public void deleteFoster(Long id)
	{
		fosterRepository.deleteById(id);
	}
	
	
	/*
	 * 	Foster parent requests to foster a pet
	Approve/Reject requests
	Track status of requests

	 */
	
}

