package com.petfoster.modelDTO;

import java.util.Date;

import com.petfoster.enums.util.RequestStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * Manages requests for adopting pets.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AdoptionRequestDTO {

	/*
	 * adopt_request_id, user_id (adopter), pet_id, request_date, status (pending, approved, rejected)
	 */
	
	
	/*
	 * 	Submit an adoption request for a pet
	Approve/Reject adoption requests
	Transfer ownership after adoption

	 */
	
	
	private Long id;
	
	private Long adopter;
	
	private Date requestDate;
	
	private RequestStatus status;
	
	private Long pet;
	
	

	public AdoptionRequestDTO() {
		super();
	}


	public AdoptionRequestDTO(Long id, Long adopter, Date requestDate, RequestStatus status, Long pet) {
		super();
		this.id = id;
		this.adopter = adopter;
		this.requestDate = requestDate;
		this.status = status;
		this.pet = pet;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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


	public Long getAdopter() {
		return adopter;
	}


	public void setAdopter(Long adopter) {
		this.adopter = adopter;
	}


	public Long getPet() {
		return pet;
	}


	public void setPet(Long pet) {
		this.pet = pet;
	}

	
	
	
	
}
