package com.petfoster.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petfoster.modelDTO.FosterDTO;
import com.petfoster.services.FosterService;

@RestController
@RequestMapping("/foster")
public class FosterController {

	@Autowired
	private FosterService fosterService;
	
	@GetMapping
	public List<FosterDTO> getAllFoster(){
		return fosterService.getAllFoster();
	}
	
	@GetMapping("/{id}")
	public FosterDTO getFosterById(@PathVariable Long id) {
		return fosterService.getFosterById(id);
	}
	
	@PostMapping
	public FosterDTO addFoster(@RequestBody FosterDTO fosterDTO) {
		return fosterService.addFoster(fosterDTO);
	}
	
	@PutMapping
	public FosterDTO updateFoster(@PathVariable Long id, @RequestBody FosterDTO fosterDTO) {
		return fosterService.updateFoster(id, fosterDTO);
	}
	
	@DeleteMapping
	public void deleteFoster(@PathVariable Long id) {
		fosterService.deleteFoster(id);
	}
}
