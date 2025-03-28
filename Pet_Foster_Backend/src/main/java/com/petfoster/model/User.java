/**
 * Provides the entity classes for the Pet Foster system.
 */
package com.petfoster.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.petfoster.enums.util.UserRole;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a user in the Pet Foster system.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "user")
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

	@Enumerated(EnumType.STRING)
	private UserRole role;

	@Column(name = "is_enabled")
	private boolean isEnabled;

	private Integer petCount;

//
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL,  orphanRemoval = true)
	private Set<Pet> pets = new HashSet<>(); // A user can have many pets

	// private String jsonToken;

	@jakarta.persistence.Transient
	private String specialization;

	@Version
	private Long version;
	/**
     * Constructs a new User with specified details.
     * 
     * @param id the user ID
     * @param name the name of the user
     * @param gender the gender of the user
     * @param phoneNumber the phone number of the user
     * @param email the email of the user
     * @param password the password of the user
     * @param role the role of the user
     * @param isEnabled the enabled status of the user
     * @param petCount the number of pets the user has
     * @param specialization the specialization of the user
     * @param version the version of the entity
     */
	public User(long id, String name, String gender, String phoneNumber, String email, String password, UserRole role,
	        boolean isEnabled, Integer petCount, String specialization, Long version) {
	    super();
	    this.id = id;
	    this.name = name;
	    this.gender = gender;
	    this.phoneNumber = phoneNumber;
	    this.email = email;
	    this.password = password;
	    this.role = role;
	    this.isEnabled = isEnabled;
	    this.petCount = petCount;
//	    this.pets = pets;
	    this.specialization = specialization;
	    this.version = version;
	}

	public Long getVersion() {
	    return version;
	}

	public void setVersion(Long version) {
	    this.version = version;
	}

	public User() {
	    super();
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

//	public List<Pet> getPets() {
//	    return pets;
//	}
//
//	public void setPets(List<Pet> pets) {
//	    this.pets = pets;
//	}

	@Override
	public String toString() {
	    return "User [id=" + id + ", Name=" + name + ", gender=" + gender + ", phoneNumber=" + phoneNumber + ", email="
	            + email + ", password=" + password + ", isEnabled=" + isEnabled + "]";
	}

}
