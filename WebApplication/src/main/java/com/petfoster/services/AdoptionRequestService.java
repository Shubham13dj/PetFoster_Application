package com.petfoster.services;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petfoster.model.AdoptionRequest;
import com.petfoster.modelDTO.AdoptionRequestDTO;
import com.petfoster.repository.AdoptionRequestRepository;

@Service
public class AdoptionRequestService {

	@Autowired
	private AdoptionRequestRepository adoptionRequestRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public AdoptionRequestDTO createAdoptionRequest(AdoptionRequestDTO adoptionRequestDTO)
	{
		return modelMapper.map(adoptionRequestRepository.save(modelMapper.map(adoptionRequestDTO, AdoptionRequest.class)), AdoptionRequestDTO.class);
	}
	
	public AdoptionRequestDTO changeAdoptionStatus(Long id, String status)
	{
		AdoptionRequest adoptionRequest = adoptionRequestRepository.findById(id).orElseThrow(()-> new RuntimeException("Request not found"));
		adoptionRequest.setStatus(status);
		adoptionRequestRepository.save(adoptionRequest);
		return modelMapper.map(adoptionRequest, AdoptionRequestDTO.class);
	}

	public void deleteAdoptionRequest(Long id)
	{
		adoptionRequestRepository.deleteById(id);
	}
}
