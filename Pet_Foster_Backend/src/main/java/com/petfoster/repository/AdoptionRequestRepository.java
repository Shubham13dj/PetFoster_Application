package com.petfoster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petfoster.model.AdoptionRequest;
/**
 * AdoptionRequestRepository is a repository interface for managing AdoptionRequest entities.
 * This interface extends JpaRepository to provide CRUD operations and query methods for the 
 * AdoptionRequest entity.
 * 
 * <p>
 *     Handles data persistence and retrieval for AdoptionRequest entities.
 * </p>
 * 
 * @package com.petfoster.repository
 * 
 * @version 1.0
 * 
 * @author Team
 */
@Repository
public interface AdoptionRequestRepository extends JpaRepository<AdoptionRequest, Long> {

}
