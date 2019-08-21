package com.manikandanmuthuv.kata.videostore.service;

import java.util.HashMap;
import java.util.Map;

import com.manikandanmuthuv.kata.videostore.model.Movie;

import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private Map<String, Movie> movies = new HashMap<String, Movie>();

    public Movie create(Movie movie) {
        movies.put(movie.getId().toString(), movie);
        return movie;
    }
  
}