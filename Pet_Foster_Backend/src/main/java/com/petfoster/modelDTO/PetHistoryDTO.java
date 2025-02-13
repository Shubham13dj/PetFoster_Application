package com.petfoster.modelDTO;

import java.util.Date;

import com.petfoster.model.Shelter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PetHistoryDTO {
	
	/*
	 * pet_id, foster_start_date, foster_end_date, shelter_id, foster_parent_id, medical_history, notes
	 */
	
	private Long historyId;
	
	private PetDTO pet;
	
	
	private UserDTO fosterParent;
	
	private Date fosterStartDate;
	
	private Date fosterEndDate;
	
	private Shelter shelter;
	
	private Long medicalRecord;

	public Long getHistoryId() {
		return historyId;
	}

	public void setHistoryId(Long historyId) {
		this.historyId = historyId;
	}

	public PetDTO getPet() {
		return pet;
	}

	public void setPet(PetDTO pet) {
		this.pet = pet;
	}


	public UserDTO getFosterParent() {
		return fosterParent;
	}

	public void setFosterParent(UserDTO fosterParent) {
		this.fosterParent = fosterParent;
	}

	public Date getFosterStartDate() {
		return fosterStartDate;
	}

	public void setFosterStartDate(Date fosterStartDate) {
		this.fosterStartDate = fosterStartDate;
	}

	public Date getFosterEndDate() {
		return fosterEndDate;
	}

	public void setFosterEndDate(Date fosterEndDate) {
		this.fosterEndDate = fosterEndDate;
	}

	public Shelter getShelter() {
		return shelter;
	}

	public void setShelter(Shelter shelter) {
		this.shelter = shelter;
	}

	public Long getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(Long medicalRecord) {
		this.medicalRecord = medicalRecord;
	}

	
}
