/**
 * Provides the REST controllers for handling adoption requests in the Pet Foster System
 */
package com.petfoster.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petfoster.modelDTO.AdoptionRequestDTO;
import com.petfoster.services.AdoptionRequestService;

/**
 * Controller for handling adoption request
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/adoption-request")
public class AdoptionRequestController {

	@Autowired
	private AdoptionRequestService adoptionRequestService;
	/**
	 * Adds a new adoption request.
	 * 
	 * @param adoptionRequestDTO the adoption request data transfer object
	 * @return the created adoption request
	 */
	@PostMapping
	public ResponseEntity<AdoptionRequestDTO> addAdoptionRequest(@RequestBody AdoptionRequestDTO adoptionRequestDTO)
	{
		return ResponseEntity.ok(adoptionRequestService.createAdoptionRequest(adoptionRequestDTO));
	}
	/**
	 * Updates the adoption status of an existing adoption request
	 * 
	 * @param id the ID of the adoption request to update
	 * @param status the new status of the adoption request
	 * @return the updated adoption request
	 */
	@PutMapping("/{id}")
	public ResponseEntity<AdoptionRequestDTO> updateAdoptionStatus(@PathVariable Long id, @RequestBody String status)
	{
		return ResponseEntity.ok(adoptionRequestService.changeAdoptionStatus(id, status));
	}
	/**
	 * Deletes an existing adoption request
	 * 
	 * @param id the ID of the adoption request to delete
	 * @return an empty response entity
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAdoptionRequest(@PathVariable Long id)
	{
		adoptionRequestService.deleteAdoptionRequest(id);
		return ResponseEntity.noContent().build();
	}
}
