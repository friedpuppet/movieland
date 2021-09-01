package ua.yelisieiev.service;

import org.springframework.stereotype.Service;
import ua.yelisieiev.dao.JdbcMovieDao;
import ua.yelisieiev.entity.Movie;

import java.util.List;

@Service
public class MovieService {
    private final JdbcMovieDao jdbcMovieDao;

    public MovieService(JdbcMovieDao jdbcMovieDao) {

        this.jdbcMovieDao = jdbcMovieDao;
    }

    public List<Movie> getAll() {
        return jdbcMovieDao.getAll();
    }
}
