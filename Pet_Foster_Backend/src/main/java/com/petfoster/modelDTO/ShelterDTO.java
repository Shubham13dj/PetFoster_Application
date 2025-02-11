package com.petfoster.modelDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShelterDTO {
	/*
	 * shelter_id, name, location, capacity, contact_info, available_pets_count
	 */

	/*
	 *	Add and update shelter details
	List pets in the shelter
	Assign pets to foster homes
 
	 */
	

	private Long shelterId;
	
	private String name;
	
	private String location;
	
	private Integer capacity;
	
	private String contactInfo;
	
	private Integer availablePetsCount;

	public Long getShelterId() {
		return shelterId;
	}

	public void setShelterId(Long shelterId) {
		this.shelterId = shelterId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public Integer getAvailablePetsCount() {
		return availablePetsCount;
	}

	public void setAvailablePetsCount(Integer availablePetsCount) {
		this.availablePetsCount = availablePetsCount;
	}
	
	
}
