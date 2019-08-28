package com.manikandanmuthuv.kata.videostore.service;

import com.manikandanmuthuv.kata.videostore.model.Movie;

public interface MovieServiceInterface {
    public Movie AddMovie(Movie movie);

    public Movie SearchMovie(String byTitle);
}