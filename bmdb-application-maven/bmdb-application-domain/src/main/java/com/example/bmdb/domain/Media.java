package com.example.bmdb.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Inheritance
@DiscriminatorColumn(name = "MEDIA_TYPE")
public abstract class Media {
	
	@Id
	@GeneratedValue
	@Column(name = "media_id")
	private Long id;
	
	// has to be replaced
	@Transient
	private BigDecimal bdid;
	private String title;
	private String description;
	@Temporal(TemporalType.DATE)
	private Calendar premiereDate;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Actor> cast;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Review> reviews;

	public Media(MediaBuilder mediaBuilder) {
		bdid = mediaBuilder.getId();
		title = mediaBuilder.getTitle();
		description = mediaBuilder.getDescription();
		premiereDate = mediaBuilder.getPremiereDate();
		cast = new ArrayList<Actor>(mediaBuilder.getCast());
		reviews = new ArrayList<Review>(mediaBuilder.getReviews());
	}
	
	public Media() {
		
	}
	
	public BigDecimal getBdid() {
		return bdid;
	}

	public void setBdid(BigDecimal bdid) {
		this.bdid = bdid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar getPremiereDate() {
		return premiereDate;
	}

	public void setPremiereDate(Calendar premiereDate) {
		this.premiereDate = premiereDate;
	}

	public List<Actor> getCast() {
		return cast;
	}

	public void setCast(List<Actor> cast) {
		this.cast = cast;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getId() {
		return bdid;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void addReview(Review review) {
		reviews.add(review);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Media {")
		  .append("\n\tID: " + this.bdid)
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
	      .append("\n}\n");
		
	    return sb.toString();
	}
}
