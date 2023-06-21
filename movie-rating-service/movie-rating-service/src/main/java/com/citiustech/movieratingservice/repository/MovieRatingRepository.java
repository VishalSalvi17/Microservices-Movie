package com.citiustech.movieratingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citiustech.movieratingservice.model.MovieRating;

public interface MovieRatingRepository extends JpaRepository<MovieRating, String> {
	MovieRating findByUsername(String username);
}
