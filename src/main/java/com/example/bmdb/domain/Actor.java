package com.example.bmdb.domain;

import java.time.LocalDate;
import java.util.List;

public class Actor {
	private String name;
	private LocalDate dateOfBirth;
	private Sex sex;
	private String biography;
	private List<Media> filmography;
}
