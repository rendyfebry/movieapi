package com.rendyfebry.movieapi.movieapi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/2.0/movie")
@RestController
public class MovieController {
    @Autowired
    RestTemplate restTemplate;

    @Value("${app.apiURL}")
    String apiURL;

    @Value("${app.apiKey}")
    String apiKey;

    @GetMapping(path = "{id}")
    public String getMovieById(@PathVariable("id") String id) {
        String url = apiURL + "/movie/" + id + "?language=en-US&api_key=" + apiKey;
        return restTemplate.getForObject(url, String.class);
    }

    @Bean
    public RestTemplate rest() {
        return new RestTemplate();
    }
}
