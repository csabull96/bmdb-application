package com.example.bmdb.domain;

import java.util.List;

public class User {
	private String name;
	private String username;
	private String email;
	private String password;
	private List<Review> reviews;
	
	public String getUsername() {
		return username;
	}
}
