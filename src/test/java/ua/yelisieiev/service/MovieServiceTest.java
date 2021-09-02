package ua.yelisieiev.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ua.yelisieiev.dao.jdbc.JdbcMovieDao;
import ua.yelisieiev.entity.Movie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MovieServiceTest {
    private Movie shawshankRedemption;
    private Movie greenMile;
    private Movie forrestGump;
    private Movie inception;

    private MovieService movieService;
    private JdbcMovieDao jdbcMovieDao;

    @BeforeEach
    void setUp() {
        shawshankRedemption = Movie.builder()
                .id(1)
                .nameNative("The Shawshank Redemption")
                .nameRussian("Побег из Шоушенка")
                .yearOfRelease(LocalDate.of(1994, 01, 01))
                .build();
        greenMile = Movie.builder()
                .id(2)
                .nameNative("The Green Mile")
                .nameRussian("Зеленая миля")
                .yearOfRelease(LocalDate.of(1999, 01, 01))
                .build();
        forrestGump = Movie.builder()
                .id(3)
                .nameNative("Forrest Gump")
                .nameRussian("Форрест Гамп")
                .yearOfRelease(LocalDate.of(1994, 01, 01))
                .build();
        inception = Movie.builder()
                .id(6)
                .nameNative("Inception")
                .nameRussian("Начало")
                .yearOfRelease(LocalDate.of(2010, 01, 01))
                .build();
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