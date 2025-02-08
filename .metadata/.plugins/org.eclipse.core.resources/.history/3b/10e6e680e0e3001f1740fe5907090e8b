package com.petfoster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petfoster.model.Shelter;

public interface ShelterRepository extends JpaRepository<Shelter, Long> {

	List<Shelter> findByLocation(String location);
}
