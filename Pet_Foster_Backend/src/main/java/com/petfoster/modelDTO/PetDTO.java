package com.petfoster.modelDTO;

import com.petfoster.model.User;

import jakarta.persistence.Lob;

public class PetDTO {
	
	
	private Long id;
	private String name;
	private Integer age;
	private String species;
	private String breed;
	private String healthStatus;
	private boolean adopted;
	private boolean fostered;
	private String location;
	
	private String imageName;
	private String imageType;
	
	@Lob
	private byte[] imageData;
	
	private String description;
    
	private User user;
	
	private boolean availableToAdopt;
	private boolean availableToFoster;
	
	public boolean isAvailableToAdopt() {
		return availableToAdopt;
	}

	public void setAvailableToAdopt(boolean availableToAdopt) {
		this.availableToAdopt = availableToAdopt;
	}

	public boolean isAvailableToFoster() {
		return availableToFoster;
	}

	public void setAvailableToFoster(boolean availableToFoster) {
		this.availableToFoster = availableToFoster;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PetDTO() {
		
	}
	
	public PetDTO(Long id, String name, Integer age, String species, String breed, String healthStatus, boolean adopted,
			boolean fostered, String location, String imageName, String imageType, byte[] imageData, String description,
			User user, boolean availableToAdopt, boolean availableToFoster) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.species = species;
		this.breed = breed;
		this.healthStatus = healthStatus;
		this.adopted = adopted;
		this.fostered = fostered;
		this.location = location;
		this.imageName = imageName;
		this.imageType = imageType;
		this.imageData = imageData;
		this.description = description;
		this.user = user;
		this.availableToAdopt = availableToAdopt;
		this.availableToFoster = availableToFoster;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getHealthStatus() {
		return healthStatus;
	}

	public void setHealthStatus(String healthStatus) {
		this.healthStatus = healthStatus;
	}

	public boolean isAdopted() {
		return adopted;
	}

	public void setAdopted(boolean adopted) {
		this.adopted = adopted;
	}

	public boolean isFostered() {
		return fostered;
	}

	public void setFostered(boolean fostered) {
		this.fostered = fostered;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	
	
}
