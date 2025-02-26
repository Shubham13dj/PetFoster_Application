package com.petfoster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petfoster.model.utility.MedicalRecords;
/**
 * MedicalRecordsRepository is a repository interface for managing MedicalRecords entities.
 * This interface extends JpaRepository to provide CRUD operations and query methods for the 
 * MedicalRecords entity.
 * 
 * <p>
 *     Handles data persistence and retrieval for MedicalRecords entities.
 * </p>
 * 
 * @package com.petfoster.repository
 * 
 * @version 1.0
 * 
 * @author Team
 */
@Repository
public interface MedicalRecordsRepository extends JpaRepository<MedicalRecords, Long> {

}
