package com.petfoster.model;

import java.util.Date;

import com.petfoster.enums.util.RequestStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;




/*
 * Handles requests for fostering pets.
 */
@Data
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
	@JoinColumn(name = "foster_parent_id", referencedColumnName = "id")
	private User fosterParent;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User parent;
	
	
	@ManyToOne
	@JoinColumn(name = "pet_id", referencedColumnName = "id")
	private Pet pet;
	
	private Date requestDate;
	
	private RequestStatus status;
	
	private Date startDate;
	
	public User getFosterParent() {
		return fosterParent;
	}

	public void setFosterParent(User fosterParent) {
		this.fosterParent = fosterParent;
	}

	

	public FosterRequest(long id, User fosterParent, User parent, Pet pet, Date requestDate, RequestStatus status,
			Date startDate, Date endDate, String notes) {
		super();
		Id = id;
		this.fosterParent = fosterParent;
		this.parent = parent;
		this.pet = pet;
		this.requestDate = requestDate;
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
		this.notes = notes;
	}

	public User getParent() {
		return parent;
	}

	public void setParent(User parent) {
		this.parent = parent;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
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

	public void setStatus(RequestStatus requestStatus) {
		this.status = requestStatus;
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

	private Date endDate;
	
	private String notes;

	public FosterRequest() {
		super();
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}
	
	
	
	
	
}
