package ua.yelisieiev.service;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.yelisieiev.dao.MovieDao;
import ua.yelisieiev.entity.*;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultMovieService implements MovieService {
    private final MovieDao movieDao;
    private final CountryService countryService;
    private final GenreService genreService;
    private final ReviewService reviewService;

    @Override
    public List<Movie> getAll() {
        log.info("Get all movies request received");
        return movieDao.getAll();
    }

    @Override
    public List<Movie> getAllSorted(String sortedAttribute, String sortingType) {
        return movieDao.getAllSorted(sortedAttribute, sortingType);
    }

    @Override
    public List<Movie> getRandomMovies(int count) {
        log.info("Get {} random movies request received", count);
        return movieDao.getRandoms(count);
    }

    @Override
    public List<Movie> getMoviesByGenre(int genreId) {
        log.info("Get movies for genre {} request received", genreId);
        return movieDao.getMoviesByGenre(genreId);
    }

    @Override
    public List<Movie> getMoviesByGenreSorted(int genreId, String sortedAttribute, String sortingType) {
        return movieDao.getMoviesByGenreSorted(genreId, sortedAttribute, sortingType);
    }

    @Override
    public MovieFull getSingle(int id) {
        MovieFull movieFull = movieDao.getSingle(id);
        List<Country> countries = countryService.getListForMovie(id);
        List<Genre> genres = genreService.getListForMovie(id);
        List<Review> reviews = reviewService.getListForMovie(id);
        movieFull.setCountries(countries);
        movieFull.setGenres(genres);
        movieFull.setReviews(reviews);
        return movieFull;
    }
}
