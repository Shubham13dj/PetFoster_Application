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

import com.petfoster.modelDTO.FosterRequestDTO;
import com.petfoster.services.FosterRequestService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/foster-request")
public class FosterRequestController {

	@Autowired
	private FosterRequestService fosterRequestService;
	
	@PostMapping("/{user_id}/{pet_id}")
	public ResponseEntity<FosterRequestDTO> addFosterRequest(@PathVariable Long user_id, @PathVariable Long pet_id, @RequestBody FosterRequestDTO fosterRequestDTO)
	{
		return ResponseEntity.ok(fosterRequestService.createFosterRequest(user_id, pet_id, fosterRequestDTO));
	}
	
	@PutMapping("/{user_id}/{pet_id}")
	public ResponseEntity<Void> acceptFosterRequest(@PathVariable Long user_id, @PathVariable Long pet_id)
	{
		fosterRequestService.acceptFosterRequest(user_id, pet_id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<FosterRequestDTO>> getAllFosterRequests()
	{
		return ResponseEntity.ok(fosterRequestService.getAllFosterRequests());
	}
	
	@GetMapping("/pet/{id}")
	public ResponseEntity<FosterRequestDTO> getFosterRequestByPetId(@PathVariable Long petId)
	{
		return ResponseEntity.ok(fosterRequestService.getFosterRequestByPetId(petId));
	}
	
	
	
	@PutMapping("/{id}")
	public ResponseEntity<FosterRequestDTO> updateFosterRequest(@PathVariable Long id, @RequestBody FosterRequestDTO fosterRequestDTO)
	{
		return ResponseEntity.ok(fosterRequestService.updateFosterRequest(id, fosterRequestDTO));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteFosterReqeust(@PathVariable Long id)
	{
		fosterRequestService.deleteFosterRequest(id);
		return ResponseEntity.noContent().build();
	}
	@PatchMapping("/{id}")
	public ResponseEntity<?> changeStatusOfRequest(@PathVariable Long id, @RequestBody FosterRequestDTO forReqDTO)
	{
		fosterRequestService.changeStatusOfRequest(id, forReqDTO);
		return ResponseEntity.noContent().build();
	}
}
