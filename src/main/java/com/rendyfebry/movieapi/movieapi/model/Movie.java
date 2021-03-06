package com.rendyfebry.movieapi.movieapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Movie {
    private final UUID id;

    @NotBlank
    private final String title;

    public Movie(@JsonProperty("id") UUID id, @JsonProperty("title") String title) {
        this.id = id;
        this.title = title;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}