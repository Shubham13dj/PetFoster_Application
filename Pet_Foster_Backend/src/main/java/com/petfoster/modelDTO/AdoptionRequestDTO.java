package com.petfoster.modelDTO;

import java.util.Date;

import com.petfoster.enums.util.RequestStatus;

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

public class AdoptionRequestDTO {

	/*
	 * adopt_request_id, user_id (adopter), pet_id, request_date, status (pending, approved, rejected)
	 */
	
	
	/*
	 * 	Submit an adoption request for a pet
	Approve/Reject adoption requests
	Transfer ownership after adoption

	 */
	
	
	private Long adptionRequestId;
	
	private UserDTO adopter;
	
	private Date requestDate;
	
	private RequestStatus status;
	
}
