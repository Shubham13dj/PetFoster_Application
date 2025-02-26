package com.petfoster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petfoster.model.FosterParentAvailability;
/**
 * FosterParentAvailabilityRepository is a repository interface for managing FosterParentAvailability entities.
 * This interface extends JpaRepository to provide CRUD operations and query methods for the 
 * FosterParentAvailability entity.
 * 
 * <p>
 *     Handles data persistence and retrieval for FosterParentAvailability entities.
 * </p>
 * 
 * @package com.petfoster.repository
 * 
 * @version 1.0
 * 
 * @author Team
 */
@Repository
public interface FosterParentAvailabilityRepository extends JpaRepository<FosterParentAvailability, Long> {

}
