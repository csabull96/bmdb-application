package com.example.bmdb.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

import com.example.bmdb.database.Database;
import com.example.bmdb.domain.Media;
import com.example.bmdb.domain.Review;
import com.example.bmdb.domain.User;

public class Service {
	private Database database;
	
	public Service(Database database) {
		super();
		this.database = database;
	}
	
	public Optional<User> logIn(String username, String password) {	
		return database.getUsers().stream()
				.filter(u -> u.getUsername().equals(username))
				.filter(u -> u.getPassword().equals(password))
				.findFirst();
	}
	
	public void saveUser(User user) {
		database.getUsers().add(user);
	}
	
	public Optional<Media> getMedia(int id) {
		return database.getMedias().stream()
				.filter(m -> m.getId().compareTo(new BigDecimal(id)) == 0)
				.findFirst();
	}
	
	public List<Media> getAllMedia(){
		return database.getMedias();
	}
	
	public List<Review> getAllReviews(Media media){
		return database.getReviews();
	}
	
	public double getAverageOfRatings(List<Review> reviews) {
		OptionalDouble average = reviews.stream()
			          		    	    .mapToDouble(r -> r.getRating().getRate())
			          		    	    .average();
		
		return average.isPresent() ? average.getAsDouble() : 0.0d;
	}
}
