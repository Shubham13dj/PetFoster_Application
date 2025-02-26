/**
 * FosterRequestDTO is a Data Transfer Object (DTO) handling requests for fostering pets.
 * This class includes information about the request such as the foster parent, the pet, 
 * request date, status, start date, end date, and any additional notes.
 * 
 * <p>
 *     Handles requests for fostering pets.
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

import com.petfoster.enums.util.RequestStatus;

/*
 * Handles requests for fostering pets.
 */

public class FosterRequestDTO {
    /**
     * The unique identifier for the request
     */
    private long Id;
    
    /**
     * The User Data Transfer Object representing the foster parent
     */
    private UserDTO fosterParent;
    
    /**
     * The Pet Data Transfer Object
     */
    private PetDTO pet;
    
    /**
     * The date the foster request was made
     */
    private Date requestDate;
    
    /**
     * The status of the request (pending, accepted, rejected)
     */
    private RequestStatus status;
    
    /**
     * The start date for fostering
     */
    private Date startDate;
    
    /**
     * The end date for fostering
     */
    private Date endDate;
	private String notes;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public UserDTO getFosterParent() {
		return fosterParent;
	}

	public void setFosterParent(UserDTO fosterParent) {
		this.fosterParent = fosterParent;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public RequestStatus getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = RequestStatus.valueOf(status);
	}

	public FosterRequestDTO() {
		super();
	}

	public FosterRequestDTO(long id, UserDTO fosterParent, PetDTO pet, Date requestDate, RequestStatus status,
			Date startDate, Date endDate, String notes) {
		super();
		Id = id;
		this.fosterParent = fosterParent;
		this.pet = pet;
		this.requestDate = requestDate;
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
		this.notes = notes;
	}

	public PetDTO getPet() {
		return pet;
	}

	public void setPet(PetDTO pet) {
		this.pet = pet;
	}

	public void setStatus(RequestStatus status) {
		this.status = status;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	
	
}
