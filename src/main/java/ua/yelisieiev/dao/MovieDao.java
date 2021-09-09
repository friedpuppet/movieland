package ua.yelisieiev.dao;

import org.springframework.stereotype.Repository;
import ua.yelisieiev.entity.Movie;
import ua.yelisieiev.entity.MovieFull;

import java.util.List;

public interface MovieDao {
    List<Movie> getAll();

    List<Movie> getAllSorted(String sortedAttribute, String sortingType);

    List<Movie> getRandoms(int count);

    List<Movie> getMoviesByGenre(int genreId);

    List<Movie> getMoviesByGenreSorted(int genreId, String sortedAttribute, String sortingType);

    MovieFull getSingle(int movieId);
}
