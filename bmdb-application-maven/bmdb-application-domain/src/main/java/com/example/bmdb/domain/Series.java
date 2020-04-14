package com.example.bmdb.domain;

import javax.persistence.Entity;

@Entity
public class Series extends Media {
	public Series(MediaBuilder mediaBuilder) {
		super(mediaBuilder);
	}
	
	public Series() {
		super();
	}
}
