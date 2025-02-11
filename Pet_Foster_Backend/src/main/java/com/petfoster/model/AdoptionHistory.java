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


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AdoptionHistory {

	/*
	 * pet_id, adopter_id, adopted_date
	 */
	
	/*
	 * 	View adoption history for pets
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="pet_id")
	private Pet pet;
	
	@ManyToOne
	@JoinColumn(name="adopter_id")
	private User adopter;
	
	private Date adopterDate;
}
