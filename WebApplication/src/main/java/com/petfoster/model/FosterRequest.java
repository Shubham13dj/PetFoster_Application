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
 * Handles requests for fostering pets.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FosterRequest {

	/*
	 * request_id, user_id (foster parent), pet_id, request_date, status (pending, accepted, rejected), start_date, end_date, notes
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@ManyToOne
	@JoinColumn(name = "foster_patent_id")
	private User fosterParent;
	
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
	
	
	
	
	
}
