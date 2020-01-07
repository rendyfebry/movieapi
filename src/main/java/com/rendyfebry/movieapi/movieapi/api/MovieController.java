package com.rendyfebry.movieapi.movieapi.api;

import com.rendyfebry.movieapi.movieapi.model.Movie;
import com.rendyfebry.movieapi.movieapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("/2.0/movie")
@RestController
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public void addMovie(@Valid @NotNull @RequestBody Movie movie) {
        movieService.addMovie(movie);
    }

    @GetMapping
    public List<Movie> getAllMovie() {
        return movieService.getAllMovie();
    }

    @GetMapping(path = "{id}")
    public Movie getMovieById(@PathVariable("id") UUID id) {
        return movieService.getMovieById(id)
                .orElse(null);
    }
}
