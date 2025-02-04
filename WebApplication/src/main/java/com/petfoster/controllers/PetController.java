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
	
	import com.petfoster.modelDTO.PetDTO;
	import com.petfoster.services.PetService;
	
	
	@RestController
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
		    
		    /*
		     * 
		     */
		    
		    
		    
	}
