package ua.yelisieiev.dao.jdbc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ua.yelisieiev.dao.MovieDao;
import ua.yelisieiev.dao.jdbc.mapper.MovieFullRowMapper;
import ua.yelisieiev.dao.jdbc.mapper.MovieRowMapper;
import ua.yelisieiev.entity.Movie;
import ua.yelisieiev.entity.MovieFull;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static ua.yelisieiev.common.MockMovies.*;

class JdbcMovieDaoTest {
    private MovieDao movieDao;
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setUp() {
        jdbcTemplate = mock(JdbcTemplate.class);
        movieDao = new JdbcMovieDao(jdbcTemplate);
    }

    @DisplayName("Get all movies")
    @Test
    void test_GetAll() {
        when(jdbcTemplate.query(anyString(), any(MovieRowMapper.class))).thenReturn(List.of(SHAWSHANK_REDEMPTION, GREEN_MILE));

        List<Movie> movieList = movieDao.getAll();

        assertEquals(2, movieList.size());
        assertTrue(movieList.contains(SHAWSHANK_REDEMPTION));
        assertTrue(movieList.contains(GREEN_MILE));

        verify(jdbcTemplate, times(1)).query(anyString(), any(MovieRowMapper.class));
        verifyNoMoreInteractions(jdbcTemplate);
    }

    @DisplayName("On mocked jdbc - get all movies sorted by rating desc")
    @Test
    void test_GetAllSortedByRatingDesc() {
        when(jdbcTemplate.query(anyString(), any(MovieRowMapper.class))).thenReturn(List.of(SHAWSHANK_REDEMPTION, GREEN_MILE));

        List<Movie> movieList = movieDao.getAllSorted("rating", "desc");

        assertEquals(2, movieList.size());
        assertTrue(movieList.contains(SHAWSHANK_REDEMPTION));
        assertTrue(movieList.contains(GREEN_MILE));

        verify(jdbcTemplate, times(1)).query(anyString(), any(MovieRowMapper.class));
        verifyNoMoreInteractions(jdbcTemplate);
    }

    @DisplayName("On mocked jdbc - get all movies sorted by price desc")
    @Test
    void test_GetAllSortedByPriceDesc() {
        when(jdbcTemplate.query(anyString(), any(MovieRowMapper.class))).thenReturn(List.of(SHAWSHANK_REDEMPTION, GREEN_MILE));

        List<Movie> movieList = movieDao.getAllSorted("price", "desc");

        assertEquals(2, movieList.size());
        assertTrue(movieList.contains(SHAWSHANK_REDEMPTION));
        assertTrue(movieList.contains(GREEN_MILE));

        verify(jdbcTemplate, times(1)).query(anyString(), any(MovieRowMapper.class));
        verifyNoMoreInteractions(jdbcTemplate);
    }

    @DisplayName("On mocked jdbc - get all movies sorted by price asc")
    @Test
    void test_GetAllSortedByPriceAsc() {
        when(jdbcTemplate.query(anyString(), any(MovieRowMapper.class))).thenReturn(List.of(SHAWSHANK_REDEMPTION, GREEN_MILE));

        List<Movie> movieList = movieDao.getAllSorted("price", "asc");

        assertEquals(2, movieList.size());
        assertTrue(movieList.contains(SHAWSHANK_REDEMPTION));
        assertTrue(movieList.contains(GREEN_MILE));

        verify(jdbcTemplate, times(1)).query(anyString(), any(MovieRowMapper.class));
        verifyNoMoreInteractions(jdbcTemplate);
    }

    @DisplayName("Get random movies")
    @Test
    void test_GetRandoms() {
        when(jdbcTemplate.query(anyString(), any(MovieRowMapper.class), any())).
                thenReturn(List.of(SHAWSHANK_REDEMPTION, GREEN_MILE, INCEPTION));

        List<Movie> movieList = movieDao.getRandoms(3);

        assertEquals(3, movieList.size());

        verify(jdbcTemplate, times(1)).query(anyString(), any(MovieRowMapper.class), any());
        verifyNoMoreInteractions(jdbcTemplate);
    }

