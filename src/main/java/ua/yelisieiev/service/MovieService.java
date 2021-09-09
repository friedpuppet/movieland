package ua.yelisieiev.service;

import ua.yelisieiev.entity.Movie;
import ua.yelisieiev.entity.MovieFull;

import java.util.List;

public interface MovieService {
    List<Movie> getAll();

    List<Movie> getAllSorted(String sortedAttribute, String sortingType);

    List<Movie> getRandomMovies(int count);

    List<Movie> getMoviesByGenre(int genreId);

    List<Movie> getMoviesByGenreSorted(int genreId, String sortedAttribute, String sortingType);

    MovieFull getSingle(int id);
}
