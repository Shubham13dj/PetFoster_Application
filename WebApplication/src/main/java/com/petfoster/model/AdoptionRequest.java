package com.petfoster.model;

import java.util.Date;

import com.petfoster.enums.util.RequestStatus;

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

/*
 * Manages requests for adopting pets.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
	private Long adptionRequestId;
	
	@ManyToOne
	@JoinColumn(name="adoptor_id")
	private User adopter;
	
	private Date requestDate;
	
	private RequestStatus status;
	
	
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
