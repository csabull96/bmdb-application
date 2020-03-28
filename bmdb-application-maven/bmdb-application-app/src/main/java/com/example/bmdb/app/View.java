package com.example.bmdb.app;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;

import com.example.bmdb.domain.Media;
import com.example.bmdb.domain.User;

public class View {
	
	@Value("${app.language}")
	private String locale;
	
	@Autowired
	private MessageSource messageSource;
	
	private static Scanner input;

	static {
		input = new Scanner(System.in);
	}
	
	public void printWelcomeMessage() {
		System.out.println(getMessage("welcome.message"));
	}
	
	public String getUsername() {
		System.out.print(System.lineSeparator() + getMessage("login.username"));
		String username = input.nextLine();
		return username;
	}
	
	public String getPassword() {
		System.out.print(getMessage("login.password"));
		String password = input.nextLine();
		return password;
	}
	
	public void printLogInErrorMessage() {
		System.out.println(System.lineSeparator() + getMessage("login.failed"));
	}
	
	public void greetUser(User user) {
		System.out.println(System.lineSeparator() + getMessage("login.succeeded", new Object[] { user.getUsername() }));
		input.nextLine();
	}
	
	public int readSelectedId() {
		System.out.print(getMessage("media.search"));
		int id = input.nextInt();
		input.nextLine();
		return id;
	}
	
	public void printMediaNotFoundMessage() {
		System.out.print(System.lineSeparator() + getMessage("media.notFound") + System.lineSeparator());
		input.nextLine();
	}
	
	public void printMedias(List<Media> medias) {
		for (Media media : medias) {
			System.out.println(media.toString());
		}
	}
	
	public String readReviewText() {
		System.out.print(System.lineSeparator() + getMessage("review.write"));
		String reviewText = input.nextLine();
		return reviewText;
	}
	
	public String readReviewRating() {
		System.out.print(System.lineSeparator() + getMessage("review.rate"));
		String reviewRating = input.nextLine();
		return reviewRating;
	}
	
	public boolean askUserForAnotherReview() {
		System.out.print(System.lineSeparator() + getMessage("run.continueOrClose"));
		boolean answer = input.nextLine().toLowerCase().equals("yes");
		System.out.println();
		return answer;
	}
	
	public void farewellUser(User user) {
		System.out.println(getMessage("goodbye.message", new Object[] { user.getUsername() }));
	}
	
	private String getMessage(String code) {
		return messageSource.getMessage(code, null, new Locale(locale));
	}
	
	private String getMessage(String code, Object[] args) {
		return messageSource.getMessage(code, args, new Locale(locale));
	}
}
