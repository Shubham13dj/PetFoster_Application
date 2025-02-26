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

/**
 * REST controller for handling foster request operations.
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/foster-request")
public class FosterRequestController {

	@Autowired
	private FosterRequestService fosterRequestService;
	/**
     * Adds a new foster request.
     *
     * @param user_id the ID of the user making the request
     * @param pet_id the ID of the pet to be fostered
     * @param fosterRequestDTO the foster request data transfer object
     * @return a ResponseEntity containing the created FosterRequestDTO
     */
	@PostMapping("/{user_id}/{pet_id}")
	public ResponseEntity<FosterRequestDTO> addFosterRequest(@PathVariable Long user_id, @PathVariable Long pet_id, @RequestBody FosterRequestDTO fosterRequestDTO)
	{
		return ResponseEntity.ok(fosterRequestService.createFosterRequest(user_id, pet_id, fosterRequestDTO));
	}
	/**
     * Accepts a foster request.
     *
     * @param user_id the ID of the user whose request is accepted
     * @param pet_id the ID of the pet to be fostered
     * @return a ResponseEntity with no content
     */
	@PutMapping("/{user_id}/{pet_id}")
	public ResponseEntity<Void> acceptFosterRequest(@PathVariable Long user_id, @PathVariable Long pet_id)
	{
		fosterRequestService.acceptFosterRequest(user_id, pet_id);
		return ResponseEntity.noContent().build();
	}
	/**
     * Retrieves all foster requests.
     *
     * @return a ResponseEntity containing a list of FosterRequestDTOs
     */
	@GetMapping
	public ResponseEntity<List<FosterRequestDTO>> getAllFosterRequests()
	{
		return ResponseEntity.ok(fosterRequestService.getAllFosterRequests());
	}
	/**
     * Retrieves a foster request by pet ID.
     *
     * @param petId the ID of the pet
     * @return a ResponseEntity containing the requested FosterRequestDTO
     */
	@GetMapping("/pet/{petId}")
	public ResponseEntity<FosterRequestDTO> getFosterRequestByPetId(@PathVariable Long petId)
	{
		return ResponseEntity.ok(fosterRequestService.getFosterRequestByPetId(petId));
	}
	/**
     * Updates a foster request.
     *
     * @param id the ID of the foster request to be updated
     * @param fosterRequestDTO the updated foster request data transfer object
     * @return a ResponseEntity containing the updated FosterRequestDTO
     */
	@PutMapping("/{id}")
	public ResponseEntity<FosterRequestDTO> updateFosterRequest(@PathVariable Long id, @RequestBody FosterRequestDTO fosterRequestDTO)
	{
		return ResponseEntity.ok(fosterRequestService.updateFosterRequest(id, fosterRequestDTO));
	}
	/**
     * Deletes a foster request.
     *
     * @param id the ID of the foster request to be deleted
     * @return a ResponseEntity with no content
     */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteFosterReqeust(@PathVariable Long id)
	{
		fosterRequestService.deleteFosterRequest(id);
		return ResponseEntity.noContent().build();
	}
	/**
     * Changes the status of a foster request.
     *
     * @param id the ID of the foster request
     * @param forReqDTO the foster request data transfer object with the new status
     * @return a ResponseEntity with no content
     */
	@PatchMapping("/{id}")
	public ResponseEntity<?> changeStatusOfRequest(@PathVariable Long id, @RequestBody FosterRequestDTO forReqDTO)
	{
		fosterRequestService.changeStatusOfRequest(id, forReqDTO);
		return ResponseEntity.noContent().build();
	}
}
