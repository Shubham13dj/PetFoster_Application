	package com.petfoster.controllers;
	
	import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.petfoster.modelDTO.PetDTO;
import com.petfoster.services.PetService;
	
/**
 * Controller class for managing Pet operations.
 * Handles requests related to Pet management and communicates with the service layer.
 */
	@RestController
	@CrossOrigin    
	@RequestMapping("/pets")
	public class PetController {
	
		 	@Autowired
		    private PetService petService;
		
		 	/**
		     * Fetches a Pet by its ID.
		     * 
		     * @param id the ID of the Pet to fetch
		     * @return the PetDTO of the fetched pet
		     */
		    @GetMapping("/{id}")
		    public PetDTO getPetById(@PathVariable Long id) {
		       return petService.getPetById(id);
		    }
		    /**
		     * Fetches all Pets.
		     * 
		     * @return a list of all PetDTOs
		     */
		    @GetMapping
		    public List<PetDTO> getAllPets()
		    {
		    	return petService.getAllPets();
		    }
		    /**
		     * Fetches the image of a Pet by its ID.
		     * 
		     * @param petId the ID of the Pet to fetch the image
		     * @return ResponseEntity containing the image as a byte array
		     */
		    @GetMapping("/img/{id}")
		    public ResponseEntity<byte []> getImageById(@PathVariable int petId)
		    {
		    	return ResponseEntity.status(200)
		    			.contentType(MediaType.valueOf(petService.getPetById(Long.valueOf(petId)).getImageType()))
		    			.body(petService.getPetImageById(Long.valueOf(petId)));
		    }
		    /**
		     * Adds a new Pet.
		     * 
		     * @param userId the ID of the user adding the pet
		     * @param petDTO the details of the pet to add
		     * @param imageFile the image file of the pet
		     * @return ResponseEntity containing the created PetDTO
		     */
		    @PostMapping("/{userId}")
		    public ResponseEntity<PetDTO> addNewPet(@PathVariable Long userId,@RequestPart("petDetails") PetDTO petDTO, @RequestPart("imageData") MultipartFile imageFile)
		    {
		    	try {
					return ResponseEntity.status(HttpStatus.CREATED).body(petService.addNewPet(userId ,petDTO, imageFile));
				} catch (IOException e) {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
				}
		    }
		    /**
		     * Updates an existing Pet based on the provided ID and Pet data.
		     *
		     * @param id the ID of the Pet to be updated
		     * @param petDTO the updated Pet data
		     * @return the updated Pet data
		     */
		    @PutMapping("/{id}")
		    public PetDTO updatePet(@PathVariable Long id, @RequestBody PetDTO petDTO)
		    {
		    	return petService.updatePet(id, petDTO);
		    }
		    /**
		     * Deletes an existing Pet based on the provided ID.
		     *
		     * @param id the ID of the Pet to be deleted
		     */
		    @DeleteMapping("/{id}")
		    public void deletePet(@PathVariable Long id)
		    {
		    	petService.deletePet(id);
		    }
		    /**
		     * Retrieves a Pet based on the provided breed.
		     *
		     * @param breed the breed of the Pet to be retrieved
		     * @return the Pet data
		     */
		    @GetMapping("/breed")
		    public ResponseEntity<PetDTO> getByBreed(@RequestBody String breed)
		    {
		    	return ResponseEntity.ok(petService.getPetByBreed(breed));
		    }
		    /**
		     * Retrieves a Pet based on the provided age.
		     *
		     * @param age the age of the Pet to be retrieved
		     * @return the Pet data
		     */
		    @GetMapping("/location")
		    public ResponseEntity<PetDTO> getByLocation(@RequestBody String location)
		    {
		    	return ResponseEntity.ok(petService.getPetLocation(location));
		    }
		    /**
		     * Retrieves a list of Pets based on the provided user ID.
		     *
		     * @param userId the ID of the user whose Pets are to be retrieved
		     * @return the list of Pets
		     */
		    @GetMapping("/age/{age}")
		    public ResponseEntity<PetDTO> getByAge(@PathVariable Integer age)  
		    {
		    	return ResponseEntity.ok(petService.getPetByAge(age));
		    }
		    /**
		     * Handles HTTP GET requests for retrieving a list of pets associated with a specific user.
		     *
		     * @param userId the ID of the user whose pets are to be retrieved
		     * @return a ResponseEntity containing a list of PetDTO objects associated with the specified user
		     */
		    @GetMapping("/user/{userId}")
		    public ResponseEntity<List<PetDTO>> getByUserId(@PathVariable Long userId)
		    {
		    	return ResponseEntity.ok(petService.getPetByUserId(userId));
		    }
		        
	}
