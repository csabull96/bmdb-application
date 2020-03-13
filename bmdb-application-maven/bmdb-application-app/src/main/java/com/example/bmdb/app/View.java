package com.example.bmdb.app;

import java.util.List;
import java.util.Scanner;

import com.example.bmdb.domain.Media;
import com.example.bmdb.domain.User;

public class View {
	private static Scanner input;

	static {
		input = new Scanner(System.in);
	}
	
	public void printWelcomeMessage() {
		System.out.println("Welcome to the BMDb application!\n");
	}
	
	public String getUsername() {
		System.out.print("Username: ");
		String username = input.nextLine();
		return username;
	}
	
	public String getPassword() {
		System.out.print("Password: ");
		String password = input.nextLine();
		return password;
	}
	
	public void printLogInErrorMessage() {
		System.out.println("\nUsername or password is incorrect. Please try again!");
	}
	
	public void printMediaNotFoundMessage() {
		System.out.print("\nMedia is not found. Select another ID. [Press ENTER]");
		input.nextLine();
	}
	
	public void greetUser(User user) {
		System.out.println("\nHi " + user.getUsername() + ", how are you? [Press ENTER]");
		input.nextLine();
	}
	
	public void printMedias(List<Media> medias) {
		for (Media media : medias) {
			System.out.println(media.toString());
		}
	}
	
	public int readSelectedId() {
		System.out.print("\nSelect an ID: ");
		int id = input.nextInt();
		input.nextLine();
		return id;
	}
	
	public String readReviewText() {
		System.out.print("\nWrite review: ");
		String reviewText = input.nextLine();
		return reviewText;
	}
	
	public String readReviewRating() {
		System.out.print("\nRate the content [bad/average/good]: ");
		String reviewRating = input.nextLine();
		return reviewRating;
	}
	
	public boolean askUserForAnotherReview() {
		System.out.print("\nDo you want to write another review? [yes/no]: ");
		return input.nextLine().toLowerCase().equals("yes");
	}
}
