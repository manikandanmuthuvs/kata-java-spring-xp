package com.manikandanmuthuv.kata.videostore.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.manikandanmuthuv.kata.videostore.model.Movie;

import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieServiceInterface {
    Map<String, Movie> movies = new HashMap<>();

    public Movie AddMovie(Movie movie) {
        Movie addMovie = Movie.builder().id(UUID.randomUUID().toString()).title(movie.getTitle())
                .genre(movie.getGenre()).build();
        movies.put(movie.getTitle(), addMovie);
        return addMovie;
    }

    @Override
    public Movie SearchMovie(String byTitle) {
        return movies.get(byTitle);
    }

    @Override
    public Movie DeleteMovie(String byTitle) {
        return movies.remove(byTitle);
    }

}
