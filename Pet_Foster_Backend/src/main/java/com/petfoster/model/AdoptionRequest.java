package com.petfoster.model;

import java.util.Date;

import com.petfoster.enums.util.RequestStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * Manages requests for adopting pets.
 */

@Entity
public class AdoptionRequest {

	/*
	 * adopt_request_id, user_id (adopter), pet_id, request_date, status (pending, approved, rejected)
	 */
	
	
	/*
	 * 	Submit an adoption request for a pet
	Approve/Reject adoption requests
	Transfer ownership after adoption

	 */
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="adopter_id", referencedColumnName="id")
	private User adopter;
	
	private Date requestDate;
	
	@Enumerated(EnumType.ORDINAL)
	private RequestStatus status;
	
	@ManyToOne
	@JoinColumn(name="pet_id", referencedColumnName="id")
	private Pet pet;
	
	public AdoptionRequest() {
		super();
	}

	public AdoptionRequest(Long id, User adopter, Date requestDate, RequestStatus status, Pet pet) {
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

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public void setStatus(RequestStatus status) {
		this.status = status;
	}


	public User getAdopter() {
		return adopter;
	}

	public void setAdopter(User adopter) {
		this.adopter = adopter;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public String getStatus() {
		return status.toString();
	}

	public void setStatus(String status) {
		this.status = RequestStatus.valueOf(status);
	}

	
	
	
}
