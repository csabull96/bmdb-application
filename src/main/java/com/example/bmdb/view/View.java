package com.example.bmdb.view;

import java.util.List;
import java.util.Scanner;

import com.example.bmdb.domain.Media;
import com.example.bmdb.domain.User;

public class View {
	private static Scanner input;

	static {
		input = new Scanner(System.in);
	}
	
	public String getUsername() {
		System.out.print("\nUsername: ");
		String username = input.nextLine();
		return username;
	}
	
	public String getPassword() {
		System.out.print("\nPassword: ");
		String password = input.nextLine();
		return password;
	}
	
	public void showLogInErrorMessage() {
		System.out.println("\nUsername or password is incorrect. Please try again!");
	}
	
	public void greetUser(User user) {
		System.out.println("\nHi " + user.getUsername() + ", how are you?");
	}
	
	public void printMedias(List<Media> medias) {
		for (Media media : medias) {
			media.toString();
		}
	}
	
	public int readSelectedId() {
		System.out.print("\n Select an ID: ");
		int id = input.nextInt();
		input.nextLine();
		return id;
	}
	
	public boolean askUserForAnotherReview() {
		System.out.print("\nDo you want to write another review? ");
		boolean answer = input.nextBoolean();
		input.nextLine();
		return answer;
	}
}
