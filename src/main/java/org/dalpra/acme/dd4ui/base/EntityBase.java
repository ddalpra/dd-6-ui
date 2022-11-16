package org.dalpra.acme.dd4ui.base;

import java.time.LocalDateTime;
import java.util.UUID;


public class EntityBase {
	private UUID id;
	private LocalDateTime timestampCreation;
	private LocalDateTime timestampUpdating;
	private String userCreation;
	private String userUpdating;
	
	public EntityBase(LocalDateTime timestampCreation, LocalDateTime timestampUpdating, String userCreation,
			String userUpdating) {
		this.timestampCreation = timestampCreation;
		this.timestampUpdating = timestampUpdating;
		this.userCreation = userCreation;
		this.userUpdating = userUpdating;
	}

	public EntityBase() {
		
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public LocalDateTime getTimestampCreation() {
		return timestampCreation;
	}

	public void setTimestampCreation(LocalDateTime timestampCreation) {
		this.timestampCreation = timestampCreation;
	}

	public LocalDateTime getTimestampUpdating() {
		return timestampUpdating;
	}

	public void setTimestampUpdating(LocalDateTime timestampUpdating) {
		this.timestampUpdating = timestampUpdating;
	}

	public String getUserCreation() {
		return userCreation;
	}

	public void setUserCreation(String userCreation) {
		this.userCreation = userCreation;
	}

	public String getUserUpdating() {
		return userUpdating;
	}

	public void setUserUpdating(String userUpdating) {
		this.userUpdating = userUpdating;
	}
}
