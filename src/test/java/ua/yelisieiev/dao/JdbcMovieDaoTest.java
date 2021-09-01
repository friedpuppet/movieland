package ua.yelisieiev.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import ua.yelisieiev.entity.Movie;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class JdbcMovieDaoTest {
    private JdbcMovieDao jdbcMovieDao;
    private JdbcTemplate jdbcTemplate;
    private Movie shawshankRedemption;
    private Movie greenMile;

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

        jdbcTemplate = mock(JdbcTemplate.class);
        jdbcMovieDao = new JdbcMovieDao(jdbcTemplate);
    }

    @DisplayName("Get all movies")
    @Test
    void test_GetAll() {
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(List.of(shawshankRedemption, greenMile));
        List<Movie> movieList = jdbcMovieDao.getAll();
        assertEquals(2, movieList.size());
        assertTrue(movieList.contains(shawshankRedemption));
        assertTrue(movieList.contains(greenMile));

    }
}