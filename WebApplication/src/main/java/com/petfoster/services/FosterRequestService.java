package com.petfoster.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petfoster.model.FosterRequest;
import com.petfoster.modelDTO.FosterRequestDTO;
import com.petfoster.repository.FosterRequestRepository;

import jakarta.transaction.Transactional;

@Service
public class FosterRequestService {

    @Autowired
    private FosterRequestRepository fosterRequestRepository;

    @Autowired
    private ModelMapper modelMapper;  // Used for converting DTOs to entities and vice versa

    // Create a new foster request
    @Transactional
    public FosterRequestDTO createFosterRequest(FosterRequestDTO fosterRequestDTO) {
        return modelMapper.map(fosterRequestRepository.save(modelMapper.map(fosterRequestDTO, FosterRequest.class)), FosterRequestDTO.class);
    }

    // Get all foster requests
    public List<FosterRequestDTO> getAllFosterRequests() {
        return fosterRequestRepository.findAll().stream()
        		.map(fostReq -> modelMapper.map(fostReq, FosterRequestDTO.class))
        		.toList();
    }

    // Get a foster request by ID
    public FosterRequestDTO getFosterRequestById(Long id) {
        return modelMapper.map(fosterRequestRepository.findById(id),FosterRequestDTO.class);
        
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