    @DisplayName("Get movies for a genre")
    @Test
    void test_GetByGenre() {
        when(jdbcTemplate.query(anyString(), any(MovieRowMapper.class), any())).
                thenReturn(List.of(SHAWSHANK_REDEMPTION, GREEN_MILE));

        List<Movie> movieList = movieDao.getMoviesByGenre(2);

        assertEquals(2, movieList.size());

        verify(jdbcTemplate, times(1)).query(anyString(), any(MovieRowMapper.class), any());
        verifyNoMoreInteractions(jdbcTemplate);
    }

    @DisplayName("On mocked jdbc - get movies for a genre sorted by rating desc")
    @Test
    void test_GetByGenreSortedByRatingDesc() {
        when(jdbcTemplate.query(anyString(), any(MovieRowMapper.class), any())).
                thenReturn(List.of(SHAWSHANK_REDEMPTION, GREEN_MILE));

        List<Movie> movieList = movieDao.getMoviesByGenreSorted(2, "rating", "desc");

        assertEquals(2, movieList.size());

        verify(jdbcTemplate, times(1)).query(anyString(), any(MovieRowMapper.class), any());
        verifyNoMoreInteractions(jdbcTemplate);
    }

    @DisplayName("On mocked jdbc - get movies for a genre sorted by price desc")
    @Test
    void test_GetByGenreSortedByPriceDesc() {
        when(jdbcTemplate.query(anyString(), any(MovieRowMapper.class), any())).
                thenReturn(List.of(SHAWSHANK_REDEMPTION, GREEN_MILE));

        List<Movie> movieList = movieDao.getMoviesByGenreSorted(2, "price", "desc");

        assertEquals(2, movieList.size());

        verify(jdbcTemplate, times(1)).query(anyString(), any(MovieRowMapper.class), any());
        verifyNoMoreInteractions(jdbcTemplate);
    }

    @DisplayName("On mocked jdbc - get movies for a genre sorted by price asc")
    @Test
    void test_GetByGenreSortedByPriceAsc() {
        when(jdbcTemplate.query(anyString(), any(MovieRowMapper.class), any())).
                thenReturn(List.of(SHAWSHANK_REDEMPTION, GREEN_MILE));

        List<Movie> movieList = movieDao.getMoviesByGenreSorted(2, "price", "asc");

        assertEquals(2, movieList.size());

        verify(jdbcTemplate, times(1)).query(anyString(), any(MovieRowMapper.class), any());
        verifyNoMoreInteractions(jdbcTemplate);
    }

    @DisplayName("On mocked jdbc - get single movie by id")
    @Test
    void test_getSingle() {
        when(jdbcTemplate.queryForObject(anyString(), any(MovieFullRowMapper.class), anyInt()))
                .thenReturn(SHAWSHANK_REDEMPTION_FULL_NOT_ENRICHED);

        MovieFull movieFull = movieDao.getSingle(1);

        assertNotNull(movieFull);
        assertEquals(1, movieFull.getId());
        assertEquals("The Shawshank Redemption", movieFull.getNameNative());
        assertEquals("Побег из Шоушенка", movieFull.getNameRussian());
        assertEquals(LocalDate.of(1994, 1, 1), movieFull.getYearOfRelease());
        assertNotNull(movieFull.getDescription());
        assertEquals(123.45, movieFull.getPrice());
        assertEquals(8.9, movieFull.getRating());
        assertEquals("https://images-na.ssl-images-amazon.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1._SY209_CR0,0,140,209_.jpg",
                movieFull.getPicturePath());
        assertNull(movieFull.getCountries());
        assertNull(movieFull.getGenres());
        assertNull(movieFull.getReviews());

        verify(jdbcTemplate, times(1))
                .queryForObject(anyString(), any(MovieFullRowMapper.class), anyInt());
        verifyNoMoreInteractions(jdbcTemplate);
    }
}