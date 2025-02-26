package com.petfoster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petfoster.model.User;
/**
 * UserRepository is a repository interface for managing User entities.
 * This interface extends JpaRepository to provide CRUD operations and query methods for the 
 * User entity.
 * 
 * <p>
 *     Handles data persistence and retrieval for User entities.
 * </p>
 * 
 * <p>
 *     Provides custom query methods to check if a User exists by email and to find a User by email.
 * </p>
 * 
 * @package com.petfoster.repository
 * 
 * @version 1.0
 * 
 * @author Team
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	/**
     * Check if a User exists by the provided email.
     *
     * @param email the email of the user
     * @return true if a User exists with the specified email, false otherwise
     */
	boolean existsByEmail(String email);
	/**
     * Find a User by the provided email.
     *
     * @param email the email of the user
     * @return the User entity associated with the given email
     */
	User findUserByEmail(String email);

}
