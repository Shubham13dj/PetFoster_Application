/**
 * PetHistoryDTO is a Data Transfer Object (DTO) representing the history of a pet's 
 * fostering. This class includes information about the pet, foster parent, 
 * foster start and end dates, medical records, and additional notes.
 * 
 * <p>
 *     Handles the representation of a pet's fostering history in the system.
 * </p>
 * 
 * @package com.petfoster.modelDTO
 * 
 * @version 1.0
 * 
 * @author Team
 * 
 */
package com.petfoster.modelDTO;

import java.util.Date;


public class PetHistoryDTO {

    /**
     * The unique identifier for the history record
     */
    private Long historyId;
    
    /**
     * The Pet Data Transfer Object
     */
    private PetDTO pet;
    
    /**
     * The User Data Transfer Object representing the foster parent
     */
    private UserDTO fosterParent;
    
    /**
     * The start date of the fostering period
     */
    private Date fosterStartDate;
    
    /**
     * The end date of the fostering period
     */
    private Date fosterEndDate;
    
    /**
     * The medical record ID associated with the pet
     */
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


	public Long getMedicalRecord() {
		return medicalRecord;
	}


	public void setMedicalRecord(Long medicalRecord) {
		this.medicalRecord = medicalRecord;
	}

	
	
}
