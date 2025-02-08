package com.petfoster.modelDTO;

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
	private String photoUrl;
	private String description;
    
	
	public PetDTO() {
		
	}
	
	public PetDTO(Long id, String name, String breed, String description) {
		super();
		this.id = id;
		this.name = name;
		this.breed = breed;
		this.description = description;
	
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

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
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
