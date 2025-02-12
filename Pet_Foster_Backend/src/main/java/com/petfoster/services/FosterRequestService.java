package com.petfoster.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petfoster.enums.util.RequestStatus;
import com.petfoster.model.FosterRequest;
import com.petfoster.model.Pet;
import com.petfoster.model.User;
import com.petfoster.modelDTO.FosterRequestDTO;
import com.petfoster.repository.FosterRequestRepository;
import com.petfoster.repository.PetRepository;
import com.petfoster.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class FosterRequestService {

    @Autowired
    private FosterRequestRepository fosterRequestRepository;

    @Autowired
    private ModelMapper modelMapper;  // Used for converting DTOs to entities and vice versa

    @Autowired
    private UserRepository userRepo;
    
    @Autowired
    private PetRepository petRepo;
    
    // Create a new foster request
    @Transactional
    public FosterRequestDTO createFosterRequest(Long userId, Long petId, FosterRequestDTO fosterRequestDTO) {
    	
    	FosterRequest fosReq = modelMapper.map(fosterRequestDTO, FosterRequest.class);
    	User user = userRepo.findById(userId).orElse(null);
    	Pet pet = petRepo.findById(petId).orElseThrow();
    	pet.setAvailableToFoster(true);
    	pet.setFostered(false);
    	fosReq.setParent(user);
    	fosReq.setPet(pet);
    	
        return modelMapper.map(fosterRequestRepository.save(fosReq), FosterRequestDTO.class);
    }
    
    @Transactional
    public void acceptFosterRequest(Long userId, Long petId)
    {
    	
    	Pet pet = petRepo.findById(petId).orElseThrow();
    	pet.setFostered(true);
    	pet.setAvailableToFoster(false);
    	
    	User user = userRepo.findById(userId).orElse(null);
    	
    	FosterRequest fosReq = fosterRequestRepository.findByPetId(petId);
    	fosReq.setPet(pet);
    	fosReq.setFosterParent(user);
    	fosReq.setStatus(RequestStatus.ACCEPTED);
    	
    	fosterRequestRepository.save(fosReq);
    }

    // Get all foster requests
    public List<FosterRequestDTO> getAllFosterRequests() {
        return fosterRequestRepository.findAll().stream()
        		.map(fostReq -> modelMapper.map(fostReq, FosterRequestDTO.class))
        		.toList();
    }

    // Get a foster request by ID
    public FosterRequestDTO getFosterRequestByPetId(Long petId) {
        return modelMapper.map(fosterRequestRepository.findByPetId(petId), FosterRequestDTO.class);
    }

    // Update a foster request
    @Transactional
    public FosterRequestDTO updateFosterRequest(Long id, FosterRequestDTO updatedRequestDTO) {
        if (fosterRequestRepository.existsById(id)) {
            updatedRequestDTO.setId(id);
            return modelMapper.map(fosterRequestRepository.save(modelMapper.map(updatedRequestDTO, FosterRequest.class)), FosterRequestDTO.class);
        }
        return null;  // Or throw an exception
    }

    @Transactional
    public void changeStatusOfRequest(Long id, FosterRequestDTO fostDTO)
    {	
    	FosterRequest fosterRequest = fosterRequestRepository.findById(id).orElseThrow();
    	
    	fosterRequest.setStatus(fostDTO.getStatus());
    	
    	User fosterParent = userRepo.findById(id).orElseThrow();
    	
    	fosterRequest.setFosterParent(fosterParent);
    	
    	Pet pet = petRepo.findById(fosterRequest.getPet().getId()).orElseThrow();
    	
    	
    	
    	if(fostDTO.getStatus().equals("ACCEPTED"))
    	pet.setFostered(true);
    	
    	if(fostDTO.getStatus().equals("REJECTED"))
    		pet.setFostered(false);
    	
    }
    
    // Delete a foster request
    @Transactional
    public void deleteFosterRequest(Long id) {
        fosterRequestRepository.deleteById(id);
    }

    // Convert FosterRequest entity to DTO (if you need a DTO layer)
    public FosterRequestDTO convertToDTO(FosterRequest fosterRequest) {
        return modelMapper.map(fosterRequest, FosterRequestDTO.class);
    }

    // Convert DTO to entity (for creating or updating requests from DTOs)
    public FosterRequest convertToEntity(FosterRequestDTO fosterRequestDTO) {
        return modelMapper.map(fosterRequestDTO, FosterRequest.class);
    }
}
