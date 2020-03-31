package com.javaprojects.moviecatalogeservice.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.javaprojects.moviecatalogeservice.model.CatalogItem;
import com.javaprojects.moviecatalogeservice.model.Movie;
import com.javaprojects.moviecatalogeservice.model.Rating;
import com.javaprojects.moviecatalogeservice.model.UserRating;


@RestController
@RequestMapping("/catalog")
public class MovieCatalogService {
	
	@Autowired
	private RestTemplate restTemplate;
	//List<Rating> rating=Arrays.asList(new Rating(5,"abc"), new Rating(4,"bnm"));
	//get all rated movie Ids
	//For each movie Id, call movie info service and get details
	//put  them all together
	public MovieCatalogService() {
		
	}
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
		UserRating rating=restTemplate.getForObject("http://rating-data-service/rating/users/"+userId, UserRating.class);
		//List<Rating> rating=Arrays.asList(new Rating(5,"abc"), new Rating(4,"bnm"));
		//return null;
		return  rating.getUserRatings().stream()
				     .map(rat->{ Movie movie=restTemplate.getForObject("http://movie-info-service/movie/"+rat.getMovieId(),Movie.class);
		             return new  CatalogItem(movie.getName(), movie.getMovieId(),rat.getRating()); 
		}).collect(Collectors.toList());
		
		//return Collections.singletonList(new  CatalogItem("name:Transformer","desc:Action", 5));
	}

}
