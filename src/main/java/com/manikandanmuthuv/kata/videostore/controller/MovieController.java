package com.manikandanmuthuv.kata.videostore.controller;

import com.manikandanmuthuv.kata.videostore.model.Movie;
import com.manikandanmuthuv.kata.videostore.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie create(@RequestBody Movie movie) {
        return movieService.create(movie);
    }
    
   
}