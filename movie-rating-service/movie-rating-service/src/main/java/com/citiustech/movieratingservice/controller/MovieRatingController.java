package com.citiustech.movieratingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.movieratingservice.model.MovieRating;
import com.citiustech.movieratingservice.repository.MovieRatingRepository;

@RestController
@RequestMapping("/api/v1")
public class MovieRatingController {
	
	@Autowired
	private MovieRatingRepository movieRatingRepository;
	
	@GetMapping("/ratings/{username}")
	public ResponseEntity<MovieRating> getRatingsByUsername(@PathVariable String username){
		MovieRating movieRating = movieRatingRepository.findByUsername(username);
		return new ResponseEntity<MovieRating>(movieRating,HttpStatus.OK);
	}

	@PostMapping("/ratings")
	public ResponseEntity<MovieRating> addNewMovieRating(@RequestBody MovieRating movieRating){
		MovieRating savedMovieRating = movieRatingRepository.save(movieRating);
		return new ResponseEntity<MovieRating>(savedMovieRating,HttpStatus.CREATED);
	}
}
