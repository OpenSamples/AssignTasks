package entities;

import java.util.List;

public class Role {

	private String name;
	private List<User> users;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public Role(String name, List<User> users) {
		this.name = name;
		this.users = users;
	}
	
	public Role() {}
	
	public Role(String name) {
		this.name = name;
	}
	
	
}
