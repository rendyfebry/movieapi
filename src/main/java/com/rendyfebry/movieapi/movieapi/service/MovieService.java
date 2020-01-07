package com.rendyfebry.movieapi.movieapi.service;

import com.rendyfebry.movieapi.movieapi.dao.MovieDao;
import com.rendyfebry.movieapi.movieapi.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MovieService {
    private final MovieDao movieDao;

    @Autowired
    public MovieService(@Qualifier("fakeDao") MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    public int addMovie(Movie movie) {
        return movieDao.insertMovie(movie);
    }

    public List<Movie> getAllMovie() {
        return movieDao.selectAllMovie();
    }

    public Optional<Movie> getMovieById(UUID id) {
        return movieDao.selectMovieByID(id);
    }
}
