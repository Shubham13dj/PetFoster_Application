package com.petfoster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petfoster.model.Foster;

@Repository
public interface FosterRepository extends JpaRepository<Foster, Long> {

}
