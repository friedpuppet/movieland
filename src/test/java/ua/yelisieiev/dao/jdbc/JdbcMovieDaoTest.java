package ua.yelisieiev.dao.jdbc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ua.yelisieiev.entity.Movie;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class JdbcMovieDaoTest {
    private JdbcMovieDao jdbcMovieDao;
    private JdbcTemplate jdbcTemplate;
    private Movie shawshankRedemption;
    private Movie greenMile;
    private Movie forrestGump;
    private Movie inception;

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

        verify(jdbcTemplate, times(1)).query(anyString(), any(RowMapper.class));
        verifyNoMoreInteractions(jdbcTemplate);
    }

    @DisplayName("Get random movies")
    @Test
    void test_GetRandoms() {
        when(jdbcTemplate.query(anyString(), any(), any(), any(RowMapper.class))).
                thenReturn(List.of(shawshankRedemption, greenMile, inception));

        List<Movie> movieList = jdbcMovieDao.getRandoms(3);

        assertEquals(3, movieList.size());

        verify(jdbcTemplate, times(1)).query(anyString(), any(), any(), any(RowMapper.class));
        verifyNoMoreInteractions(jdbcTemplate);
    }
}