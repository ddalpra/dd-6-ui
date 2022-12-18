package org.dalpra.acme.dd4ui.task.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.dalpra.acme.dd4ui.base.EntityBase;
import org.dalpra.acme.dd4ui.base.Validity;

public class Task extends EntityBase implements Serializable {

	private static final long serialVersionUID = 1L;

	private String description;
	
	private List<CommentTask> comments = new ArrayList<CommentTask>();

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

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
	
	public List<CommentTask> getComments() {
		return comments;
	}

	public void setComments(List<CommentTask> comments) {
		this.comments = comments;
	}

	public Task(LocalDateTime timestampCreation, LocalDateTime timestampUpdating, String userCreation,
			String userUpdating, Validity validity, String description, List<CommentTask> comments) {
		super(timestampCreation, timestampUpdating, userCreation, userUpdating, validity);
		this.description = description;
		this.comments = comments;
	}

	public Task() {
	}
	
	@Override
	public String toString() {
		return "Task [description=" + description + ", comments=" + comments + ", id=" + getId()
				+ ", getTimestampCreation()=" + getTimestampCreation() + ", getTimestampUpdating()="
				+ getTimestampUpdating() + ", getUserCreation()=" + getUserCreation() + ", getUserUpdating()="
				+ getUserUpdating() + "]";
	}
}
