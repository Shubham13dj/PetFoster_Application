package com.petfoster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petfoster.model.PetHistory;

@Repository
public interface PetHistoryRepository extends JpaRepository<PetHistory, Long> {

	List<PetHistory> findByPet_Id(Long petId);
}
