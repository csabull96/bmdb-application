package com.example.bmdb.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Actor {
	private String name;
	private LocalDate dateOfBirth;
	private Sex sex;
	private String biography;
	private List<Media> filmography;
	
	public Actor(String name, LocalDate dateOfBirth, Sex sex, String biography) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.sex = sex;
		this.biography = biography;
		filmography = new ArrayList<Media>();
	}
	
	public List<Media> getFilmography() {
		return filmography;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\t\tActor {")
		  .append("\n\t\t\t Name: " + this.name)
		  .append("\n\t\t\t Date of Birth: " + this.dateOfBirth)
		  .append("\n\t\t\t Biography: " + this.biography)
		  .append("\n\t\t}");
		
		return sb.toString();
	}
}
