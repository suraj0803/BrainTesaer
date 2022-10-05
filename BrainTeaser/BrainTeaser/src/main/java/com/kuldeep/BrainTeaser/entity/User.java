package com.kuldeep.BrainTeaser.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	private String fname;
	private String lname;
	@Id
	private String email;
	private String username;
	private String password;
	private String securityQuestion;
	private String securityAnswer;
	private boolean loggedIn; 
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String fname, String lname, String email, String username, String password, String securityQuestion,
			String securityAnswer, boolean loggedIn) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.username = username;
		this.password = password;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
		this.loggedIn = loggedIn;
	}

	@Override
	public String toString() {
		return "User [fname=" + fname + ", lname=" + lname + ", email=" + email + ", username=" + username
				+ ", password=" + password + ", securityQuestion=" + securityQuestion + ", securityAnswer="
				+ securityAnswer + ", loggedIn=" + loggedIn + "]";
	}



	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	
}
