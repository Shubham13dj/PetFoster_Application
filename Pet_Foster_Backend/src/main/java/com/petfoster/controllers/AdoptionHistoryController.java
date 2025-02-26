package com.petfoster.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petfoster.modelDTO.AdoptionHistoryDTO;
import com.petfoster.services.AdoptionHistoryService;

/**
 * Controller class for managing adoption History.
 * Handles reqeusts related to adoption Historu and communicates with the service layer.
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/adoption-history")
public class AdoptionHistoryController {
	
	@Autowired
	private AdoptionHistoryService adoptionHistoryService;
	
	/**
     * Fetches Adoption History by ID.
     * 
     * @param id the ID of the Adoption History to fetch
     * @return ResponseEntity containing the AdoptionHistoryDTO
     */
	@GetMapping("/{id}")
	public ResponseEntity<AdoptionHistoryDTO> getAdoptionHistory(@PathVariable Long id)
	{
		return ResponseEntity.ok(adoptionHistoryService.getAdoptionHistory(id));
	}
	/**
     * Fetches all Adoption Histories.
     * 
     * @return ResponseEntity containing a list of AdoptionHistoryDTO
     */
	@GetMapping
	public ResponseEntity<List<AdoptionHistoryDTO>> getAllAdoptionHistories()
	{
		return ResponseEntity.ok(adoptionHistoryService.getAllAdoptionHistories());
	}
	/**
     * Creates a new Adoption History.
     * 
     * @param reqBody the details of the new Adoption History to create
     * @return ResponseEntity containing the created AdoptionHistoryDTO
     */
	@PostMapping
	public ResponseEntity<AdoptionHistoryDTO> createAdoptionHistory(@RequestBody AdoptionHistoryDTO reqBody)
	{
		return ResponseEntity.ok(adoptionHistoryService.createAdoptionHistory(reqBody));
	}
	/**
     * Updates an existing Adoption History.
     * 
     * @param id the ID of the Adoption History to update
     * @param updateRespBody the updated details of the Adoption History
     * @return ResponseEntity containing the updated AdoptionHistoryDTO
     */
	@PutMapping("/{id}")
	public ResponseEntity<AdoptionHistoryDTO> updateAdoptionHistory(@PathVariable Long id, @RequestBody AdoptionHistoryDTO updateRespBody)
	{
		return ResponseEntity.ok(adoptionHistoryService.updateAdoptionHistory(id, updateRespBody));
	}
	/**
     * Deletes an Adoption History by ID.
     * 
     * @param id the ID of the Adoption History to delete
     * @return ResponseEntity with no content
     */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAdoptionHistory(@PathVariable Long id)
	{
		adoptionHistoryService.deleteAdoptionHistory(id);
		return ResponseEntity.noContent().build();
	}
}
