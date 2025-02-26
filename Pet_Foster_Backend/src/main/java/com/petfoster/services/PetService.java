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
/**
 * Service class for managing pets and their related operations.
 */
@Service
public class PetService {

	@Autowired
	private PetRepository petRepository;
	
	@Autowired 
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepository;
	/**
     * Retrieves a list of all pets.
     * 
     * @return a list of PetDTO objects representing all pets
     */
	@Cacheable("pets")
	public List<PetDTO> getAllPets()
	{
		List<Pet> pets = petRepository.findAll();
		
		
		return pets.stream()
				.map(pet -> modelMapper.map(pet, PetDTO.class))
				.collect(Collectors.toList());
	}
	 /**
     * Retrieves the details of a pet by its ID.
     * 
     * @param id the pet ID
     * @return a PetDTO object representing the pet
     */
	@Cacheable("pet")
	public PetDTO getPetById(Long id)
	{
		Pet pet = petRepository.findById(id).orElseThrow(()-> new RuntimeException("Pet not found"));
		return modelMapper.map(pet, PetDTO.class);
	}
	/**
     * Adds a new pet with the specified details and image file.
     * 
     * @param userId the ID of the user adding the pet
     * @param petDto the pet data transfer object containing pet details
     * @param imageFile the image file of the pet
     * @return a PetDTO object representing the added pet
     * @throws IOException if an I/O error occurs while processing the image file
     */
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
	/**
     * Updates the details of an existing pet.
     * 
     * @param id the pet ID
     * @param petDTO the pet data transfer object containing updated pet details
     * @return a PetDTO object representing the updated pet
     */
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
	 /**
     * Changes the fostered status of a pet.
     * 
     * @param id the pet ID
     * @param status the new fostered status
     */
	@Transactional
	public void changeFosteredStatus(Long id, boolean status)
	{
		Pet pet = petRepository.findById(id).orElseThrow();
		pet.setFostered(status);
		petRepository.save(pet);
	}
	
	@Autowired
	private FosterRequestService fosReqServ;
	/**
     * Deletes a pet by its ID.
     * 
     * @param id the pet ID
     */
	@Transactional
	public void deletePet(Long id)
	{
		FosterRequestDTO fosReqDto = fosReqServ.getFosterRequestByPetId(id);
		
		if(fosReqDto != null)
		fosReqServ.deleteFosterRequest((fosReqDto.getId()));
		
		petRepository.deleteById(id);
	}
	  /**
     * Converts a Pet entity to a PetDTO.
     * 
     * @param pet the Pet entity
     * @return the PetDTO object
     */
	public PetDTO convertToDTO(Pet pet) {
		
		return modelMapper.map(pet, PetDTO.class);
	}
	  /**
     * Retrieves a pet by its breed.
     * 
     * @param breed the pet breed
     * @return a PetDTO object representing the pet
     */
	public PetDTO getPetByBreed(String breed)
	{
		return modelMapper.map(petRepository.findByBreed(breed), PetDTO.class);
	}
	  /**
     * Retrieves a pet by its age.
     * 
     * @param age the pet age
     * @return a PetDTO object representing the pet
     */
	public PetDTO getPetByAge(Integer age)
	{
		return modelMapper.map(petRepository.findByAge(age), PetDTO.class);
	}
	 /**
     * Retrieves a pet by its location.
     * 
     * @param location the pet location
     * @return a PetDTO object representing the pet
     */
	public PetDTO getPetLocation(String location)
	{
		return modelMapper.map(petRepository.findByLocation(location), PetDTO.class);
	}
	 /**
     * Retrieves a list of pets belonging to a user.
     * 
     * @param userId the user ID
     * @return a list of PetDTO objects representing the user's pets
     */
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
	  /**
     * Retrieves the image data of a pet by its ID.
     * 
     * @param petId the pet ID
     * @return a byte array representing the pet's image data
     */
	public byte[] getPetImageById(Long petId) {
		Pet pet = petRepository.findById(petId).orElseThrow();
		return pet.getImageData();
	}

}
