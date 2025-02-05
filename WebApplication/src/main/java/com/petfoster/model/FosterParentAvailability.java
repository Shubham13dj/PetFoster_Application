package com.petfoster.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * Allows foster parents to indicate their availability.
 */

@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FosterParentAvailability {
	
	/*
	 * : user_id, available_from_date, available_to_date, pet_type_preference
	 */

	/*
	 * o	Functionalities:
	Set availability for fostering
	Set preferences (e.g., certain pet types, ages)

	 */
	
	public User getFosterParent() {
		return fosterParent;
	}
	public void setFosterParent(User fosterParent) {
		this.fosterParent = fosterParent;
	}
	public Date getAvailabelFromDate() {
		return availabelFromDate;
	}
	public void setAvailabelFromDate(Date availabelFromDate) {
		this.availabelFromDate = availabelFromDate;
	}
	public Date getAvailabelTillDate() {
		return availabelTillDate;
	}
	public void setAvailabelTillDate(Date availabelTillDate) {
		this.availabelTillDate = availabelTillDate;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "foster_parent_id")
	private User fosterParent;
	
	private Date availabelFromDate;
	private Date availabelTillDate;
	
	
	
}
