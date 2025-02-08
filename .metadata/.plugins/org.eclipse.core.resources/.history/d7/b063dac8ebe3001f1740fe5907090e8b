package com.petfoster.services;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petfoster.model.AdoptionHistory;
import com.petfoster.modelDTO.AdoptionHistoryDTO;
import com.petfoster.repository.AdoptionHistoryRepository;

@Service
public class AdoptionHistoryService {

    @Autowired
    private AdoptionHistoryRepository adoptionHistoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Fetch a single adoption history by its ID
    public AdoptionHistoryDTO getAdoptionHistory(Long id) {
        AdoptionHistory history = adoptionHistoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("AdoptionHistory not found with ID: " + id));
        return modelMapper.map(history, AdoptionHistoryDTO.class);
    }

    // Fetch all adoption histories
    public List<AdoptionHistoryDTO> getAllAdoptionHistories() {
        List<AdoptionHistory> histories = adoptionHistoryRepository.findAll();
        return histories.stream()
                .map(history -> modelMapper.map(history, AdoptionHistoryDTO.class))
                .toList();  // Collect the mapped DTOs
    }

    // Create a new adoption history
    public AdoptionHistoryDTO createAdoptionHistory(AdoptionHistoryDTO adoptionHistoryDTO) {
        AdoptionHistory history = modelMapper.map(adoptionHistoryDTO, AdoptionHistory.class);
        AdoptionHistory savedHistory = adoptionHistoryRepository.save(history);
        return modelMapper.map(savedHistory, AdoptionHistoryDTO.class);
    }

    // Update an existing adoption history
    public AdoptionHistoryDTO updateAdoptionHistory(Long id, AdoptionHistoryDTO adoptionHistoryDTO) {
        AdoptionHistory history = adoptionHistoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("AdoptionHistory not found with ID: " + id));

        // Map updated details from DTO to entity
        modelMapper.map(adoptionHistoryDTO, history);

        AdoptionHistory updatedHistory = adoptionHistoryRepository.save(history);
        return modelMapper.map(updatedHistory, AdoptionHistoryDTO.class);
    }

    // Delete an adoption history record by its ID
    public void deleteAdoptionHistory(Long id) {
        if (!adoptionHistoryRepository.existsById(id)) {
            throw new RuntimeException("AdoptionHistory not found with ID: " + id);
        }
        adoptionHistoryRepository.deleteById(id);
    }
}
