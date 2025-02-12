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
	
	
	@RestController
	@CrossOrigin    
	@RequestMapping("/pets")
	public class PetController {
	
		 	@Autowired
		    private PetService petService;
		 	
		 	@GetMapping("/random")
		 	public String giveImpl() {
		 		return "Hello I am Random";
		 	}
	
		    @GetMapping("/{id}")
		    public PetDTO getPetById(@PathVariable Long id) {
		       return petService.getPetById(id);
		    }
		    
		    @GetMapping
		    public List<PetDTO> getAllPets()
		    {
		    	return petService.getAllPets();
		    }
		     
		    @GetMapping("/img/{id}")
		    public ResponseEntity<byte []> getImageById(@PathVariable int petId)
		    {
		    	return ResponseEntity.status(200)
		    			.contentType(MediaType.valueOf(petService.getPetById(Long.valueOf(petId)).getImageType()))
		    			.body(petService.getPetImageById(Long.valueOf(petId)));
		    }
		    
		    @PostMapping("/{userId}")
		    public ResponseEntity<PetDTO> addNewPet(@PathVariable Long userId,@RequestPart("petDetails") PetDTO petDTO, @RequestPart("imageData") MultipartFile imageFile)
		    {
		    	try {
					return ResponseEntity.status(HttpStatus.CREATED).body(petService.addNewPet(userId ,petDTO, imageFile));
				} catch (IOException e) {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
				}
		    }
		    
		    @PutMapping("/{id}")
		    public PetDTO updatePet(@PathVariable Long id, @RequestBody PetDTO petDTO)
		    {
		    	return petService.updatePet(id, petDTO);
		    }
		    
		    @DeleteMapping("/{id}")
		    public void deletePet(@PathVariable Long id)
		    {
		    	petService.deletePet(id);
		    }
		    
		    @GetMapping("/breed")
		    public ResponseEntity<PetDTO> getByBreed(@RequestBody String breed)
		    {
		    	return ResponseEntity.ok(petService.getPetByBreed(breed));
		    }
		    
		    @GetMapping("/location")
		    public ResponseEntity<PetDTO> getByLocation(@RequestBody String location)
		    {
		    	return ResponseEntity.ok(petService.getPetLocation(location));
		    }
		    
		    @GetMapping("/age/{age}")
		    public ResponseEntity<PetDTO> getByAge(@PathVariable Integer age)  
		    {
		    	return ResponseEntity.ok(petService.getPetByAge(age));
		    }
		    @GetMapping("/user/{userId}")
		    public ResponseEntity<List<PetDTO>> getByUserId(@PathVariable Long userId)
		    {
		    	return ResponseEntity.ok(petService.getPetByUserId(userId));
		    }
		    
		    /*
		     * 
		     */
		    
		    
		    
	}
