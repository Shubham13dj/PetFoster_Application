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

import com.petfoster.modelDTO.FosterRequestDTO;
import com.petfoster.services.FosterRequestService;

@RestController
@RequestMapping("/foster-request")
public class FosterRequestController {

	@Autowired
	private FosterRequestService fosterRequestService;
	
	@PostMapping
	public ResponseEntity<FosterRequestDTO> addFosterRequest(@RequestBody FosterRequestDTO fosterRequestDTO)
	{
		return ResponseEntity.ok(fosterRequestService.createFosterRequest(fosterRequestDTO));
	}
	
	@GetMapping
	public ResponseEntity<List<FosterRequestDTO>> getAllFosterRequests()
	{
		return ResponseEntity.ok(fosterRequestService.getAllFosterRequests());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FosterRequestDTO> getFosterRequestById(@PathVariable Long id)
	{
		return ResponseEntity.ok(fosterRequestService.getFosterRequestById(id));
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
}
