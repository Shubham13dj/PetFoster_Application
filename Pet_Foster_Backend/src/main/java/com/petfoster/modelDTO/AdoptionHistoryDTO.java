/**
 * AdoptionHistoryDTO is a Data Transfer Object (DTO) representing the adoption 
 * history of a pet. This class includes the pet, the adopter, and the adoption date.
 * 
 * <p>
 *     View adoption history for pets
 * </p>
 * 
 * @package com.petfoster.modelDTO
 * 
 * @version 1.0
 * 
 * @author cdac project
 * 
 */
package com.petfoster.modelDTO;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AdoptionHistoryDTO {

	/**
     * The Pet Data Transfer Object
     */
	private PetDTO pet;
	/**
     * The User Data Transfer Object representing the adopter
     */
	private UserDTO adopter;
	/**
     * The date the pet was adopted
     */
	private Date adopterDate;
}
