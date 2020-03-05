package com.example.bmdb.domain;

public class Review {
	private User creator;
	private String text;
	private Rating rating;
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nReview: {")
		  .append("\n\t User: " + this.creator.getUsername())
		  .append("\n\t Text: " + this.text)
		  .append("\n\t Rating: " + this.rating)
		  .append("\n}");
		
		return sb.toString();
	}
}
