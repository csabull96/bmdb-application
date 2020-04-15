package com.example.bmdb.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance
@DiscriminatorColumn(name = "MEDIA_TYPE")
public abstract class Media {
	
	@Id
	@GeneratedValue
	@Column(name = "media_id")
	private Long id;

	private String title;
	
	private String description;
	
	@Temporal(TemporalType.DATE)
	private Calendar premiereDate;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "media_cast",
		joinColumns = @JoinColumn(name = "media_id"),
		inverseJoinColumns = @JoinColumn(name = "actor_id"))
	private Set<Actor> cast;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "media")
	private Set<Review> reviews;

	public Media() {}
	
	public Media(MediaBuilder mediaBuilder) {
		title = mediaBuilder.getTitle();
		description = mediaBuilder.getDescription();
		premiereDate = mediaBuilder.getPremiereDate();
		cast = new HashSet<Actor>(mediaBuilder.getCast());
		reviews = new HashSet<Review>(mediaBuilder.getReviews());
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
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

	public Set<Actor> getCast() {
		return cast;
	}

	public void setCast(Set<Actor> cast) {
		this.cast = cast;
	}

	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}
	
	@Override
	public String toString() {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		
		StringBuilder sb = new StringBuilder();
		sb.append("Media {")
		  .append("\n\tID: " + this.id)
		  .append("\n\tTitle: " + this.title)
		  .append("\n\tDescription: " + this.description)
		  .append("\n\tPremiere Date: " + dateFormat.format(this.premiereDate.getTime()))
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
