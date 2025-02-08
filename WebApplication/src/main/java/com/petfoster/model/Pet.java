package com.petfoster.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Version;


@Entity
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@Version
	private Long version;
	
	public Pet() {
		
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



	public Long getVersion() {
		return version;
	}



	public void setVersion(Long version) {
		this.version = version;
	}



	public Pet(Long id, String name, String breed, String description, User user, Long version) {
		super();
		this.id = id;
		this.name = name;
		this.breed = breed;
		this.description = description;
		this.user = user;
		this.version = version;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public Foster getFoster() {
//		return foster;
//	}
//
//	public void setFoster(Foster foster) {
//		this.foster = foster;
//	}

	
}
