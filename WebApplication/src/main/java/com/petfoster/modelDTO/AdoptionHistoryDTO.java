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

	/*
	 * pet_id, adopter_id, adopted_date
	 */
	
	/*
	 * 	View adoption history for pets
	 */
	
	private PetDTO pet;
	
	private UserDTO adopter;
	
	private Date adopterDate;
}
