package org.dalpra.acme.dd4ui.user.bean;

import java.io.Serializable;
import java.util.List;

import org.dalpra.acme.dd4ui.user.entity.User;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;

@Named
@ViewScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = 4537406924600704639L;
	private List<User> userList;
	private User selectedUser;
	private List<User> selectedUsers;
	@Inject
	private User user;
	private transient Client client;
	static String BASE_URL = "http://localhost:18082/";


	public UserBean() {
		FacesContext fc = FacesContext.getCurrentInstance();
		user = new User();
	}

	public List<User> getUserList() {
		ResteasyClient client = (ResteasyClient) ClientBuilder.newClient();
        ResteasyWebTarget target = client.target(BASE_URL+"api/users");
        Invocation.Builder request = target.request();
        Response response = null;
        try{
            response = request.get();
            userList = response.readEntity(new GenericType<List<User>>() {});

        }finally{
            response.close();
            client.close();
        }

        return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getSelectedUsers() {
		return selectedUsers;
	}

	public void setSelectedUsers(List<User> selectedUsers) {
		this.selectedUsers = selectedUsers;
	}

	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}
}
