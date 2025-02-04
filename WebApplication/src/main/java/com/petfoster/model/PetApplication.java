package com.petfoster.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;


@Entity
public class PetApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long petId;
	private Long fosterId;
	private String status; // Pending, Approved, Rejected
	private String applicantDetails;
	
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPetId() {
		return petId;
	}
	public void setPetId(Long petId) {
		this.petId = petId;
	}
	public PetApplication(Long id, Long petId, Long fosterId, String status, String applicantDetails) {
		super();
		this.id = id;
		this.petId = petId;
		this.fosterId = fosterId;
		this.status = status;
		this.applicantDetails = applicantDetails;
		//this.version = version;
	}
	public Long getFosterId() {
		return fosterId;
	}
	public void setFosterId(Long fosterId) {
		this.fosterId = fosterId;
	}
	public String getStatus() {
		return status;
	}
	public PetApplication() {
		super();
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getApplicantDetails() {
		return applicantDetails;
	}
	public void setApplicantDetails(String applicantDetails) {
		this.applicantDetails = applicantDetails;
	}
//    @Version
//	private Long version;
}