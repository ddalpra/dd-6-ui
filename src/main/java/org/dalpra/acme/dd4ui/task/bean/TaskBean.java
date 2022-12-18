package org.dalpra.acme.dd4ui.task.bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.dalpra.acme.dd4ui.base.Validity;
import org.dalpra.acme.dd4ui.task.entity.CommentTask;
import org.dalpra.acme.dd4ui.task.entity.Task;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.primefaces.PrimeFaces;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;

@Named
@ViewScoped
public class TaskBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Task task;

	private List<Task> taskList;

	private Task selectedTask;

	private List<Task> selectedTasks;
	
	static String BASE_URL = "http://localhost:18082/api/tasks";

	public TaskBean() {
		FacesContext fc = FacesContext.getCurrentInstance();
		task = new Task();
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public List<Task> getTaskList() {
		
        ResteasyClient client = (ResteasyClient)ClientBuilder.newClient();
        ResteasyWebTarget target = client.target(BASE_URL);
        Invocation.Builder request = target.request();
        Response response = null;
        try
        {
            response = request.get();
            taskList =response.readEntity(new GenericType<List<Task>>(){});
            System.out.println(taskList);
        }
        finally
        {
            response.close();
            client.close();
        }
		
		
		return taskList;
	}

	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}

	public Task getSelectedTask() {
		return selectedTask;
	}

	public void setSelectedTask(Task selectedTask) {
		this.selectedTask = selectedTask;
	}

	public List<Task> getSelectedTasks() {
		return selectedTasks;
	}

	public void setSelectedTasks(List<Task> selectedTasks) {
		this.selectedTasks = selectedTasks;
	}

	public void openNew() {
		selectedTask = new Task();
	}

	public void saveTask() {
		ResteasyClient client = null;
		ResteasyWebTarget target = null;
		Response response =null;
		try{
			
			client = ((ResteasyClientBuilder) ClientBuilder.newBuilder()).build();
			
			target = client.target(BASE_URL);

			
			
			System.out.println(selectedTask.getId());
			if(selectedTask.getId()==null) {
				selectedTask.setUserCreation("daniele");
				selectedTask.setUserUpdating("daniele");
				selectedTask.setTimestampCreation(LocalDateTime.now());
				selectedTask.setTimestampUpdating(LocalDateTime.now());
				selectedTask.setValidity(Validity.valid);
				selectedTask.setComments(new ArrayList<CommentTask>());
				
				System.out.println(selectedTask);
				
				response = target.request().post(Entity.entity(selectedTask, "application/json"));


			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Task Added"));

			}


		}finally{
			response.close();
			client.close();
		}
		PrimeFaces.current().executeScript("PF('manageTaskDialog').hide()");
		PrimeFaces.current().ajax().update("form:messages", "form:taskTable");


	}


}
