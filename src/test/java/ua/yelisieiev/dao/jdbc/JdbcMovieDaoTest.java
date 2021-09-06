package ua.yelisieiev.dao.jdbc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ua.yelisieiev.common.MockMoviesFactory;
import ua.yelisieiev.entity.Movie;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class JdbcMovieDaoTest {
    private JdbcMovieDao jdbcMovieDao;
    private JdbcTemplate jdbcTemplate;
    private final Movie shawshankRedemption = MockMoviesFactory.getshawshankRedemption();
    private final Movie greenMile = MockMoviesFactory.getGreenMile();
    private final Movie inception = MockMoviesFactory.getInception();

    @BeforeEach
    void setUp() {
        jdbcTemplate = mock(JdbcTemplate.class);
        jdbcMovieDao = new JdbcMovieDao(jdbcTemplate);
    }

    @DisplayName("Get all movies")
    @Test
    @SuppressWarnings("unchecked")
    void test_GetAll() {
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(List.of(shawshankRedemption, greenMile));

        List<Movie> movieList = jdbcMovieDao.getAll();

        assertEquals(2, movieList.size());
        assertTrue(movieList.contains(shawshankRedemption));
        assertTrue(movieList.contains(greenMile));

        verify(jdbcTemplate, times(1)).query(anyString(), any(RowMapper.class));
        verifyNoMoreInteractions(jdbcTemplate);
    }

    @DisplayName("On mocked jdbc - get all movies sorted by rating desc")
    @Test
    @SuppressWarnings("unchecked")
    void test_GetAllSortedByRatingDesc() {
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(List.of(shawshankRedemption, greenMile));

        List<Movie> movieList = jdbcMovieDao.getAllSorted("rating", "desc");

        assertEquals(2, movieList.size());
        assertTrue(movieList.contains(shawshankRedemption));
        assertTrue(movieList.contains(greenMile));

        verify(jdbcTemplate, times(1)).query(anyString(), any(RowMapper.class));
        verifyNoMoreInteractions(jdbcTemplate);
    }

    @DisplayName("On mocked jdbc - get all movies sorted by price desc")
    @Test
    @SuppressWarnings("unchecked")
    void test_GetAllSortedByPriceDesc() {
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(List.of(shawshankRedemption, greenMile));

        List<Movie> movieList = jdbcMovieDao.getAllSorted("price", "desc");

        assertEquals(2, movieList.size());
        assertTrue(movieList.contains(shawshankRedemption));
        assertTrue(movieList.contains(greenMile));

        verify(jdbcTemplate, times(1)).query(anyString(), any(RowMapper.class));
        verifyNoMoreInteractions(jdbcTemplate);
    }

    @DisplayName("On mocked jdbc - get all movies sorted by price asc")
    @Test
    @SuppressWarnings("unchecked")
    void test_GetAllSortedByPriceAsc() {
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(List.of(shawshankRedemption, greenMile));

        List<Movie> movieList = jdbcMovieDao.getAllSorted("price", "asc");

        assertEquals(2, movieList.size());
        assertTrue(movieList.contains(shawshankRedemption));
        assertTrue(movieList.contains(greenMile));

        verify(jdbcTemplate, times(1)).query(anyString(), any(RowMapper.class));
        verifyNoMoreInteractions(jdbcTemplate);
    }

    @DisplayName("Get random movies")
    @Test
    @SuppressWarnings("unchecked")
    void test_GetRandoms() {
        when(jdbcTemplate.query(anyString(), any(RowMapper.class), any())).
                thenReturn(List.of(shawshankRedemption, greenMile, inception));

        List<Movie> movieList = jdbcMovieDao.getRandoms(3);

        assertEquals(3, movieList.size());

        verify(jdbcTemplate, times(1)).query(anyString(), any(RowMapper.class), any());
        verifyNoMoreInteractions(jdbcTemplate);
    }

    @DisplayName("Get movies for a genre")
    @Test
    @SuppressWarnings("unchecked")
    void test_GetByGenre() {
        when(jdbcTemplate.query(anyString(), any(RowMapper.class), any())).
                thenReturn(List.of(shawshankRedemption, greenMile));

        List<Movie> movieList = jdbcMovieDao.getMoviesByGenre(2);

        assertEquals(2, movieList.size());

        verify(jdbcTemplate, times(1)).query(anyString(), any(RowMapper.class), any());
        verifyNoMoreInteractions(jdbcTemplate);
    }

    @DisplayName("On mocked jdbc - get movies for a genre sorted by rating desc")
    @Test
    @SuppressWarnings("unchecked")
    void test_GetByGenreSortedByRatingDesc() {
        when(jdbcTemplate.query(anyString(), any(RowMapper.class), any())).
                thenReturn(List.of(shawshankRedemption, greenMile));

        List<Movie> movieList = jdbcMovieDao.getMoviesByGenreSorted(2, "rating", "desc");

        assertEquals(2, movieList.size());

        verify(jdbcTemplate, times(1)).query(anyString(), any(RowMapper.class), any());
        verifyNoMoreInteractions(jdbcTemplate);
    }

    @DisplayName("On mocked jdbc - get movies for a genre sorted by price desc")
    @Test
    @SuppressWarnings("unchecked")
    void test_GetByGenreSortedByPriceDesc() {
        when(jdbcTemplate.query(anyString(), any(RowMapper.class), any())).
                thenReturn(List.of(shawshankRedemption, greenMile));

        List<Movie> movieList = jdbcMovieDao.getMoviesByGenreSorted(2, "price", "desc");

        assertEquals(2, movieList.size());

        verify(jdbcTemplate, times(1)).query(anyString(), any(RowMapper.class), any());
        verifyNoMoreInteractions(jdbcTemplate);
    }

    @DisplayName("On mocked jdbc - get movies for a genre sorted by price asc")
    @Test
    @SuppressWarnings("unchecked")
    void test_GetByGenreSortedByPriceAsc() {
        when(jdbcTemplate.query(anyString(), any(RowMapper.class), any())).
                thenReturn(List.of(shawshankRedemption, greenMile));

        List<Movie> movieList = jdbcMovieDao.getMoviesByGenreSorted(2, "price", "asc");

        assertEquals(2, movieList.size());

        verify(jdbcTemplate, times(1)).query(anyString(), any(RowMapper.class), any());
        verifyNoMoreInteractions(jdbcTemplate);
    }

}