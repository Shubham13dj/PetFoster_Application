package com.petfoster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petfoster.model.PetHistory;

public interface PetHistoryRepository extends JpaRepository<PetHistory, Long> {

	List<PetHistory> findByPet_PetId(Long petId);
}
