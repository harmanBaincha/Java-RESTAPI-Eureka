package com.javaprojects.ratingdataservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaprojects.ratingdataservice.models.Rating;
import com.javaprojects.ratingdataservice.models.UserRating;

@RestController
@RequestMapping("/rating")
public class RatingResource {
	
    @RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
    	return new Rating(5,movieId);
    }
    @RequestMapping("users/{userId}")
    public UserRating getUserRatings(@PathVariable("userId") String userId){
    	List<Rating> rating=Arrays.asList(new Rating(5,"abc"), new Rating(4,"bnm"));
    		UserRating userRating=new UserRating();
    		userRating.setUserRatings(rating);
    		return userRating;
    		
    }
}
