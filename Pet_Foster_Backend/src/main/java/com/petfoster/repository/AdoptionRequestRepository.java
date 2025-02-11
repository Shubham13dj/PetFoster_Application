package com.petfoster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petfoster.model.AdoptionRequest;

@Repository
public interface AdoptionRequestRepository extends JpaRepository<AdoptionRequest, Long> {

}
