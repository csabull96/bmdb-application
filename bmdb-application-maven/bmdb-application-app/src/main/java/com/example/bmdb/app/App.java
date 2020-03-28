package com.example.bmdb.app;

import java.util.Optional;

import com.example.bmdb.domain.Media;
import com.example.bmdb.domain.Rating;
import com.example.bmdb.domain.Review;
import com.example.bmdb.domain.User;
import com.example.bmdb.service.Service;

public class App {
	private Service service;
	private View view;
	private User loggedInUser;
	
	public App(Service service, View view) {
		super();
		this.service = service;
		this.view = view;
	}

	public void play() {
		view.printWelcomeMessage();
		loggedInUser = logIn();
		view.greetUser(loggedInUser);
		doReview();
		view.farewellUser(loggedInUser);
	}
	
	private User logIn() {
		Optional<User> userOptional = null;
		boolean userSuccesfullyLoggedIn = false;
		while (!userSuccesfullyLoggedIn) {
			String username = view.getUsername();
			String password = view.getPassword();
			userOptional = service.logIn(username, password);
			if (userOptional.isPresent()) {
				userSuccesfullyLoggedIn = true;
			}
			else {
				view.printLogInErrorMessage();
			}			
		}
		return userOptional.get();
	}
	
	private void doReview() {
		boolean again = true; 
		while (again) {
			view.printMedias(service.getAllMedia());
			int id = view.readSelectedId();
			Optional<Media> selected = service.getMedia(id);
			if (selected.isPresent()) {
				String text = view.readReviewText();
				Rating rating = Rating.Parse(view.readReviewRating());
				selected.get().addReview(new Review(loggedInUser, text, rating));
				
				if (!view.askUserForAnotherReview()) {
					again = false;
				}
			}
			else {
				view.printMediaNotFoundMessage();
			}		
		}
	}
}
