package com.manikandanmuthuv.kata.videostore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import com.manikandanmuthuv.kata.videostore.model.Movie;
import com.manikandanmuthuv.kata.videostore.service.MovieService;

import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;

public class MovieServiceTest {

    MovieService movieService = new MovieService();

    @Test
    public void createMovie() {
        Movie actualMovie = Movie.builder().id(UUID.randomUUID()).title("Avengers EndGame").category("Fantasy").build();
        Movie expectedMovie = movieService.create(actualMovie);
        assertThat(actualMovie.getTitle()).isEqualTo(expectedMovie.getTitle());
    }
}