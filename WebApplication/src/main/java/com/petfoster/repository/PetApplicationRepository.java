package com.petfoster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petfoster.model.PetApplication;

@Repository
public interface PetApplicationRepository extends JpaRepository<PetApplication, Long>{

}
