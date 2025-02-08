package com.petfoster.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petfoster.model.Pet;
import com.petfoster.modelDTO.PetDTO;
import com.petfoster.repository.AdoptionHistoryRepository;
import com.petfoster.repository.PetRepository;

import jakarta.transaction.Transactional;

@Service
public class PetService {

	@Autowired
	private PetRepository petRepository;
	
	@Autowired 
	private ModelMapper modelMapper;
	

	
	public List<PetDTO> getAllPets()
	{
		List<Pet> pets = petRepository.findAll();
		
		
		return pets.stream()
				.map(pet -> modelMapper.map(pet, PetDTO.class))
				.collect(Collectors.toList());
	}
	
	public PetDTO getPetById(Long id)
	{
		Pet pet = petRepository.findById(id).orElseThrow(()-> new RuntimeException("Pet not found"));
		return modelMapper.map(pet, PetDTO.class);
	}
	
	@Transactional
	public PetDTO addNewPet(PetDTO petDto)
	{
		
		Pet pet = modelMapper.map(petDto, Pet.class);
		pet = petRepository.save(pet);
		return modelMapper.map(pet, PetDTO.class);
	}
	
	@Transactional
	public PetDTO foster(Long id)
	{
		Pet pet = petRepository.findById(id).orElseThrow(()->new RuntimeException("Pet Not found"));
		pet.setAdopted(true);
		
		pet = petRepository.save(pet);
		return modelMapper.map(pet, PetDTO.class);
		
	}
	
	@Transactional
	public void deletePet(Long id)
	{
		petRepository.deleteById(id);
	}
	
	
	public PetDTO convertToDTO(Pet pet) {
		
		return modelMapper.map(pet, PetDTO.class);
	}
	
	public PetDTO getPetByBreed(String breed)
	{
		return modelMapper.map(petRepository.findByBreed(breed), PetDTO.class);
	}
	
	public PetDTO getPetByAge(Integer age)
	{
		return modelMapper.map(petRepository.findByAge(age), PetDTO.class);
	}
	
	public PetDTO getPetLocation(String location)
	{
		return modelMapper.map(petRepository.findByLocation(location), PetDTO.class);
	}
	
	public PetDTO getPetByUserId(Long userId)
	{
		return modelMapper.map(petRepository.findByUserId(userId), PetDTO.class);
	}
	/* Pending functionalities
	 * 
	List available pets for fostering
	Search/filter pets by criteria (age, species, location, etc.)
	Mark pet as adopted/fostered
	Upload pet photo

	*	Record and update pet’s medical and foster history
	View a pet’s previous foster details

	*
	 */

}
