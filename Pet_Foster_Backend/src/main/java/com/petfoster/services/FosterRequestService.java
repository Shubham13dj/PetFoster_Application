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
/**
 * Service class for managing foster requests and their related operations.
 */
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
    
    /**
     * Creates a new foster request.
     * 
     * @param userId the user ID of the foster parent
     * @param petId the pet ID
     * @param fosterRequestDTO the foster request data transfer object containing request details
     * @return the created foster request's data transfer object
     */
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
    /**
     * Accepts a foster request, updating the pet's status and assigning the foster parent.
     * 
     * @param userId the user ID of the foster parent
     * @param petId the pet ID
     */
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
    /**
     * Retrieves a list of all foster requests.
     * 
     * @return a list of FosterRequestDTO objects representing all foster requests
     */
    public List<FosterRequestDTO> getAllFosterRequests() {
        return fosterRequestRepository.findAll().stream()
        		.map(fostReq -> modelMapper.map(fostReq, FosterRequestDTO.class))
        		.toList();
    }
    /**
     * Retrieves a foster request by the pet ID.
     * 
     * @param petId the pet ID
     * @return a FosterRequestDTO object representing the foster request
     */
    public FosterRequestDTO getFosterRequestByPetId(Long petId) {
    	FosterRequest fosterRequest=fosterRequestRepository.findByPetId(petId);
    	
    	if(fosterRequest != null)
        return modelMapper.map(fosterRequest, FosterRequestDTO.class);
    	
    	return null;
    }
    /**
     * Updates an existing foster request.
     * 
     * @param id the foster request ID
     * @param updatedRequestDTO the updated foster request data transfer object
     * @return the updated foster request's data transfer object
     */
    @Transactional
    public FosterRequestDTO updateFosterRequest(Long id, FosterRequestDTO updatedRequestDTO) {
        if (fosterRequestRepository.existsById(id)) {
//            updatedRequestDTO.setId(id);
            return modelMapper.map(fosterRequestRepository.save(modelMapper.map(updatedRequestDTO, FosterRequest.class)), FosterRequestDTO.class);
        }
        return null;  // Or throw an exception
    }
    /**
     * Changes the status of a foster request based on the provided ID and FosterRequestDTO.
     * Updates the status, assigns a foster parent, and sets the fostered status of the pet.
     *
     * @param id the ID of the foster request to be updated
     * @param fostDTO the data transfer object containing the new status of the foster request
     * @throws NoSuchElementException if the foster request, user, or pet is not found
     */
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
    /**
     * Deletes a foster request based on the provided ID.
     *
     * @param id the ID of the foster request to be deleted
     * @throws EmptyResultDataAccessException if the foster request is not found
     */
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
