package com.petfoster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petfoster.model.FosterParentAvailability;

@Repository
public interface FosterParentAvailabilityRepository extends JpaRepository<FosterParentAvailability, Long> {

}
