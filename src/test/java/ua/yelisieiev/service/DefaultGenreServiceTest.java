package ua.yelisieiev.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ua.yelisieiev.dao.GenreDao;
import ua.yelisieiev.entity.Genre;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static ua.yelisieiev.common.MockGenres.*;

class DefaultGenreServiceTest {
    private DefaultGenreService genreService;
    private GenreDao genreDao;
    private List<Genre> allGenres;

    @BeforeEach
    void setUp() {
        genreDao = mock(GenreDao.class);
        genreService = new DefaultGenreService(genreDao);

        allGenres = List.of(DRAMA,
                CRIMINAL,
                FANTASY,
                DETECTIVE);

    }

    @DisplayName("On mocked jdbc - get all genres")
    @Test
    void test_getAllGenres() {
        when(genreDao.getAll()).thenReturn(allGenres);
        List<Genre> genreList = genreService.getAll();

        assertEquals(4, genreList.size());
        assertTrue(genreList.contains(DRAMA));
        assertTrue(genreList.contains(CRIMINAL));
        assertTrue(genreList.contains(DETECTIVE));
        assertTrue(genreList.contains(FANTASY));

        verify(genreDao, times(1)).getAll();
        verifyNoMoreInteractions(genreDao);
    }

    @DisplayName("On mocked dao - get genre list for a movie")
    @Test
    void test_getListForMovie() {
        when(genreDao.getListForMovie(1)).thenReturn(List.of(DRAMA, CRIMINAL));

        List<Genre> genres = genreService.getListForMovie(1);
        assertNotNull(genres);
        assertEquals(1, genres.get(0).getId());
        assertEquals("драма", genres.get(0).getName());
        assertEquals(2, genres.get(1).getId());
        assertEquals("криминал", genres.get(1).getName());

        verify(genreDao).getListForMovie(1);
        verifyNoMoreInteractions(genreDao);
    }
}