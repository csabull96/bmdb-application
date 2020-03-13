package com.example.bmdb.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Media {
	private BigDecimal id;
	private String title;
	private String description;
	private LocalDate premiereDate;
	private List<Actor> cast;
	private List<Review> reviews;

	public Media(MediaBuilder mediaBuilder) {
		id = mediaBuilder.getId();
		title = mediaBuilder.getTitle();
		description = mediaBuilder.getDescription();
		premiereDate = mediaBuilder.getPremiereDate();
		cast = new ArrayList<Actor>(mediaBuilder.getCast());
		reviews = new ArrayList<Review>(mediaBuilder.getReviews());
	}
	
	public Media() {
		
	}
	
	public BigDecimal getId() {
		return id;
	}
	
	public void addReview(Review review) {
		reviews.add(review);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nMedia {")
		  .append("\n\tID: " + this.id)
		  .append("\n\tTitle: " + this.title)
		  .append("\n\tDescription: " + this.description)
		  .append("\n\tPremiere Date: " + this.premiereDate)
	      .append("\n\tCast {");
		
		for (Actor actor : cast) {
			sb.append(actor.toString());
		}
		
	    sb.append("\n\t}")
	      .append("\n\tReviews {");
	      
	    for (Review review : reviews) {
			sb.append(review.toString());
		}
	    
	    sb.append("\n\t}")
	      .append("\n}");
		
	    return sb.toString();
	}
}
