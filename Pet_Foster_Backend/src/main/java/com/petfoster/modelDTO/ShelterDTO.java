package com.petfoster.modelDTO;

public class ShelterDTO {
private Long shelterId;
	
	private String name;
	
	private String location;
	
	private Integer capacity;
	
	private String contactInfo;
	
	private Integer availablePetsCount;
	
	private Long ownerId;
	
	

	public ShelterDTO() {
		super();
	}

	public ShelterDTO(Long shelterId, String name, String location, Integer capacity, String contactInfo,
			Integer availablePetsCount, Long ownerId) {
		super();
		this.shelterId = shelterId;
		this.name = name;
		this.location = location;
		this.capacity = capacity;
		this.contactInfo = contactInfo;
		this.availablePetsCount = availablePetsCount;
		this.ownerId = ownerId;
	}

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

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	
	
}
