package com.petfoster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petfoster.model.FosterRequest;
/**
 * FosterRequestRepository is a repository interface for managing FosterRequest entities.
 * This interface extends JpaRepository to provide CRUD operations and query methods for the 
 * FosterRequest entity.
 * 
 * <p>
 *     Handles data persistence and retrieval for FosterRequest entities.
 * </p>
 * 
 * <p>
 *     Provides custom query method to find a FosterRequest by petId.
 * </p>
 * 
 * @package com.petfoster.repository
 * 
 * @version 1.0
 * 
 * @author Team
 */
@Repository
public interface FosterRequestRepository extends JpaRepository<FosterRequest, Long> {
	/**
     * Find a FosterRequest by the provided petId.
     *
     * @param petId the ID of the pet
     * @return the FosterRequest entity associated with the given petId
     */
	FosterRequest findByPetId(Long petId);
}
