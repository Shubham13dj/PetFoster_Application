package com.petfoster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petfoster.model.PetHistory;
/**
 * PetHistoryRepository is a repository interface for managing PetHistory entities.
 * This interface extends JpaRepository to provide CRUD operations and query methods for the 
 * PetHistory entity.
 * 
 * <p>
 *     Handles data persistence and retrieval for PetHistory entities.
 * </p>
 * 
 * <p>
 *     Provides custom query method to find PetHistory by petId.
 * </p>
 * 
 * @package com.petfoster.repository
 * 
 * @version 1.0
 * 
 * @author Team
 */
@Repository
public interface PetHistoryRepository extends JpaRepository<PetHistory, Long> {
	/**
     * Find a list of PetHistory entities by the provided petId.
     *
     * @param petId the ID of the pet
     * @return a list of PetHistory entities associated with the given petId
     */
	List<PetHistory> findByPet_Id(Long petId);
}
