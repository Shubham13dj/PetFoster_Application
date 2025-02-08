package com.petfoster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petfoster.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

	List<Pet> findByBreed(String beed);
	List<Pet> findByAge(Integer age);
	List<Pet> findByLocation(String location);
	List<Pet> findByUserId(Long userId);
	
}
