package com.chandan.security.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user-roles")
public class UserRoles {

	private int id;
	private int userId;
	private String role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userId;
	}

	public void setUserid(int userId) {
		this.userId = userId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRoles [id=" + id + ", userid=" + userId + ", role=" + role + "]";
	}

}
