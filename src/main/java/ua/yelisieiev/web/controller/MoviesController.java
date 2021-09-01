package ua.yelisieiev.web.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jdk.jfr.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.yelisieiev.entity.Movie;
import ua.yelisieiev.service.MovieService;
import ua.yelisieiev.util.LocalDateAdapter;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/movie")
public class MoviesController {
    private final MovieService movieService;
    private final Gson gson;

    public MoviesController(MovieService movieService) {
        this.movieService = movieService;
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getAll() {
        log.info("Entered getAll");
        List<Movie> movies = movieService.getAll();
        return gson.toJson(movies);
    }
}
