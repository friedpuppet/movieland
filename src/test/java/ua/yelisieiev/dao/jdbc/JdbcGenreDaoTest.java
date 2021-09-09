package ua.yelisieiev.dao.jdbc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import ua.yelisieiev.dao.GenreDao;
import ua.yelisieiev.dao.jdbc.mapper.GenreRowMapper;
import ua.yelisieiev.entity.Genre;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static ua.yelisieiev.common.MockGenres.*;

class JdbcGenreDaoTest {
    private GenreDao genreDao;
    private JdbcTemplate jdbcTemplate;

    private List<Genre> allGenres;

    @BeforeEach
    void setUp() {
        jdbcTemplate = mock(JdbcTemplate.class);
        genreDao = new JdbcGenreDao(jdbcTemplate);


        allGenres = List.of(DRAMA,
                CRIMINAL,
                FANTASY,
                DETECTIVE);
    }

    @DisplayName("Get all genres")
    @Test
    void test_GetAll() {
        when(jdbcTemplate.query(anyString(), any(GenreRowMapper.class))).thenReturn(allGenres);

        List<Genre> genreList = genreDao.getAll();

        assertEquals(4, genreList.size());
        assertTrue(genreList.contains(DRAMA));
        assertTrue(genreList.contains(CRIMINAL));
        assertTrue(genreList.contains(FANTASY));
        assertTrue(genreList.contains(DETECTIVE));

        verify(jdbcTemplate, times(1)).query(anyString(), any(GenreRowMapper.class));
        verifyNoMoreInteractions(jdbcTemplate);
    }

    @DisplayName("On mocked jdbc - get genre list for a movie")
    @Test
    void getListForMovie() {
        when(jdbcTemplate.query(anyString(), any(GenreRowMapper.class), anyInt())).thenReturn(List.of(DRAMA, CRIMINAL));

        List<Genre> genres = genreDao.getListForMovie(1);

        assertNotNull(genres);
        assertEquals(1, genres.get(0).getId());
        assertEquals("драма", genres.get(0).getName());
        assertEquals(2, genres.get(1).getId());
        assertEquals("криминал", genres.get(1).getName());

        verify(jdbcTemplate, times(1)).query(anyString(), any(GenreRowMapper.class), anyInt());
        verifyNoMoreInteractions(jdbcTemplate);
    }


}