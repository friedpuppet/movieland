package ua.yelisieiev.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ua.yelisieiev.dao.MovieDao;
import ua.yelisieiev.entity.Movie;
import ua.yelisieiev.entity.MovieFull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static ua.yelisieiev.common.MockCountries.USA;
import static ua.yelisieiev.common.MockGenres.CRIMINAL;
import static ua.yelisieiev.common.MockGenres.DRAMA;
import static ua.yelisieiev.common.MockMovies.*;
import static ua.yelisieiev.common.MockReviews.SHAWSHANK_REVIEW_1_FULL;
import static ua.yelisieiev.common.MockReviews.SHAWSHANK_REVIEW_2_FULL;

class DefaultMovieServiceTest {
    private MovieService movieService;
    private GenreService genreService;
    private CountryService countryService;
    private ReviewService reviewService;
    private MovieDao movieDao;

    @BeforeEach
    void setUp() {
        movieDao = mock(MovieDao.class);
        genreService = mock(GenreService.class);
        countryService = mock(DefaultCountryService.class);
        reviewService = mock(DefaultReviewService.class);
        movieService = new DefaultMovieService(movieDao, countryService, genreService, reviewService);
    }

    @DisplayName("Get all movies")
    @Test
    void test_getAllMovies() {
        List<Movie> movies = List.of(SHAWSHANK_REDEMPTION, GREEN_MILE);
        when(movieDao.getAll()).thenReturn(movies);
        List<Movie> movieList = movieService.getAll();

        assertEquals(2, movieList.size());
        assertTrue(movieList.contains(SHAWSHANK_REDEMPTION));
        assertTrue(movieList.contains(GREEN_MILE));

        verify(movieDao, times(1)).getAll();
        verifyNoMoreInteractions(movieDao);
    }

    @DisplayName("Get all movies sorted by rating desc")
    @Test
    void test_getAllMoviesSortedByRatingDesc() {
        List<Movie> movies = List.of(SHAWSHANK_REDEMPTION, GREEN_MILE, FORREST_GUMP, INCEPTION);
        when(movieDao.getAllSorted(anyString(), anyString())).thenReturn(movies);
        List<Movie> movieList = movieService.getAllSorted("rating", "desc");

        assertEquals(4, movieList.size());
        assertEquals(0, movieList.indexOf(SHAWSHANK_REDEMPTION));
        assertEquals(1, movieList.indexOf(GREEN_MILE));
        assertEquals(2, movieList.indexOf(FORREST_GUMP));
        assertEquals(3, movieList.indexOf(INCEPTION));

        verify(movieDao, times(1)).getAllSorted(anyString(), anyString());
        verifyNoMoreInteractions(movieDao);
    }

    @DisplayName("Get all movies sorted by price desc")
    @Test
    void test_getAllMoviesSortedByPriceDesc() {
        List<Movie> movies = List.of(FORREST_GUMP, GREEN_MILE, INCEPTION, SHAWSHANK_REDEMPTION);
        when(movieDao.getAllSorted(anyString(), anyString())).thenReturn(movies);
        List<Movie> movieList = movieService.getAllSorted("price", "desc");

        assertEquals(4, movieList.size());
        assertEquals(0, movieList.indexOf(FORREST_GUMP));
        assertEquals(1, movieList.indexOf(GREEN_MILE));
        assertEquals(2, movieList.indexOf(INCEPTION));
        assertEquals(3, movieList.indexOf(SHAWSHANK_REDEMPTION));

        verify(movieDao, times(1)).getAllSorted(anyString(), anyString());
        verifyNoMoreInteractions(movieDao);
    }

    @DisplayName("Get all movies sorted by rating asc")
    @Test
    void test_getAllMoviesSortedByPriceAsc() {
        List<Movie> movies = List.of(SHAWSHANK_REDEMPTION, INCEPTION, GREEN_MILE, FORREST_GUMP);
        when(movieDao.getAllSorted(anyString(), anyString())).thenReturn(movies);
        List<Movie> movieList = movieService.getAllSorted("price", "asc");

        assertEquals(4, movieList.size());
        assertEquals(0, movieList.indexOf(SHAWSHANK_REDEMPTION));
        assertEquals(1, movieList.indexOf(INCEPTION));
        assertEquals(2, movieList.indexOf(GREEN_MILE));
        assertEquals(3, movieList.indexOf(FORREST_GUMP));

        verify(movieDao, times(1)).getAllSorted(anyString(), anyString());
        verifyNoMoreInteractions(movieDao);
    }

