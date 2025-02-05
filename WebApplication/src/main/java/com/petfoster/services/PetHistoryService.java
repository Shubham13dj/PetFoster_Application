package com.petfoster.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petfoster.model.PetHistory;
import com.petfoster.modelDTO.PetHistoryDTO;
import com.petfoster.repository.PetHistoryRepository;

@Service
public class PetHistoryService {

    @Autowired
    private PetHistoryRepository petHistoryRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    // Create a new PetHistory
    public PetHistoryDTO createPetHistory(PetHistoryDTO petHistoryDTO) {
        return modelMapper.map(petHistoryRepository.save(modelMapper.map(petHistoryDTO, PetHistory.class)),PetHistoryDTO.class);
    }

    // Get all PetHistory records
    public List<PetHistoryDTO> getAllPetHistories() {
        return petHistoryRepository.findAll()
        		.stream()
        		.map(petHistory -> modelMapper.map(petHistory, PetHistoryDTO.class))
        		.toList();
    }

    // Get PetHistory by ID
//    public PetHistoryDTO getPetHistoryById(Long id) {
//        return modelMapper.map(petHistoryRepository.findById(id), PetHistoryDTO.class);
//    }

    // Update PetHistory record
    public PetHistoryDTO updatePetHistory(Long id, PetHistoryDTO updatedPetHistoryDTO) {
        if (petHistoryRepository.existsById(id)) {
            updatedPetHistoryDTO.setHistoryId(id); // Set the ID for the update
            return modelMapper.map(petHistoryRepository.save(modelMapper.map(updatedPetHistoryDTO, PetHistory.class)),PetHistoryDTO.class);
        }
        return null;  // Return null or throw an exception if not found
    }

    // Delete PetHistory record
    public void deletePetHistory(Long id) {
        petHistoryRepository.deleteById(id);
    }

    // Custom method to get PetHistory by Pet ID (for example, fetch history of a specific pet)
    public List<PetHistoryDTO> getPetHistoryByPetId(Long petId) {
        return petHistoryRepository.findByPet_PetId(petId)
        		.stream()
        		.map(petHistory -> modelMapper.map(petHistory, PetHistoryDTO.class))
        		.toList(); // Assuming a custom query method in repository
    }
}
