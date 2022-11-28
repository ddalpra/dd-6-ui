package org.dalpra.acme.dd4ui.user.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.dalpra.acme.dd4ui.base.EntityBase;
import org.dalpra.acme.dd4ui.base.Validity;

public class User extends EntityBase implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private String email;
	
	public String getSeverity() {
		String severity = "";
		if(getValidity().equals(Validity.valid)) {
			severity = "success";
		} else if(getValidity().equals(Validity.annulled)) {
			severity = "warning";
		} else {
			severity = "danger";
		}
		return severity;
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
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public User(LocalDateTime timestampCreation, LocalDateTime timestampUpdating, String userCreation,
			String userUpdating, Validity validity, String firstName, String lastName, LocalDate dob, String email) {
		super(timestampCreation, timestampUpdating, userCreation, userUpdating, validity);
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.email = email;
	}
	
	public User() {
		super();
	}
	
	@Override
	public String toString() {
		return "User ["
				+ "firstName=" + firstName + 
				", lastName=" + lastName + 
				", dob=" + dob + 
				", email=" + email
				+ ", id=" + getId() + 
				", timestampCreation=" + getTimestampCreation()
				+ ", timestampUpdating=" + getTimestampUpdating() + 
				", userCreation=" + getUserCreation()
				+ ", userUpdating=" + getUserUpdating() + "]";
	}
	
	
}
