package com.example.bmdb.domain;

public class Review {
	private Media media;
	private User creator;
	private String text;
	private Rating rating;
		
	public Review(User creator, String text, Rating rating) {
		super();
		this.creator = creator;
		this.text = text;
		this.rating = rating;
	}

	public void setMedia(Media media) {
		this.media = media;
	}
	
	public Rating getRating() {
		return rating;
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
