package com.example.bmdb.domain;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class MediaBuilder {
	private String title;
	private String description;
	private Calendar premiereDate;
	private Set<Actor> cast;
	private Set<Review> reviews;
	
	public MediaBuilder() {
		cast = new HashSet<Actor>();
		reviews = new HashSet<Review>();
	}
	
	public MediaBuilder setTitle(String title) {
		this.title = title;
		return this;
	}
	
	public String getTitle() {
		return title;
	}
	
	public MediaBuilder setDescription(String description) {
		this.description = description;
		return this;
	}
	
	public String getDescription() {
		return description;
	}
	
	public MediaBuilder setPremiereDate(Calendar premiereDate) {
		this.premiereDate = premiereDate;
		return this;
	}
	
	public Calendar getPremiereDate() {
		return premiereDate;
	}
	
	public MediaBuilder addCastMember(Actor actor) {
		this.cast.add(actor);
		return this;
	}
	
	public Set<Actor> getCast() {
		return cast;
	}
	
	public MediaBuilder addReview(Review review) {
		this.reviews.add(review);
		return this;
	}
	
	public Set<Review> getReviews() {
		return reviews;
	}
	
	public Movie getMovie() {
		Media movie = new Movie(this);
		return new Movie(this);
	}
	
	public Series getSeries() {
		Series series = new Series(this);
		return new Series(this);
	}
}
