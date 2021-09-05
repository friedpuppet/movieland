package ua.yelisieiev.service;

import ua.yelisieiev.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAll();

    List<Movie> getRandomMovies(int count);

    List<Movie> getMoviesByGenre(int genreId);
}
