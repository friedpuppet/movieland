package ua.yelisieiev.web.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ua.yelisieiev.common.MockMoviesFactory;
import ua.yelisieiev.entity.Movie;
import ua.yelisieiev.service.MovieService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class MovieControllerTest {

    private MockMvc mockMvc;
    private final Movie shawshankRedemption = MockMoviesFactory.getshawshankRedemption();
    private final Movie greenMile = MockMoviesFactory.getGreenMile();
    private final Movie forrestGump = MockMoviesFactory.getForrestGump();
    private final Movie inception = MockMoviesFactory.getInception();
    private final Movie snatch = MockMoviesFactory.getSnatch();

    private MovieService movieService;

    @BeforeEach
    void setUp() {
        movieService = mock(MovieService.class);

        mockMvc = MockMvcBuilders.standaloneSetup(new MovieController(movieService))
                .build();
    }

    @DisplayName("With test data - request all movies - get the list")
    @Test
    void test_getAllMovies() throws Exception {
        List<Movie> movies = List.of(shawshankRedemption, greenMile);
        when(movieService.getAll()).thenReturn(movies);

        mockMvc.perform(get("/movie")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))

                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].nameNative").value("The Shawshank Redemption"))
                .andExpect(jsonPath("$[0].nameRussian").value("Побег из Шоушенка"))
                .andExpect(jsonPath("$[0].yearOfRelease").value("1994"))

                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].nameNative").value("The Green Mile"))
                .andExpect(jsonPath("$[1].nameRussian").value("Зеленая миля"))
                .andExpect(jsonPath("$[1].yearOfRelease").value("1999"));

        verify(movieService, times(1)).getAll();
        verifyNoMoreInteractions(movieService);
    }

    @DisplayName("With test data - request all movies sorted by rating desc - get the list")
    @Test
    void test_getAllMoviesSortedByRatingDesc() throws Exception {
        List<Movie> movies = List.of(shawshankRedemption, greenMile, forrestGump, inception);
        when(movieService.getAllSorted(anyString(), anyString())).thenReturn(movies);

        mockMvc.perform(get("/movie?rating=desc")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)))

                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[2].id").value(3))
                .andExpect(jsonPath("$[3].id").value(6));

        verify(movieService, times(1)).getAllSorted(anyString(), anyString());
        verifyNoMoreInteractions(movieService);
    }

    @DisplayName("With test data - request all movies sorted by price desc - get the list")
    @Test
    void test_getAllMoviesSortedByPriceDesc() throws Exception {
        List<Movie> movies = List.of(forrestGump, greenMile, inception, shawshankRedemption);
        when(movieService.getAllSorted(anyString(), anyString())).thenReturn(movies);

        mockMvc.perform(get("/movie?price=desc")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)))

                .andExpect(jsonPath("$[0].id").value(3))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[2].id").value(6))
                .andExpect(jsonPath("$[3].id").value(1));

        verify(movieService, times(1)).getAllSorted(anyString(), anyString());
        verifyNoMoreInteractions(movieService);
    }

    @DisplayName("With test data - request all movies sorted by price asc - get the list")
    @Test
    void test_getAllMoviesSortedByPriceAsc() throws Exception {
        List<Movie> movies = List.of(shawshankRedemption, inception, greenMile, forrestGump);
        when(movieService.getAllSorted(anyString(), anyString())).thenReturn(movies);

        mockMvc.perform(get("/movie?price=asc")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)))

                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[1].id").value(6))
                .andExpect(jsonPath("$[2].id").value(2))
                .andExpect(jsonPath("$[3].id").value(3));

        verify(movieService, times(1)).getAllSorted(anyString(), anyString());
        verifyNoMoreInteractions(movieService);
    }

    @DisplayName("With test data - request three random movies - get the list")
    @Test
    void test_getThreeRandomMovies() throws Exception {
        List<Movie> movies = new ArrayList<>(List.of(shawshankRedemption, greenMile, forrestGump, inception));
        movies.remove(new Random(System.nanoTime()).nextInt(3));
        when(movieService.getRandomMovies(3)).thenReturn(movies);

        mockMvc.perform(get("/movie/random")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((jsonPath("$", hasSize(3))))
                .andExpect(jsonPath("$[0]", notNullValue()))
                .andExpect(jsonPath("$[1]", notNullValue()))
                .andExpect(jsonPath("$[2]", notNullValue()));

        verify(movieService, times(1)).getRandomMovies(3);
        verifyNoMoreInteractions(movieService);
    }

    @DisplayName("With mocked service - request movies for a particular genre - get the list")
    @Test
    void test_getMoviesByGenre() throws Exception {
        List<Movie> movies = new ArrayList<>(List.of(shawshankRedemption, greenMile, snatch));
        when(movieService.getMoviesByGenre(2)).thenReturn(movies);

        mockMvc.perform(get("/movie/genre/2")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((jsonPath("$", hasSize(3))))

                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[2].id").value(16));

        verify(movieService, times(1)).getMoviesByGenre(2);
        verifyNoMoreInteractions(movieService);
    }

    @DisplayName("With mocked service - request movies for a particular genre sorted by rating desc - get the list")
    @Test
    void test_getMoviesByGenreSortedByRatingDesc() throws Exception {
        List<Movie> movies = new ArrayList<>(List.of(shawshankRedemption, greenMile, snatch));
        when(movieService.getMoviesByGenreSorted(eq(2), anyString(), anyString())).thenReturn(movies);

        mockMvc.perform(get("/movie/genre/2?rating=desc")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((jsonPath("$", hasSize(3))))

                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[2].id").value(16));

        verify(movieService, times(1)).getMoviesByGenreSorted(eq(2), anyString(), anyString());
        verifyNoMoreInteractions(movieService);
    }

    @DisplayName("With mocked service - request movies for a particular genre sorted by price desc - get the list")
    @Test
    void test_getMoviesByGenreSortedByPriceDesc() throws Exception {
        List<Movie> movies = new ArrayList<>(List.of(snatch, greenMile, shawshankRedemption));
        when(movieService.getMoviesByGenreSorted(eq(2), anyString(), anyString())).thenReturn(movies);

        mockMvc.perform(get("/movie/genre/2?price=desc")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((jsonPath("$", hasSize(3))))

                .andExpect(jsonPath("$[0].id").value(16))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[2].id").value(1));

        verify(movieService, times(1)).getMoviesByGenreSorted(eq(2), anyString(), anyString());
        verifyNoMoreInteractions(movieService);
    }

    @DisplayName("With mocked service - request movies for a particular genre sorted by price asc - get the list")
    @Test
    void test_getMoviesByGenreSortedByPriceAsc() throws Exception {
        List<Movie> movies = new ArrayList<>(List.of(shawshankRedemption, greenMile, snatch));
        when(movieService.getMoviesByGenreSorted(eq(2), anyString(), anyString())).thenReturn(movies);

        mockMvc.perform(get("/movie/genre/2?price=asc")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((jsonPath("$", hasSize(3))))

                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[2].id").value(16));

        verify(movieService, times(1)).getMoviesByGenreSorted(eq(2), anyString(), anyString());
        verifyNoMoreInteractions(movieService);
    }
}