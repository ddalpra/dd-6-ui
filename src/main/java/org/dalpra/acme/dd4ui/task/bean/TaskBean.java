package org.dalpra.acme.dd4ui.task.bean;

import java.io.Serializable;
import java.util.List;

import org.dalpra.acme.dd4ui.task.entity.Task;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
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
	
	private transient Client client;
	static String BASE_URL = "http://localhost:18082/";
	
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
		ResteasyClient client = (ResteasyClient) ClientBuilder.newClient();
        ResteasyWebTarget target = client.target(BASE_URL+"api/tasks");
        Invocation.Builder request = target.request();
        Response response = null;
        try{
            response = request.get();
            taskList = response.readEntity(new GenericType<List<Task>>() {});
            
        }finally{
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
	
	
}
