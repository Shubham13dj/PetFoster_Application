package com.petfoster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petfoster.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

}
