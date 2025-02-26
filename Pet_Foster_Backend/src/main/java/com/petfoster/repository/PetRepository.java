
package com.petfoster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petfoster.model.Pet;

/**
 * PetRepository is a repository interface for managing Pet entities.
 * This interface extends JpaRepository to provide CRUD operations and query methods for the 
 * Pet entity.
 * 
 * <p>
 *     Handles data persistence and retrieval for Pet entities.
 * </p>
 * 
 * <p>
 *     Provides custom query methods to find Pet entities by breed, age, location, and user ID.
 * </p>
 * 
 * @package com.petfoster.repository
 * 
 * @version 1.0
 * 
 * @author Team
 */
@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
	/**
     * Find a list of Pet entities by the provided breed.
     *
     * @param breed the breed of the pet
     * @return a list of Pet entities with the specified breed
     */
	List<Pet> findByBreed(String beed);
	/**
     * Find a list of Pet entities by the provided age.
     *
     * @param age the age of the pet
     * @return a list of Pet entities with the specified age
     */
	List<Pet> findByAge(Integer age);
	/**
     * Find a list of Pet entities by the provided location.
     *
     * @param location the location of the pet
     * @return a list of Pet entities with the specified location
     */
	List<Pet> findByLocation(String location);
	/**
     * Find a list of Pet entities by the provided user ID.
     *
     * @param userId the ID of the user
     * @return a list of Pet entities associated with the specified user ID
     */
	List<Pet> findByUserId(Long userId);
	
}
