package ua.yelisieiev.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ua.yelisieiev.dao.JdbcMovieDao;
import ua.yelisieiev.entity.Movie;
import ua.yelisieiev.web.controller.MoviesController;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MovieServiceTest {
    private Movie shawshankRedemption;
    private Movie greenMile;
    private MovieService movieService;
    private JdbcMovieDao jdbcMovieDao;

    @BeforeEach
    void setUp() {
        shawshankRedemption = Movie.builder()
                .id(1)
                .name_native("The Shawshank Redemption")
                .name_russian("Побег из Шоушенка")
                .year_of_release(LocalDate.of(1994, 01, 01))
                .build();
        greenMile = Movie.builder()
                .id(2)
                .name_native("The Green Mile")
                .name_russian("Зеленая миля")
                .year_of_release(LocalDate.of(1999, 01, 01))
                .build();

        jdbcMovieDao = mock(JdbcMovieDao.class);
        movieService = new MovieService(jdbcMovieDao);
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
    }
}