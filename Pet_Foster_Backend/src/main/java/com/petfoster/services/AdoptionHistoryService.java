package com.petfoster.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petfoster.model.AdoptionHistory;
import com.petfoster.modelDTO.AdoptionHistoryDTO;
import com.petfoster.repository.AdoptionHistoryRepository;

import jakarta.transaction.Transactional;

/**
 * AdoptionHistoryService provides services for managing AdoptionHistory
 * entities. This service class handles CRUD operations and data mapping for
 * AdoptionHistoryDTO and AdoptionHistory entities.
 * 
 * @package com.petfoster.services
 * 
 * @version 1.0
 * 
 * @author Team
 */
@Service
public class AdoptionHistoryService {

	@Autowired
	private AdoptionHistoryRepository adoptionHistoryRepository;

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Fetch a single adoption history by its ID.
	 *
	 * @param id the ID of the adoption history
	 * @return the AdoptionHistoryDTO associated with the given ID
	 */
	public AdoptionHistoryDTO getAdoptionHistory(Long id) {
		AdoptionHistory history = adoptionHistoryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("AdoptionHistory not found with ID: " + id));
		return modelMapper.map(history, AdoptionHistoryDTO.class);
	}

	/**
	 * Fetch all adoption histories.
	 *
	 * @return a list of AdoptionHistoryDTOs
	 */
	public List<AdoptionHistoryDTO> getAllAdoptionHistories() {
		List<AdoptionHistory> histories = adoptionHistoryRepository.findAll();
		return histories.stream().map(history -> modelMapper.map(history, AdoptionHistoryDTO.class)).toList(); // Collect
																												// the
																												// mapped
																												// DTOs
	}

	/**
	 * Create a new adoption history.
	 *
	 * @param adoptionHistoryDTO the adoption history DTO to be created
	 * @return the created AdoptionHistoryDTO
	 */
	@Transactional
	public AdoptionHistoryDTO createAdoptionHistory(AdoptionHistoryDTO adoptionHistoryDTO) {
		AdoptionHistory history = modelMapper.map(adoptionHistoryDTO, AdoptionHistory.class);
		AdoptionHistory savedHistory = adoptionHistoryRepository.save(history);
		return modelMapper.map(savedHistory, AdoptionHistoryDTO.class);
	}

	/**
	 * Update an existing adoption history.
	 *
	 * @param id                 the ID of the adoption history to be updated
	 * @param adoptionHistoryDTO the adoption history DTO with updated details
	 * @return the updated AdoptionHistoryDTO
	 */

	@Transactional
	public AdoptionHistoryDTO updateAdoptionHistory(Long id, AdoptionHistoryDTO adoptionHistoryDTO) {
		AdoptionHistory history = adoptionHistoryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("AdoptionHistory not found with ID: " + id));

		// Map updated details from DTO to entity
		modelMapper.map(adoptionHistoryDTO, history);

		AdoptionHistory updatedHistory = adoptionHistoryRepository.save(history);
		return modelMapper.map(updatedHistory, AdoptionHistoryDTO.class);
	}

	/**
	 * Deletes an adoption history record by its ID.
	 *
	 * @param id The ID of the adoption history record to delete.
	 * @throws RuntimeException if the adoption history record is not found.
	 */
	@Transactional
	public void deleteAdoptionHistory(Long id) {
		if (!adoptionHistoryRepository.existsById(id)) {
			throw new RuntimeException("AdoptionHistory not found with ID: " + id);
		}
		adoptionHistoryRepository.deleteById(id);
	}
}
