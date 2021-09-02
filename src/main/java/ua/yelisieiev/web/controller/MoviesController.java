package ua.yelisieiev.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.yelisieiev.entity.Movie;
import ua.yelisieiev.service.MovieService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/movie")
public class MoviesController {
    private final MovieService movieService;
//    private final Gson gson;

    public MoviesController(MovieService movieService) {
        this.movieService = movieService;
//        gson = new GsonBuilder()
//                .setPrettyPrinting()
//                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
//                .create();
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> getAll() {
        return movieService.getAll();
    }
}
