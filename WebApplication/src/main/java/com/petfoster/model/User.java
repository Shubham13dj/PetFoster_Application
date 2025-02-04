package com.petfoster.model;

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
	@Column(name = "firstname")
	private String firstName;
	@Column(name = "lastname")
	private String lastName;
	
	@Version
	private Long version;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public boolean isEnabled() {
		return isEnabled;
	}
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	@Column(name = "gender")
	private String gender;
	@Column(name = "phoneno")
	private String phoneNumber;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	public User(long id, String firstName, String lastName, Long version, String gender, String phoneNumber,
			String email, String password, String userType, boolean isEnabled, String specialization) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.version = version;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.userType = userType;
		this.isEnabled = isEnabled;
		this.specialization = specialization;
	}
	public User() {
		super();
	}
	@Column(name = "usertype")
	private String userType;
	@Column(name = "isenabled")
	private boolean isEnabled;
	
	@jakarta.persistence.Transient
	private String specialization;

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + ", password=" + password + ", userType="
				+ userType + ", isEnabled=" + isEnabled + "]";
	}
	
	
}
