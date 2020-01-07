package com.rendyfebry.movieapi.movieapi.dao;

import com.rendyfebry.movieapi.movieapi.model.Movie;

import java.util.List;
import java.util.UUID;

public interface MovieDao {
    int insertMovie(UUID id, Movie movie);

    default int insertMovie(Movie movie) {
        UUID id = UUID.randomUUID();
        return insertMovie(id, movie);
    }

    List<Movie> selectAllMovie();
}
