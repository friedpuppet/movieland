package ua.yelisieiev.dao.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ua.yelisieiev.dao.GenreDao;
import ua.yelisieiev.dao.jdbc.JdbcGenreDao;
import ua.yelisieiev.entity.Genre;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static ua.yelisieiev.common.MockGenres.*;

class CachedGenreDaoTest {
    private GenreDao genreDao;
    private CachedGenreDao cachedGenreDao;

    private List<Genre> allGenres;

    @BeforeEach
    void setUp() {
        genreDao = mock(JdbcGenreDao.class);
        cachedGenreDao = new CachedGenreDao(genreDao);

        allGenres = List.of(DRAMA,
                CRIMINAL,
                FANTASY,
                DETECTIVE);
    }

    @DisplayName("With mocked jdbc and outdated cache - get all")
    @Test
    void test_getAllAndRefreshCache() {
        when(genreDao.getAll()).thenReturn(allGenres);

        cachedGenreDao.setNextUpdateTime(LocalDateTime.now());
        List<Genre> genreList = cachedGenreDao.getAll();

        assertEquals(4, genreList.size());
        assertTrue(genreList.contains(DRAMA));
        assertTrue(genreList.contains(CRIMINAL));
        assertTrue(genreList.contains(FANTASY));
        assertTrue(genreList.contains(DETECTIVE));

        verify(genreDao, times(1)).getAll();
        verifyNoMoreInteractions(genreDao);
    }

    @DisplayName("With mocked jdbc and up to date cache - get all")
    @Test
    void test_getAllFromCache() {
        when(genreDao.getAll()).thenReturn(allGenres);

        cachedGenreDao.setNextUpdateTime(LocalDateTime.now());
        // fill cache
        cachedGenreDao.getAll();
        List<Genre> genreList = cachedGenreDao.getAll();

        assertEquals(4, genreList.size());
        assertTrue(genreList.contains(DRAMA));
        assertTrue(genreList.contains(CRIMINAL));
        assertTrue(genreList.contains(FANTASY));
        assertTrue(genreList.contains(DETECTIVE));

        verify(genreDao, times(1)).getAll();
        verifyNoMoreInteractions(genreDao);
    }
}