package ua.yelisieiev.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.yelisieiev.entity.Movie;
import ua.yelisieiev.service.MovieService;

import java.util.List;

@RestController
@RequestMapping(value = "/movie", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Slf4j
public class MovieController {
    private final MovieService movieService;

    @GetMapping
    public List<Movie> getAll() {
        log.info("Get all movies request received");
        return movieService.getAll();
    }

    @GetMapping(value = "/random")
    public List<Movie> getThreeRandoms() {
        log.info("Get three random movies request received");
        return movieService.getRandomMovies(3);
    }
}

