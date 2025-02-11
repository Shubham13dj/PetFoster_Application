package com.petfoster.services;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petfoster.model.AdoptionRequest;
import com.petfoster.modelDTO.AdoptionRequestDTO;
import com.petfoster.repository.AdoptionRequestRepository;

import jakarta.transaction.Transactional;

@Service
public class AdoptionRequestService {

	@Autowired
	private AdoptionRequestRepository adoptionRequestRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Transactional
	public AdoptionRequestDTO createAdoptionRequest(AdoptionRequestDTO adoptionRequestDTO)
	{
		return modelMapper.map(adoptionRequestRepository.save(modelMapper.map(adoptionRequestDTO, AdoptionRequest.class)), AdoptionRequestDTO.class);
	}
	
	@Transactional
	public AdoptionRequestDTO changeAdoptionStatus(Long id, String status)
	{
		AdoptionRequest adoptionRequest = adoptionRequestRepository.findById(id).orElseThrow(()-> new RuntimeException("Request not found"));
		adoptionRequest.setStatus(status);
		adoptionRequestRepository.save(adoptionRequest);
		return modelMapper.map(adoptionRequest, AdoptionRequestDTO.class);
	}

	@Transactional
	public void deleteAdoptionRequest(Long id)
	{
		adoptionRequestRepository.deleteById(id);
	}
}
