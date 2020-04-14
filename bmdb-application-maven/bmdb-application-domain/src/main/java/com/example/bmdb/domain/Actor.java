package com.example.bmdb.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Actor {
	@Id
	@GeneratedValue
	@Column(name = "actor_id")
	private Long id;
	private String name;
	@Temporal(TemporalType.DATE)
	private Calendar dateOfBirth;
	@Enumerated(EnumType.STRING)
	private Sex sex;
	private String biography;
	@OneToMany
	private List<Media> filmography;
	
	public Actor() {}
	
	public Actor(String name, Calendar dateOfBirth, Sex sex, String biography) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.sex = sex;
		this.biography = biography;
		filmography = new ArrayList<Media>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Calendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public void setFilmography(List<Media> filmography) {
		this.filmography = filmography;
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
