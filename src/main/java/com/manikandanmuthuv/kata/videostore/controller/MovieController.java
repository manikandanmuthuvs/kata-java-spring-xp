package com.manikandanmuthuv.kata.videostore.controller;

import com.manikandanmuthuv.kata.videostore.model.Movie;
import com.manikandanmuthuv.kata.videostore.service.MovieServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {

    @Autowired
    private MovieServiceImpl movieService;

    @PostMapping("")
    @ResponseBody
    public Movie AddMovie(@RequestBody Movie movie) {
        return movieService.AddMovie(movie);
    }
}