    @DisplayName("Get three random movies")
    @Test
    void test_getThreeRandomMovies() {
        List<Movie> movies = new ArrayList<>(List.of(SHAWSHANK_REDEMPTION, GREEN_MILE, FORREST_GUMP, INCEPTION));
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
        List<Movie> movies = new ArrayList<>(List.of(SHAWSHANK_REDEMPTION, GREEN_MILE));
        when(movieDao.getMoviesByGenre(2)).thenReturn(movies);

        List<Movie> movieList = movieService.getMoviesByGenre(2);
        assertEquals(2, movieList.size());

        verify(movieDao, times(1)).getMoviesByGenre(2);
        verifyNoMoreInteractions(movieDao);
    }

    @DisplayName("With mocked dao - request movies for a particular genre sorted by rating desc")
    @Test
    void test_getMoviesByGenreSortedByRatingDesc() {
        //todo
    }

    @DisplayName("With mocked dao - request movies for a particular genre sorted by rating desc")
    @Test
    void test_getMoviesByGenreSortedByPriceDesc() {
        //todo
    }

    @DisplayName("With mocked dao - request movies for a particular genre sorted by rating asc")
    @Test
    void test_getMoviesByGenreSortedByPriceAsc() {
        //todo
    }

    @DisplayName("On mocked dao and other services - get single movie")
    @Test
    void test_getSingleMovie() {
        when(movieDao.getSingle(1)).thenReturn(getShawshankRedemptionFullNotEnriched());
        when(countryService.getListForMovie(1)).thenReturn(List.of(USA));
        when(genreService.getListForMovie(1)).thenReturn(List.of(DRAMA, CRIMINAL));
        when(reviewService.getListForMovie(1)).thenReturn(List.of(SHAWSHANK_REVIEW_1_FULL, SHAWSHANK_REVIEW_2_FULL));

        MovieFull movieFull = movieService.getSingle(1);
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

        assertEquals(1, movieFull.getCountries().size());
        assertEquals(1, movieFull.getCountries().get(0).getId());
        assertEquals("США", movieFull.getCountries().get(0).getName());

        assertEquals(2, movieFull.getGenres().size());
        assertEquals(1, movieFull.getGenres().get(0).getId());
        assertEquals("драма", movieFull.getGenres().get(0).getName());
        assertEquals(2, movieFull.getGenres().get(1).getId());
        assertEquals("криминал", movieFull.getGenres().get(1).getName());

        assertEquals(2, movieFull.getReviews().size());
        assertEquals(1, movieFull.getReviews().get(0).getId());
        assertEquals(3, movieFull.getReviews().get(0).getUser().getId());
        assertEquals(2, movieFull.getReviews().get(1).getId());
        assertEquals(4, movieFull.getReviews().get(1).getUser().getId());
    }

    @DisplayName("On mocked dao and other services - get timeout on countries - get single movie with empty countries")
    @Test
    void test_getSingleMovieCountriesTimeout() {
        when(movieDao.getSingle(1)).thenReturn(getShawshankRedemptionFullNotEnriched());
        when(countryService.getListForMovie(1)).then(invocation -> {
            Thread.sleep(6000);
            return List.of(USA);
        });
        when(genreService.getListForMovie(1)).thenReturn(List.of(DRAMA, CRIMINAL));
        when(reviewService.getListForMovie(1)).thenReturn(List.of(SHAWSHANK_REVIEW_1_FULL, SHAWSHANK_REVIEW_2_FULL));

        MovieFull movieFull = movieService.getSingle(1);
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

        assertEquals(2, movieFull.getGenres().size());
        assertEquals(1, movieFull.getGenres().get(0).getId());
        assertEquals("драма", movieFull.getGenres().get(0).getName());
        assertEquals(2, movieFull.getGenres().get(1).getId());
        assertEquals("криминал", movieFull.getGenres().get(1).getName());

        assertEquals(2, movieFull.getReviews().size());
        assertEquals(1, movieFull.getReviews().get(0).getId());
        assertEquals(3, movieFull.getReviews().get(0).getUser().getId());
        assertEquals(2, movieFull.getReviews().get(1).getId());
        assertEquals(4, movieFull.getReviews().get(1).getUser().getId());
    }

    @DisplayName("On mocked dao and other services - get timeout on all subservices - get single movie with empty countries, genres, reviews")
    @Test
    void test_getSingleMovieAllTimeout() {
        when(movieDao.getSingle(1)).thenReturn(getShawshankRedemptionFullNotEnriched());
        when(countryService.getListForMovie(1))
                .then(invocation -> {
                    Thread.sleep(6000);
                    return List.of(USA);
                });
        when(genreService.getListForMovie(1))
                .then(invocation -> {
                    Thread.sleep(6000);
                    return List.of(DRAMA, CRIMINAL);
                });
        when(reviewService.getListForMovie(1))
                .then(invocation -> {
                    Thread.sleep(6000);
                    return List.of(SHAWSHANK_REVIEW_1_FULL, SHAWSHANK_REVIEW_2_FULL);
                });

        MovieFull movieFull = movieService.getSingle(1);
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
    }
}