package ua.yelisieiev.service;

import org.springframework.stereotype.Service;
import ua.yelisieiev.dao.MovieDao;
import ua.yelisieiev.entity.Movie;

import java.util.List;

@Service
public class DefaultMovieService implements MovieService {
    private final MovieDao movieDao;

    public DefaultMovieService(MovieDao movieDao) {

        this.movieDao = movieDao;
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }

    @Override
    public List<Movie> getRandomMovies(int count) {
        return movieDao.getRandoms(count);
    }
}
