package ua.yelisieiev.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping(params = {"rating"})
    public List<Movie> getAllSortedByRating(@RequestParam String rating) {
        // todo error on rating=asc ???
        log.info("Get all movies sorted by rating request received");
        return movieService.getAllSorted("rating", rating);
    }

    @GetMapping(params = {"price"})
    public List<Movie> getAllSortedByPrice(@RequestParam String price) {
        log.info("Get all movies sorted by price request received");
        return movieService.getAllSorted("price", price);
    }

    @GetMapping(value = "/random")
    public List<Movie> getThreeRandoms() {
        log.info("Get three random movies request received");
        return movieService.getRandomMovies(3);
    }

    @GetMapping(value = "/genre/{genreId}")
    public List<Movie> getmoviesByGenre(@PathVariable int genreId) {
        log.info("Get movies by genre  by rating request received");
        return movieService.getMoviesByGenre(genreId);
    }

    @GetMapping(value = "/genre/{genreId}", params = {"rating"})
    public List<Movie> getmoviesByGenreSortedByRating(@PathVariable int genreId, @RequestParam String rating) {
        log.info("Get movies by genre sorted  by price request received");
        return movieService.getMoviesByGenreSorted(genreId, "rating", rating);
    }

    @GetMapping(value = "/genre/{genreId}", params = {"price"})
    public List<Movie> getmoviesByGenreSortedByPrice(@PathVariable int genreId, @RequestParam String price) {
        log.info("Get movies by genre sorted by price request received");
        return movieService.getMoviesByGenreSorted(genreId, "price", price);
    }
}

