package com.example.bmdb.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MediaBuilder {
	private BigDecimal id;
	private String title;
	private String description;
	private LocalDate premiereDate;
	private List<Actor> cast;
	private List<Review> reviews;
	
	public MediaBuilder() {
		cast = new ArrayList<Actor>();
		reviews = new ArrayList<Review>();
	}
	
	public MediaBuilder setId(BigDecimal id) {
		this.id = id;
		return this;
	}
	
	public BigDecimal getId() {
		return id;
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
	
	public MediaBuilder setPremiereDate(LocalDate premiereDate) {
		this.premiereDate = premiereDate;
		return this;
	}
	
	public LocalDate getPremiereDate() {
		return premiereDate;
	}
	
	public MediaBuilder addCastMember(Actor actor) {
		this.cast.add(actor);
		return this;
	}
	
	public List<Actor> getCast() {
		return cast;
	}
	
	public MediaBuilder addReview(Review review) {
		this.reviews.add(review);
		return this;
	}
	
	public List<Review> getReviews() {
		return reviews;
	}
	
	public Movie getMovie() {
		Media movie = new Movie(this);	
		establishRelations(movie);
		return new Movie(this);
	}
	
	public Series getSeries() {
		Series series = new Series(this);	
		establishRelations(series);
		return new Series(this);
	}
	
	private void establishRelations(Media media) {
		for (Actor actor : cast) {
			actor.getFilmography().add(media);
		}
		for (Review review : reviews) {
			review.setMedia(media);
		}
	}
}
