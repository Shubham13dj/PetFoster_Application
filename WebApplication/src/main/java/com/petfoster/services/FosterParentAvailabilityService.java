package com.petfoster.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petfoster.model.FosterParentAvailability;
import com.petfoster.modelDTO.FosterParentAvailabilityDTO;
import com.petfoster.repository.FosterParentAvailabilityRepository;

import jakarta.transaction.Transactional;

@Service
public class FosterParentAvailabilityService {

	@Autowired
	private FosterParentAvailabilityRepository fosterParentAvailabilityRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Transactional
	public FosterParentAvailabilityDTO createFosterParentAvailability(FosterParentAvailabilityDTO fosterParentAvailabilityDTO)
	{
		return modelMapper.map(fosterParentAvailabilityRepository.save(modelMapper.map(fosterParentAvailabilityDTO, FosterParentAvailability.class)), FosterParentAvailabilityDTO.class);
	}
	
	@Transactional
	public FosterParentAvailabilityDTO updateFosterParentAvailability(Long id, FosterParentAvailabilityDTO fosterParentAvailabilityDTO)
	{
		FosterParentAvailability fosterParentAvailability = fosterParentAvailabilityRepository.findById(id).orElseThrow(()-> new RuntimeException("Availability not found"));
		fosterParentAvailability.setAvailabelFromDate(fosterParentAvailabilityDTO.getAvailabelFromDate());
		fosterParentAvailability.setAvailabelTillDate(fosterParentAvailabilityDTO.getAvailabelTillDate());
		return modelMapper.map(fosterParentAvailabilityRepository.save(fosterParentAvailability), FosterParentAvailabilityDTO.class);
	}
	
	@Transactional
	public void deleteFosterParentAvailability(Long id)
	{
		fosterParentAvailabilityRepository.deleteById(id);
	}
}
