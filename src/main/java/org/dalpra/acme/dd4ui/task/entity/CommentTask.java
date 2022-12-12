package org.dalpra.acme.dd4ui.task.entity;

import java.time.LocalDateTime;

import org.dalpra.acme.dd4ui.base.EntityBase;
import org.dalpra.acme.dd4ui.base.Validity;

public class CommentTask extends EntityBase{
	private String comment;
	
	private Task task;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public CommentTask(LocalDateTime timestampCreation, LocalDateTime timestampUpdating, String userCreation,
			String userUpdating, Validity validity, String comment, Task task) {
		super(timestampCreation, timestampUpdating, userCreation, userUpdating, validity);
		this.comment = comment;
		this.task = task;
	}

	public CommentTask() {
	}
	
	
}
