package com.rendyfebry.movieapi.movieapi.api;

import com.rendyfebry.movieapi.movieapi.model.Movie;
import com.rendyfebry.movieapi.movieapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/2.0/movie")
@RestController
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public void addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
    }

    @GetMapping
    public List<Movie> getAllMovie() {
        return movieService.getAllMovie();
    }
}
