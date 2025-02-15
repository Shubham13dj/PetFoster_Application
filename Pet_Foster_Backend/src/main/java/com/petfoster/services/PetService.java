package com.petfoster.services;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.petfoster.model.Pet;
import com.petfoster.model.User;
import com.petfoster.modelDTO.FosterRequestDTO;
import com.petfoster.modelDTO.PetDTO;
import com.petfoster.repository.PetRepository;
import com.petfoster.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class PetService {

	@Autowired
	private PetRepository petRepository;
	
	@Autowired 
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepository;
	
	

	@Cacheable("pets")
	public List<PetDTO> getAllPets()
	{
		List<Pet> pets = petRepository.findAll();
		
		
		return pets.stream()
				.map(pet -> modelMapper.map(pet, PetDTO.class))
				.collect(Collectors.toList());
	}
	
	@Cacheable("pet")
	public PetDTO getPetById(Long id)
	{
		Pet pet = petRepository.findById(id).orElseThrow(()-> new RuntimeException("Pet not found"));
		return modelMapper.map(pet, PetDTO.class);
	}
	
	@Transactional
	public PetDTO addNewPet(Long userId,PetDTO petDto, MultipartFile imageFile) throws IOException
	{
		
		Pet pet = modelMapper.map(petDto, Pet.class);
		User user = userRepository.findById((Long)userId).orElseThrow(()->new RuntimeException("User not found"));
		pet.setUser(user);
		pet.setImageName(imageFile.getOriginalFilename());
		pet.setImageType(imageFile.getContentType());
		pet.setImageData(imageFile.getBytes());
		
		pet = petRepository.save(pet);
		return modelMapper.map(pet, PetDTO.class);
	}
	
	@Transactional
	public PetDTO updatePet(Long id, PetDTO petDTO)
	{
		Pet pet = petRepository.findById(id).orElseThrow(()->new RuntimeException("Pet Not found"));
		pet.setName(petDTO.getName());
		pet.setBreed(petDTO.getBreed());
		pet.setDescription(petDTO.getDescription().toString());
		
		pet = petRepository.save(pet);
		return modelMapper.map(pet, PetDTO.class);
		
	}
	
	@Transactional
	public void changeFosteredStatus(Long id, boolean status)
	{
		Pet pet = petRepository.findById(id).orElseThrow();
		pet.setFostered(status);
		petRepository.save(pet);
	}
	
	@Autowired
	private FosterRequestService fosReqServ;
	
	@Transactional
	public void deletePet(Long id)
	{
		FosterRequestDTO fosReqDto = fosReqServ.getFosterRequestByPetId(id);
		
		if(fosReqDto != null)
		fosReqServ.deleteFosterRequest((fosReqDto.getId()));
		
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
	
	@Cacheable("users_pets")
	public List<PetDTO> getPetByUserId(Long userId)
	{
		 List<Pet> pets = petRepository.findByUserId(userId);
		 return pets.stream()
				 .map(pet-> modelMapper.map(pet, PetDTO.class))
				 .toList();
		 
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

	public byte[] getPetImageById(Long petId) {
		Pet pet = petRepository.findById(petId).orElseThrow();
		return pet.getImageData();
	}

}
