package com.petfoster.model;

import java.util.Date;

import com.petfoster.model.utility.MedicalRecords;

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
public class PetHistory {
	
	/*
	 * pet_id, foster_start_date, foster_end_date, shelter_id, foster_parent_id, medical_history, notes
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long historyId;
	
	@ManyToOne
	@JoinColumn(name="pet_id")
	private Pet pet;

	@ManyToOne
	@JoinColumn(name="foster_parent_id")
	private User fosterParent;
	
	private Date fosterStartDate;
	private Date fosterEndDate;
	
	public Long getHistoryId() {
		return historyId;
	}

	public void setHistoryId(Long historyId) {
		this.historyId = historyId;
	}
	

	
}
