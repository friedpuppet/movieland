package ua.yelisieiev.dao.jdbc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ua.yelisieiev.common.MockGenresFactory;
import ua.yelisieiev.dao.GenreDao;
import ua.yelisieiev.entity.Genre;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class JdbcGenreDaoTest {
    private GenreDao genreDao;
    private JdbcTemplate jdbcTemplate;

    private List<Genre> allGenres;
    private Genre drama;
    private Genre criminal;
    private Genre fantasy;
    private Genre detective;

    @BeforeEach
    void setUp() {
        jdbcTemplate = mock(JdbcTemplate.class);
        genreDao = new JdbcGenreDao(jdbcTemplate);

        drama = MockGenresFactory.getGenre("драма");
        criminal = MockGenresFactory.getGenre("криминал");
        fantasy = MockGenresFactory.getGenre("фэнтези");
        detective = MockGenresFactory.getGenre("детектив");

        allGenres = List.of(drama,
                criminal,
                fantasy,
                detective);
    }

    @DisplayName("Get all genres")
    @Test
    @SuppressWarnings("unchecked")
    void test_GetAll() {
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(allGenres);

        List<Genre> genreList = genreDao.getAll();

        assertEquals(4, genreList.size());
        assertTrue(genreList.contains(drama));
        assertTrue(genreList.contains(criminal));
        assertTrue(genreList.contains(fantasy));
        assertTrue(genreList.contains(detective));

        verify(jdbcTemplate, times(1)).query(anyString(), any(RowMapper.class));
        verifyNoMoreInteractions(jdbcTemplate);
    }

}