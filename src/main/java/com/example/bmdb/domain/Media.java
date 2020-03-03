package com.example.bmdb.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public abstract class Media {
	private BigDecimal id;
	private String title;
	private String description;
	private LocalDate premiereDate;
	private List<Actor> cast;
	private List<Review> reviews;
}
