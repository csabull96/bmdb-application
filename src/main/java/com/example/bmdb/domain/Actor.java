package com.example.bmdb.domain;

import java.time.LocalDate;
import java.util.List;

public class Actor {
	private String name;
	private LocalDate dateOfBirth;
	private Sex sex;
	private String biography;
	private List<Media> filmography;
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nActor: {")
		  .append("\n\t Name: " + this.name)
		  .append("\n\t Date of Birth: " + this.dateOfBirth)
		  .append("\n\t Biography: " + this.biography)
		  .append("\n}");
		
		return sb.toString();
	}
}
