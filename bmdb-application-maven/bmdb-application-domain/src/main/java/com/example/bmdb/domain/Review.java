package com.example.bmdb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Review {
	
	@Id
	@GeneratedValue
	@Column(name = "review_id")
	private Long id;
	
	@ManyToOne()
	@JoinColumn(name = "media_id", referencedColumnName = "media_id")
	private Media media;
	
	@ManyToOne()
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User creator;
	
	private String text;
	
	@Enumerated(EnumType.STRING)
	private Rating rating;
		
	public Review() {};
	
	public Review(User creator, Media media, String text, Rating rating) {
		super();
		this.creator = creator;
		this.media = media;
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
