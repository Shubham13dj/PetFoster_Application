package com.petfoster.modelDTO;

public class PetDTO {
	
	
	private Long id;
    private String name;
    private String breed;
    private String description;
    private String status;
    
	
	public PetDTO() {
		
	}
	
	public PetDTO(Long id, String name, String breed, String description, String status) {
		super();
		this.id = id;
		this.name = name;
		this.breed = breed;
		this.description = description;
		this.status = status;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	
	
}
