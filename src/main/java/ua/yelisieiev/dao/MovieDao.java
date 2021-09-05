package ua.yelisieiev.dao;

import ua.yelisieiev.entity.Movie;

import java.util.List;

public interface MovieDao {
    List<Movie> getAll();

    List<Movie> getRandoms(int count);

    List<Movie> getMoviesByGenre(int genreId);
}
