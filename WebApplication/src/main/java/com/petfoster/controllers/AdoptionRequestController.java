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

import com.petfoster.modelDTO.AdoptionRequestDTO;
import com.petfoster.services.AdoptionRequestService;

@RestController
@RequestMapping("/adoption-request")
public class AdoptionRequestController {

	@Autowired
	private AdoptionRequestService adoptionRequestService;
	
	@PostMapping
	public ResponseEntity<AdoptionRequestDTO> addAdoptionRequest(@RequestBody AdoptionRequestDTO adoptionRequestDTO)
	{
		return ResponseEntity.ok(adoptionRequestService.createAdoptionRequest(adoptionRequestDTO));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AdoptionRequestDTO> updateAdoptionStatus(@PathVariable Long id, @RequestBody String status)
	{
		return ResponseEntity.ok(adoptionRequestService.changeAdoptionStatus(id, status));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAdoptionRequest(@PathVariable Long id)
	{
		adoptionRequestService.deleteAdoptionRequest(id);
		return ResponseEntity.noContent().build();
	}
}
