package ua.yelisieiev.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ua.yelisieiev.common.MockMoviesFactory;
import ua.yelisieiev.dao.jdbc.JdbcMovieDao;
import ua.yelisieiev.entity.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class MovieServiceTest {
    private final Movie shawshankRedemption = MockMoviesFactory.getshawshankRedemption();
    private final Movie greenMile = MockMoviesFactory.getGreenMile();
    private final Movie forrestGump = MockMoviesFactory.getForrestGump();
    private final Movie inception = MockMoviesFactory.getInception();

    private MovieService movieService;
    private JdbcMovieDao jdbcMovieDao;

    @BeforeEach
    void setUp() {
        jdbcMovieDao = mock(JdbcMovieDao.class);
        movieService = new DefaultMovieService(jdbcMovieDao);
    }

    @DisplayName("Get all movies")
    @Test
    void test_getAllMovies() {
        List<Movie> movies = List.of(shawshankRedemption, greenMile);
        when(jdbcMovieDao.getAll()).thenReturn(movies);
        List<Movie> movieList = movieService.getAll();

        assertEquals(2, movieList.size());
        assertTrue(movieList.contains(shawshankRedemption));
        assertTrue(movieList.contains(greenMile));

        verify(jdbcMovieDao, times(1)).getAll();
        verifyNoMoreInteractions(jdbcMovieDao);
    }

    @DisplayName("Get three random movies")
    @Test
    void test_getThreeRandomMovies() {
        List<Movie> movies = new ArrayList<>(List.of(shawshankRedemption, greenMile, forrestGump, inception));
        movies.remove(new Random(System.nanoTime()).nextInt(3));
        when(jdbcMovieDao.getRandoms(3)).thenReturn(movies);

        List<Movie> movieList = movieService.getRandomMovies(3);
        assertEquals(3, movieList.size());

        verify(jdbcMovieDao, times(1)).getRandoms(3);
        verifyNoMoreInteractions(jdbcMovieDao);
    }
}