package com.petfoster.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petfoster.modelDTO.ShelterDTO;
import com.petfoster.services.ShelterServices;

/*
 * Tested ok
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/shelter")
public class ShelterController {

	@Autowired
	private ShelterServices shelterServices;
	
	@PostMapping
	public ResponseEntity<ShelterDTO> addShelter(@RequestBody ShelterDTO shelterDTO)
	{
		return ResponseEntity.ok(shelterServices.addShelter(shelterDTO));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ShelterDTO> updateShelter(@PathVariable Long id, @RequestBody ShelterDTO shelterDTO)
	{
		return ResponseEntity.ok(shelterServices.updateShelter(id, shelterDTO));
	}
	
	@GetMapping
	public ResponseEntity<List<ShelterDTO>> getAllShelter()
	{
		return ResponseEntity.ok(shelterServices.getAllShelters());
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteShelter(@PathVariable Long id)
	{
		shelterServices.deleteShelterById(id);
		return ResponseEntity.noContent().build();
	}
	@GetMapping("/loc")
	public ResponseEntity<List<ShelterDTO>> getSheleterByLocation(@RequestBody String location)
	{
		return ResponseEntity.ok(shelterServices.getShelterByLocation(location));
	}
	
	/*
	 * Accepting Integer value need to change it to string
	 */
	@PatchMapping("/{id}")
	public ResponseEntity<ShelterDTO> updateCount(@PathVariable Long id, @RequestBody Integer newCount)
	{
		return ResponseEntity.ok(shelterServices.updateAvailablePetsCount(id, newCount));
	}
}
