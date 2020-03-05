package com.example.bmdb.domain;

import java.util.List;

public class User {
	private String name;
	private String username;
	private String email;
	private String password;
	private List<Review> reviews;
	
	public User(String name, String username, String email, String password) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
}
