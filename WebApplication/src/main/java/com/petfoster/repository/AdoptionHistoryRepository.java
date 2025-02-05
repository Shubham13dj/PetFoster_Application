package com.petfoster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petfoster.model.AdoptionHistory;

@Repository
public interface AdoptionHistoryRepository extends JpaRepository<AdoptionHistory, Long> {

}
