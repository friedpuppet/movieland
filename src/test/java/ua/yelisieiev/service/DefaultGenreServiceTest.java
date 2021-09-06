package ua.yelisieiev.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ua.yelisieiev.common.MockGenresFactory;
import ua.yelisieiev.dao.GenreDao;
import ua.yelisieiev.entity.Genre;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class DefaultGenreServiceTest {
    private DefaultGenreService genreService;
    private GenreDao genreDao;
    private List<Genre> allGenres;
    private Genre drama;
    private Genre criminal;
    private Genre fantasy;
    private Genre detective;

    @BeforeEach
    void setUp() {
        genreDao = mock(GenreDao.class);
        genreService = new DefaultGenreService(genreDao);

        drama = MockGenresFactory.getGenre("драма");
        criminal = MockGenresFactory.getGenre("криминал");
        fantasy = MockGenresFactory.getGenre("фэнтези");
        detective = MockGenresFactory.getGenre("детектив");

        allGenres = List.of(drama,
                criminal,
                fantasy,
                detective);

    }

    @DisplayName("On mocked jdbc - get all genres")
    @Test
    void test_getAllGenres() {
        when(genreDao.getAll()).thenReturn(allGenres);
        List<Genre> genreList = genreService.getAll();

        assertEquals(4, genreList.size());
        assertTrue(genreList.contains(drama));
        assertTrue(genreList.contains(criminal));
        assertTrue(genreList.contains(detective));
        assertTrue(genreList.contains(fantasy));

        verify(genreDao, times(1)).getAll();
        verifyNoMoreInteractions(genreDao);
    }

}