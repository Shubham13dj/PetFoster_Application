package com.petfoster.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petfoster.modelDTO.PetHistoryDTO;
import com.petfoster.services.PetHistoryService;

@RestController
@RequestMapping("/pet-history")
public class PetHistoryController {
	
	@Autowired
	private PetHistoryService petHistoryService;

	@PostMapping
	public ResponseEntity<PetHistoryDTO> addPetHistory(@RequestBody PetHistoryDTO petHistoryDTO)
	{
		return ResponseEntity.ok(petHistoryService.createPetHistory(petHistoryDTO));
	}
	
	@GetMapping
	public ResponseEntity<List<PetHistoryDTO>> getAllPetsHistory()
	{
		return ResponseEntity.ok(petHistoryService.getAllPetHistories());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PetHistoryDTO> updatePetHistory(@PathVariable Long id, @RequestBody PetHistoryDTO petHistoryDTO)
	{
		return ResponseEntity.ok(petHistoryService.updatePetHistory(id, petHistoryDTO));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePetHistory(@PathVariable Long id)
	{
		petHistoryService.deletePetHistory(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<PetHistoryDTO>> getPetHistoryById(@PathVariable Long id)
	{
		return ResponseEntity.ok(petHistoryService.getPetHistoryByPetId(id));
	}
}

