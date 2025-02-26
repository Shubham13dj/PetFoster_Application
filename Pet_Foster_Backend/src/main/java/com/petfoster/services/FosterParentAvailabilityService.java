package com.petfoster.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petfoster.model.FosterParentAvailability;
import com.petfoster.modelDTO.FosterParentAvailabilityDTO;
import com.petfoster.repository.FosterParentAvailabilityRepository;

import jakarta.transaction.Transactional;
/**
 * Service class to manage foster parent availability.
 */
@Service
public class FosterParentAvailabilityService {

	@Autowired
	private FosterParentAvailabilityRepository fosterParentAvailabilityRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	 /**
     * Creates a new foster parent availability record.
     *
     * @param fosterParentAvailabilityDTO The DTO containing availability details.
     * @return The created FosterParentAvailabilityDTO.
     */
	@Transactional
	public FosterParentAvailabilityDTO createFosterParentAvailability(FosterParentAvailabilityDTO fosterParentAvailabilityDTO)
	{
		return modelMapper.map(fosterParentAvailabilityRepository.save(modelMapper.map(fosterParentAvailabilityDTO, FosterParentAvailability.class)), FosterParentAvailabilityDTO.class);
	}
	 /**
     * Updates an existing foster parent availability record.
     *
     * @param id The ID of the availability record to update.
     * @param fosterParentAvailabilityDTO The DTO containing updated availability details.
     * @return The updated FosterParentAvailabilityDTO.
     * @throws RuntimeException if the availability record is not found.
     */
	@Transactional
	public FosterParentAvailabilityDTO updateFosterParentAvailability(Long id, FosterParentAvailabilityDTO fosterParentAvailabilityDTO)
	{
		FosterParentAvailability fosterParentAvailability = fosterParentAvailabilityRepository.findById(id).orElseThrow(()-> new RuntimeException("Availability not found"));
		fosterParentAvailability.setAvailabelFromDate(fosterParentAvailabilityDTO.getAvailabelFromDate());
		fosterParentAvailability.setAvailabelTillDate(fosterParentAvailabilityDTO.getAvailabelTillDate());
		return modelMapper.map(fosterParentAvailabilityRepository.save(fosterParentAvailability), FosterParentAvailabilityDTO.class);
	}
	 /**
     * Deletes a foster parent availability record by its ID.
     *
     * @param id The ID of the availability record to delete.
     */
	@Transactional
	public void deleteFosterParentAvailability(Long id)
	{
		fosterParentAvailabilityRepository.deleteById(id);
	}
}
