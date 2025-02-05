package com.petfoster.model;

import com.petfoster.enums.util.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name= "user")
public class User {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;

	private String gender;
	@Column(name = "phone_no")
	private String phoneNumber;
	private String email;
	private String password;
	
	private UserRole role;
	
	@Column(name = "is_enabled")
	private boolean isEnabled;
	
	private Integer petCount;
	
	@jakarta.persistence.Transient
	private String specialization;

//	@Version
//	private Long version;
	
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
	public User(long id, String firstName, String lastName, String gender, String phoneNumber,
			String email, String password, String userType, boolean isEnabled, String specialization) {
		super();
		this.id = id;
		
//		this.version = version;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		
		this.isEnabled = isEnabled;
		this.specialization = specialization;
	}
	public User() {
		super();
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", Name=" + name + ", gender=" + gender
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + ", password=" + password + ", isEnabled=" + isEnabled + "]";
	}
	
	
}
