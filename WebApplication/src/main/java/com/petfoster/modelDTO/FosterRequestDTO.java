package com.petfoster.modelDTO;

import java.util.Date;

import com.petfoster.enums.util.RequestStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * Handles requests for fostering pets.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FosterRequestDTO {

	/*
	 * request_id, user_id (foster parent), pet_id, request_date, status (pending, accepted, rejected), start_date, end_date, notes
	 */
	

	private long Id;
	

	private UserDTO fosterParent;
	
	private Date requestDate;
	
	private RequestStatus status;
	
	private Date startDate;
	
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
