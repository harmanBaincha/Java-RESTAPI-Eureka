package com.javaprojects.ratingdataservice.models;

public class Rating {
	
	private int rating;
	private String movieId;
	
	public Rating(int rating, String movieId) {
		super();
		this.rating = rating;
		this.movieId = movieId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	
	

}
