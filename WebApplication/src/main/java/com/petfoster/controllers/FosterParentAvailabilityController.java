package com.petfoster.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petfoster.modelDTO.FosterParentAvailabilityDTO;
import com.petfoster.services.FosterParentAvailabilityService;

@RestController
@RequestMapping("/fp-availability")
public class FosterParentAvailabilityController {

	@Autowired
	private FosterParentAvailabilityService fosterParentAvailabilityService;
	
	@PostMapping
	public ResponseEntity<FosterParentAvailabilityDTO> addFosterParentAvailibility(@RequestBody FosterParentAvailabilityDTO fosterParentAvailabilityDTO)
	{
		return ResponseEntity.ok(fosterParentAvailabilityService.createFosterParentAvailability(fosterParentAvailabilityDTO));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<FosterParentAvailabilityDTO> updateFosterParentAvailibility(@PathVariable Long id,@RequestBody FosterParentAvailabilityDTO fosterParentAvailabilityDTO)
	{
		return ResponseEntity.ok(fosterParentAvailabilityService.updateFosterParentAvailability(id, fosterParentAvailabilityDTO));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteFosterParentAvailability(@PathVariable Long id)
	{
		fosterParentAvailabilityService.deleteFosterParentAvailability(id);
		return ResponseEntity.noContent().build();
	}
}
