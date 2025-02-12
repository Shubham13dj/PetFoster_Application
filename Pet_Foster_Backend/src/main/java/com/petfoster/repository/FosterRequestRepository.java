package com.petfoster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petfoster.model.FosterRequest;

@Repository
public interface FosterRequestRepository extends JpaRepository<FosterRequest, Long> {
	
	FosterRequest findByPetId(Long petId);
}
