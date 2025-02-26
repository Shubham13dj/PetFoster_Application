/**
 * Provides the entity classes for the Pet Foster system.
 */
package com.petfoster.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Version;
/**
 * Represents a pet in the Pet Foster system.
 */
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
	private boolean availableToAdopt;
	private boolean availableToFoster;
	private boolean fostered;

	private String location;
	
	private String imageName;
	
	private String imageType;

	@Lob
	private byte[] imageData;

	private String description;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	@Version
	private Long version;
	
//	
	public Pet() {
		
	}
	 /**
     * Constructs a new Pet with specified details.
     * 
     * @param id the pet ID
     * @param name the name of the pet
     * @param age the age of the pet
     * @param species the species of the pet
     * @param breed the breed of the pet
     * @param healthStatus the health status of the pet
     * @param adopted whether the pet is adopted
     * @param fostered whether the pet is fostered
     * @param location the location of the pet
     * @param imageName the name of the pet's image
     * @param description the description of the pet
     * @param user the user associated with the pet
     * @param version the version of the entity
     */
	public Pet(Long id, String name, Integer age, String species, String breed, String healthStatus, boolean adopted,
			boolean fostered, String location, String photoName, String description, User user, Long version) {
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
		this.description = description;
		this.user = user;
		this.version = version;
	}
	
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

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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


	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
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
}
