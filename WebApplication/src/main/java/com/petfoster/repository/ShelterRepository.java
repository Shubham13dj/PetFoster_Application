package com.petfoster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petfoster.model.Shelter;

@Repository
public interface ShelterRepository extends JpaRepository<Shelter, Long> {

	List<Shelter> findByLocation(String location);
}
