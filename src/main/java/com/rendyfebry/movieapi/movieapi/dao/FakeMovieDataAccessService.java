package com.rendyfebry.movieapi.movieapi.dao;

import com.rendyfebry.movieapi.movieapi.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakeMovieDataAccessService implements MovieDao {
    private static List<Movie> DB = new ArrayList<>();

    @Override
    public int insertMovie(UUID id, Movie movie) {
        DB.add(new Movie(id, movie.getTitle()));
        return 0;
    }

    @Override
    public List<Movie> selectAllMovie() {
        return DB;
    }

    @Override
    public Optional<Movie> selectMovieByID(UUID id) {
        return DB.stream()
                .filter(movie -> movie.getId().equals(id))
                .findFirst();
    }
}
