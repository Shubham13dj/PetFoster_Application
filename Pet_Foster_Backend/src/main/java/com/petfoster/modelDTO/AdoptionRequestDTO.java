package com.petfoster.modelDTO;

import java.util.Date;

import com.petfoster.enums.util.RequestStatus;
/**
 * Data Transfer Object (DTO) for managing adoption requests for pets.
 * This class encapsulates the necessary information for an adoption request.
 */
public class AdoptionRequestDTO {

	/*
	 * adopt_request_id, user_id (adopter), pet_id, request_date, status (pending, approved, rejected)
	 */
	
	
	/*
	 * 	Submit an adoption request for a pet
	Approve/Reject adoption requests
	Transfer ownership after adoption

	 */
	
	 /**
     * The unique identifier of the adoption request.
     */
	private Long id;
	 /**
     * The unique identifier of the adopter.
     */
	private Long adopter;
	/**
     * The date the adoption request was submitted.
     */
	private Date requestDate;
	/**
     * The status of the adoption request (pending, approved, rejected).
     */
	private RequestStatus status;
	/**
     * The unique identifier of the pet to be adopted.
     */
	private Long pet;
	/**
     * Default constructor.
     */
	public AdoptionRequestDTO() {
		super();
	}
	 /**
     * Parameterized constructor to initialize all fields.
     * 
     * @param id the unique identifier of the adoption request
     * @param adopter the unique identifier of the adopter
     * @param requestDate the date the adoption request was submitted
     * @param status the status of the adoption request (pending, approved, rejected)
     * @param pet the unique identifier of the pet to be adopted
     */
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
