package ua.yelisieiev.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.yelisieiev.entity.Genre;
import ua.yelisieiev.service.GenreService;

import java.util.List;

@RestController
@RequestMapping(value = "/genre", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Slf4j
public class GenreController {
    private final GenreService genreService;

    @GetMapping
    public List<Genre> getAll() {
        log.info("Get all genres request received");
        return genreService.getAll();
    }

}
