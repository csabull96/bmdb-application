package com.example.bmdb.domain;

import javax.persistence.Entity;

@Entity
public class Movie extends Media {
	public Movie(MediaBuilder mediaBuilder) {
		super(mediaBuilder);
	}
	
	public Movie() {
		super();
	}
}
