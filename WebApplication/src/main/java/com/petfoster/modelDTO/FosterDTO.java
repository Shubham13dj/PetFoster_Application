package com.petfoster.modelDTO;

public class FosterDTO {
	private Long id;
    private String name;
    private String contactDetails;
    
    
    public FosterDTO(Long id, String name, String contactDetails) {
		super();
		this.id = id;
		this.name = name;
		this.contactDetails = contactDetails;
	}
	public FosterDTO() {
		super();
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
	public String getContactDetails() {
		return contactDetails;
	}
	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}
}
