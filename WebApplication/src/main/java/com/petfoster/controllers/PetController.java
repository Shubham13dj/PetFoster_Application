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

import com.petfoster.modelDTO.PetDTO;
import com.petfoster.services.PetService;
	
	
	@RestController
	@CrossOrigin(origins = "http://localhost:3000")
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
		     
		    @PostMapping
		    public PetDTO addNewPet(@RequestBody PetDTO petDTO)
		    {
		    	return petService.addNewPet(petDTO);
		    }
		    
		    @PatchMapping("/{id}")
		    public PetDTO fosterPet(@PathVariable Long id)
		    {
		    	return petService.foster(id);
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
		    
		    @GetMapping("/{age}")
		    public ResponseEntity<PetDTO> getByAge(@PathVariable Integer age)  
		    {
		    	return ResponseEntity.ok(petService.getPetByAge(age));
		    }
		    
		    /*
		     * 
		     */
		    
		    
		    
	}
