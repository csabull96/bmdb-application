package com.example.bmdb.domain;

import java.util.HashMap;
import java.util.Map;

public enum Rating {
    BAD(1), AVERAGE(3), GOOD(5);
	
    private final int rate;
    
    private Rating(int rate) {
        this.rate = rate;
    }
    
    public static Rating Parse(String rating) {
    	switch (rating.toLowerCase()) {
		case "bad":
			return Rating.BAD;
		case "good":
			return Rating.GOOD;
		default:
			return Rating.AVERAGE;
		}
    }
    
    public int getRate() {
    	return rate;
    }
    
    private static final Map<Rating, Integer> BY_RATE = new HashMap<Rating, Integer>();
    
    static {
        for (Rating r: values()) {
            BY_RATE.put(r, r.rate);
        }
    }
    
    public static int valueOfRating(Rating rating) {
        return BY_RATE.get(rating);
    }
}
