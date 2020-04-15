package com.example.bmdb.service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;

import com.example.bmdb.domain.Media;
import com.example.bmdb.domain.Review;
import com.example.bmdb.domain.User;
import com.example.bmdb.repository.CentralRepository;

public class Service {
	private CentralRepository repository;
	
	public Service(CentralRepository repository) {
		super();
		this.repository = repository;
	}
	
	public Optional<User> logIn(String username, String password) {	
		
		Optional<User> user = repository.findUserByUsername(username);
		if (user.isPresent() && user.get().getPassword().equals(password)) {
			return user;
		}
		return Optional.empty();
	}
	
	public void saveReview(Review review) {
		repository.saveReview(review);
	}
	
	public Optional<Media> findMediaById(Long id) {
		return repository.findMediaById(id);
	}
	
	public Set<Media> findAllMedia() {
		return repository.findAllMedia();
	}
	
	public void generateTestData() {
		repository.generateTestData();
	}
	
	public double getAverageOfRatings(List<Review> reviews) {
		OptionalDouble average = reviews.stream()
			          		    	    .mapToDouble(r -> r.getRating().getRate())
			          		    	    .average();
		
		return average.isPresent() ? average.getAsDouble() : 0.0d;
	}
}
