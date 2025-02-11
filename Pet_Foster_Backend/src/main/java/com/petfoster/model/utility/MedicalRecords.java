package com.petfoster.model.utility;

import java.util.Date;

import com.petfoster.model.Pet;

import jakarta.persistence.Entity;
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
public class MedicalRecords {
	
	/*
	 * o	Attributes: pet_id, record_id, vet_name, vet_contact, visit_date, diagnosis, treatment, medications
o	Functionalities:
	Add and update pet medical records
	View medical history of pets

	 */
	
	@Id
	private Long recordId;
	
	@ManyToOne
	@JoinColumn(name="pet_id")
	private Pet pet;
	
	private String vetName;
	private String vetContactDetails;
	private Date visitDate;
	private String diagnosis;
	private String treatment;
	private String medication;
	

}
