package com.petfoster.modelDTO;

import com.petfoster.enums.util.UserRole;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDTO {

	private long id;
	
	private String name;

	private String gender;
	
	private String phoneNumber;
	
	private String email;
	
	private String password;
	
	private UserRole role;
	
	private boolean isEnabled;
	
	private Integer petCount;
	
	private String jsonToken;
	
	@jakarta.persistence.Transient
	private String specialization;

//	@Version
//	private Long version;
	public UserDTO(long id, String name, String gender, String phoneNumber, String email, String password,
			String role, boolean isEnabled, Integer petCount, String jsonToken, String specialization) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.role = UserRole.valueOf(role.toUpperCase());
		this.isEnabled = isEnabled;
		this.petCount = petCount;
		this.jsonToken = jsonToken;
		this.specialization = specialization;
	}
	public UserDTO() {
		super();
	}
	
	
	public String getJsonToken() {
		return jsonToken;
	}
	public void setJsonToken(String jsonToken) {
		this.jsonToken = jsonToken;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public UserRole getRole() {
		return role;
	}
	public void setRole(UserRole role) {
		this.role = role;
	}
	public Integer getPetCount() {
		return petCount;
	}
	public void setPetCount(Integer petCount) {
		this.petCount = petCount;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isEnabled() {
		return isEnabled;
	}
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	

	@Override
	public String toString() {
		return "User [id=" + id + ", Name=" + name + ", gender=" + gender
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + ", password=" + password + ", isEnabled=" + isEnabled + "]";
	}
	
	
}
