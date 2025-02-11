package com.petfoster.modelDTO;

public class PetApplicationDTO {
	   private Long id;
	    private Long petId;
	    private Long fosterId;
	    private String status;
	    private String applicantDetails;
	    
	    
	    public PetApplicationDTO(Long id, Long petId, Long fosterId, String status, String applicantDetails) {
			super();
			this.id = id;
			this.petId = petId;
			this.fosterId = fosterId;
			this.status = status;
			this.applicantDetails = applicantDetails;
		}
		public PetApplicationDTO() {
			super();
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Long getPetId() {
			return petId;
		}
		public void setPetId(Long petId) {
			this.petId = petId;
		}
		public Long getFosterId() {
			return fosterId;
		}
		public void setFosterId(Long fosterId) {
			this.fosterId = fosterId;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getApplicantDetails() {
			return applicantDetails;
		}
		public void setApplicantDetails(String applicantDetails) {
			this.applicantDetails = applicantDetails;
		}
}
