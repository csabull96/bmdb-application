package com.example.bmdb.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public abstract class Media {
	private BigDecimal id;
	private String title;
	private String description;
	private LocalDate premiereDate;
	private List<Actor> cast;
	private List<Review> reviews;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nMedia {")
		  .append("\n\tID: " + this.id)
		  .append("\n\t Title: " + this.title)
		  .append("\n\t Description: " + this.description)
		  .append("\n\t Premiere Date: " + this.premiereDate)
	      .append("\n\t Cast: {");
		
		for (Actor actor : cast) {
			sb.append(actor.toString());
		}
		
	    sb.append("\n\t}")
	      .append("\n\t Reviews: {");
	      
	    for (Review review : reviews) {
			sb.append(review.toString());
		}
	    
	    sb.append("\n\t}" + this)
	      .append("\n}");
		
	    return sb.toString();
	}
}
