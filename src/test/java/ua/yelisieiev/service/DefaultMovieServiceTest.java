package ua.yelisieiev.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ua.yelisieiev.common.MockMoviesFactory;
import ua.yelisieiev.dao.MovieDao;
import ua.yelisieiev.entity.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class DefaultMovieServiceTest {
    private final Movie shawshankRedemption = MockMoviesFactory.getshawshankRedemption();
    private final Movie greenMile = MockMoviesFactory.getGreenMile();
    private final Movie forrestGump = MockMoviesFactory.getForrestGump();
    private final Movie inception = MockMoviesFactory.getInception();
    private final Movie snatch = MockMoviesFactory.getSnatch();

    private MovieService movieService;
    private MovieDao movieDao;

    @BeforeEach
    void setUp() {
        movieDao = mock(MovieDao.class);
        movieService = new DefaultMovieService(movieDao);
    }

    @DisplayName("Get all movies")
    @Test
    void test_getAllMovies() {
        List<Movie> movies = List.of(shawshankRedemption, greenMile);
        when(movieDao.getAll()).thenReturn(movies);
        List<Movie> movieList = movieService.getAll();

        assertEquals(2, movieList.size());
        assertTrue(movieList.contains(shawshankRedemption));
        assertTrue(movieList.contains(greenMile));

        verify(movieDao, times(1)).getAll();
        verifyNoMoreInteractions(movieDao);
    }

    @DisplayName("Get all movies sorted by rating desc")
    @Test
    void test_getAllMoviesSortedByRatingDesc() {
        List<Movie> movies = List.of(shawshankRedemption, greenMile, forrestGump, inception);
        when(movieDao.getAllSorted(anyString(), anyString())).thenReturn(movies);
        List<Movie> movieList = movieService.getAllSorted("rating", "desc");

        assertEquals(4, movieList.size());
        assertEquals(0, movieList.indexOf(shawshankRedemption));
        assertEquals(1, movieList.indexOf(greenMile));
        assertEquals(2, movieList.indexOf(forrestGump));
        assertEquals(3, movieList.indexOf(inception));

        verify(movieDao, times(1)).getAllSorted(anyString(), anyString());
        verifyNoMoreInteractions(movieDao);
    }

    @DisplayName("Get all movies sorted by price desc")
    @Test
    void test_getAllMoviesSortedByPriceDesc() {
        List<Movie> movies = List.of(forrestGump, greenMile, inception, shawshankRedemption);
        when(movieDao.getAllSorted(anyString(), anyString())).thenReturn(movies);
        List<Movie> movieList = movieService.getAllSorted("price", "desc");

        assertEquals(4, movieList.size());
        assertEquals(0, movieList.indexOf(forrestGump));
        assertEquals(1, movieList.indexOf(greenMile));
        assertEquals(2, movieList.indexOf(inception));
        assertEquals(3, movieList.indexOf(shawshankRedemption));

        verify(movieDao, times(1)).getAllSorted(anyString(), anyString());
        verifyNoMoreInteractions(movieDao);
    }

    @DisplayName("Get all movies sorted by rating asc")
    @Test
    void test_getAllMoviesSortedByPriceAsc() {
        List<Movie> movies = List.of(shawshankRedemption, inception, greenMile, forrestGump);
        when(movieDao.getAllSorted(anyString(), anyString())).thenReturn(movies);
        List<Movie> movieList = movieService.getAllSorted("price", "asc");

        assertEquals(4, movieList.size());
        assertEquals(0, movieList.indexOf(shawshankRedemption));
        assertEquals(1, movieList.indexOf(inception));
        assertEquals(2, movieList.indexOf(greenMile));
        assertEquals(3, movieList.indexOf(forrestGump));

        verify(movieDao, times(1)).getAllSorted(anyString(), anyString());
        verifyNoMoreInteractions(movieDao);
    }

    @DisplayName("Get three random movies")
    @Test
    void test_getThreeRandomMovies() {
        List<Movie> movies = new ArrayList<>(List.of(shawshankRedemption, greenMile, forrestGump, inception));
        movies.remove(new Random(System.nanoTime()).nextInt(3));
        when(movieDao.getRandoms(3)).thenReturn(movies);

        List<Movie> movieList = movieService.getRandomMovies(3);
        assertEquals(3, movieList.size());

        verify(movieDao, times(1)).getRandoms(3);
        verifyNoMoreInteractions(movieDao);
    }

    @DisplayName("With mocked dao - request movies for a particular genre - get the list")
    @Test
    void test_getMoviesByGenre() {
        List<Movie> movies = new ArrayList<>(List.of(shawshankRedemption, greenMile));
        when(movieDao.getMoviesByGenre(2)).thenReturn(movies);

        List<Movie> movieList = movieService.getMoviesByGenre(2);
        assertEquals(2, movieList.size());

        verify(movieDao, times(1)).getMoviesByGenre(2);
        verifyNoMoreInteractions(movieDao);
    }

    @DisplayName("With mocked dao - request movies for a particular genre sorted by rating desc")
    @Test
    void test_getMoviesByGenreSortedByRatingDesc() {
    }

    @DisplayName("With mocked dao - request movies for a particular genre sorted by rating desc")
    @Test
    void test_getMoviesByGenreSortedByPriceDesc() {
    }

    @DisplayName("With mocked dao - request movies for a particular genre sorted by rating asc")
    @Test
    void test_getMoviesByGenreSortedByPriceAsc() {
    }

}