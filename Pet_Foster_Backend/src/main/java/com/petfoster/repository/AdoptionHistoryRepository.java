/**
 * AdoptionHistoryRepository is a repository interface for managing AdoptionHistory entities.
 * This interface extends JpaRepository to provide CRUD operations and query methods for the 
 * AdoptionHistory entity.
 * 
 * <p>
 *     Handles data persistence and retrieval for AdoptionHistory entities.
 * </p>
 * 
 * @package com.petfoster.repository
 * 
 * @version 1.0
 * 
 * @author Team
 * 
 */
package com.petfoster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petfoster.model.AdoptionHistory;

@Repository
public interface AdoptionHistoryRepository extends JpaRepository<AdoptionHistory, Long> {

}
