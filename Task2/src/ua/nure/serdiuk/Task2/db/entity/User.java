package ua.nure.serdiuk.Task2.db.entity;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = -2659332426623447768L;

	private String login;
	
	private String password;
	
	private String email;
	
	private String fullName;
	
	public User(String login, String password, String email, String fullName, String role) {
		this.login = login;
		this.password = password;
		this.email = email;
		this.fullName = fullName;
		this.role = role;
	}

	private String role;
	

	public User() {
	}

	@Override
	public String toString() {
		return "User [login=" + login + ", password=" + password + ", email=" + email + ", fullName=" + fullName
				+ ", role=" + role + "]";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
