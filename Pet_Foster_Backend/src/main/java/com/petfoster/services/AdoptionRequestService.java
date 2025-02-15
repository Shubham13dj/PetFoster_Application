package com.petfoster.services;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petfoster.enums.util.RequestStatus;
import com.petfoster.model.AdoptionRequest;
import com.petfoster.model.Pet;
import com.petfoster.model.User;
import com.petfoster.modelDTO.AdoptionRequestDTO;
import com.petfoster.repository.AdoptionRequestRepository;
import com.petfoster.repository.PetRepository;
import com.petfoster.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class AdoptionRequestService {

	@Autowired
	private AdoptionRequestRepository adoptionRequestRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired 
	private UserRepository userRepo;
	
	@Autowired 
	private PetRepository petRepo;
	
	
	@Transactional
	public AdoptionRequestDTO createAdoptionRequest(AdoptionRequestDTO adoptionRequestDTO) {
	    // Fetch the adopter by ID (use the ID provided in the DTO)
	    User user = userRepo.findById(adoptionRequestDTO.getAdopter()).orElseThrow();

	    // Fetch the pet by ID (use the ID provided in the DTO)
	    Pet pet = petRepo.findById(adoptionRequestDTO.getPet()).orElseThrow();

	    // Map the DTO to the AdoptionRequest entity
	  
	    AdoptionRequest adoptRequest = new AdoptionRequest();
	    
	    // Set the actual User and Pet entities on the AdoptionRequest
	    adoptRequest.setRequestDate(adoptionRequestDTO.getRequestDate());
	    adoptRequest.setStatus(adoptionRequestDTO.getStatus());
	    adoptRequest.setAdopter(user);
	    adoptRequest.setPet(pet);

	    // Save the adoption request
	    AdoptionRequest savedAdoptRequest = adoptionRequestRepository.save(adoptRequest);

	    AdoptionRequestDTO adoptReq = new AdoptionRequestDTO();
	    adoptReq.setId(savedAdoptRequest.getId());
	    adoptReq.setRequestDate(savedAdoptRequest.getRequestDate());
	    adoptReq.setPet(savedAdoptRequest.getPet().getId());
	    adoptReq.setAdopter(savedAdoptRequest.getAdopter().getId());
	    adoptReq.setStatus(RequestStatus.valueOf(savedAdoptRequest.getStatus()));
	    // Map the saved entity back to DTO and return it
	    return adoptReq;
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
