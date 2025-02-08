package com.petfoster.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petfoster.modelDTO.PetApplicationDTO;
import com.petfoster.services.PetApplicationService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/application")
public class FosterApplicationController {

	@Autowired
	private PetApplicationService petApplicationService;
	
	@PostMapping
	public PetApplicationDTO applyForFoster(@RequestBody PetApplicationDTO petApplicationDTO) {
		return petApplicationService.applyForFoster(petApplicationDTO);
	}
	
	@GetMapping("/{id}")
	public PetApplicationDTO getApplication(@PathVariable Long id) {
		return petApplicationService.getApplicationById(id);
	}
	
	@PatchMapping("/{id}")
	public PetApplicationDTO updateApplicationStatus(@PathVariable Long id, @RequestBody String status)
	{
		return petApplicationService.updateApplicationStatus(id, status);
	}
	@GetMapping
	public List<PetApplicationDTO> getAllApplications()
	{
		return petApplicationService.getAllApplications();
	}
}
