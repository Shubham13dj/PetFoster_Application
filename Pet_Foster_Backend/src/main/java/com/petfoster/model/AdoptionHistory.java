/**
 * Represents the adoption history of a pet. This entity is used to track the 
 * adoption details including the pet adopted, the adopter, and the date of adoption.
 */
package com.petfoster.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Lombok annotation to generate getters for all fields.
 */
@Getter
/**
 * Lombok annotation to generate setters for all fields.
 */
@Setter
/**
 * Lombok annotation to generate a no-args constructor.
 */
@NoArgsConstructor
/**
 * Lombok annotation to generate an all-args constructor.
 */
@AllArgsConstructor

/**
 * JPA annotation to indicate that this class is a JPA entity.
 */
@Entity
public class AdoptionHistory {

	/**
	 * The unique identifier for the adoption history record.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * The pet that was adopted.
	 */
	@ManyToOne
	@JoinColumn(name = "pet_id")
	private Pet pet;
	/**
	 * The user who adopted the pet.
	 */
	@ManyToOne
	@JoinColumn(name = "adopter_id")
	private User adopter;
	/**
	 * The date when the pet was adopted.
	 */
	private Date adopterDate;
}
