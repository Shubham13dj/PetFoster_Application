package com.petfoster.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

	/*
	 * shelter_id, name, location, capacity, contact_info, available_pets_count
	 */

	/*
	 *	Add and update shelter details
	List pets in the shelter
	Assign pets to foster homes
 
	 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Shelter {

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
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
