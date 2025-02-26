/**
 * UserDTO is a Data Transfer Object (DTO) representing a user. This class includes 
 * information about the user such as ID, name, gender, phone number, email, password,
 * role, account status, pet count, JSON token, and specialization.
 * 
 * <p>
 *     Handles the representation of users in the system.
 * </p>
 * 
 * @package com.petfoster.modelDTO
 * 
 * @version 1.0
 * 
 * @author Team
 * 
 */

package com.petfoster.modelDTO;

import com.petfoster.enums.util.UserRole;

import lombok.Getter;
import lombok.Setter;

public class UserDTO {

    /**
     * The unique identifier for the user
     */
    private long id;
    
    /**
     * The name of the user
     */
    private String name;

    /**
     * The gender of the user
     */
    private String gender;
    
    /**
     * The phone number of the user
     */
    private String phoneNumber;
    
    /**
     * The email of the user
     */
    private String email;
    
    /**
     * The password of the user
     */
    private String password;
    
    /**
     * The role of the user
     */
    private UserRole role;
    
    /**
     * Indicates whether the user's account is enabled
     */
    private boolean isEnabled;
    
    /**
     * The number of pets associated with the user
     */
    private Integer petCount;
    
    /**
     * The JSON token of the user
     */
    private String jsonToken;
    
    /**
     * The specialization of the user, marked as transient
     */
    @jakarta.persistence.Transient
    private String specialization;

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

    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Integer getPetCount() {
		return petCount;
	}

	public void setPetCount(Integer petCount) {
		this.petCount = petCount;
	}

	public String getJsonToken() {
		return jsonToken;
	}

	public void setJsonToken(String jsonToken) {
		this.jsonToken = jsonToken;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	@Override
    public String toString() {
        return "User [id=" + id + ", Name=" + name + ", gender=" + gender
                + ", phoneNumber=" + phoneNumber + ", email=" + email + ", password=" + password + ", isEnabled=" + isEnabled + "]";
    }
}
