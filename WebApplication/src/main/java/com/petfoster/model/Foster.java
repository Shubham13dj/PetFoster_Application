package com.petfoster.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;


@Entity
public class Foster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String contactDetails;
	
	@OneToMany(mappedBy = "foster")
	private List<Pet> pets;

//	@Version
//	private Long version;
//	
	public Long getId() {
		return id;
	}

	public Foster() {
		super();
	}

	public Foster( String name, String contactDetails, List<Pet> pets) {
		super();
	
		this.name = name;
		this.contactDetails = contactDetails;
		this.pets = pets;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}
}
