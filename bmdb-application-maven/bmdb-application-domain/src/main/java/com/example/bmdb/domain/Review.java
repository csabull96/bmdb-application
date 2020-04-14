package com.example.bmdb.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Review {
	
	@Id
	@GeneratedValue
	@Column(name = "review_id")
	private Long id;
	@OneToOne(cascade = CascadeType.ALL)
	private Media media;
	@OneToOne(cascade = CascadeType.ALL)
	private User creator;
	private String text;
	@Enumerated(EnumType.STRING)
	private Rating rating;
		
	public Review(User creator, String text, Rating rating) {
		super();
		this.creator = creator;
		this.text = text;
		this.rating = rating;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\t\tReview {")
		  .append("\n\t\t\t User: " + this.creator.getUsername())
		  .append("\n\t\t\t Text: " + this.text)
		  .append("\n\t\t\t Rating: " + this.rating)
		  .append("\n\t\t}");
		
		return sb.toString();
	}
}
