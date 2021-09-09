package ua.yelisieiev.web.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
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
import static ua.yelisieiev.common.MockMovies.*;

class MovieControllerTest {

    private MockMvc mockMvc;
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
        List<Movie> movies = List.of(SHAWSHANK_REDEMPTION, GREEN_MILE);
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
        List<Movie> movies = List.of(SHAWSHANK_REDEMPTION, GREEN_MILE, FORREST_GUMP, INCEPTION);
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
        List<Movie> movies = List.of(FORREST_GUMP, GREEN_MILE, INCEPTION, SHAWSHANK_REDEMPTION);
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
        List<Movie> movies = List.of(SHAWSHANK_REDEMPTION, INCEPTION, GREEN_MILE, FORREST_GUMP);
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
        List<Movie> movies = new ArrayList<>(List.of(SHAWSHANK_REDEMPTION, GREEN_MILE, FORREST_GUMP, INCEPTION));
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
        List<Movie> movies = new ArrayList<>(List.of(SHAWSHANK_REDEMPTION, GREEN_MILE, SNATCH));
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
        List<Movie> movies = new ArrayList<>(List.of(SHAWSHANK_REDEMPTION, GREEN_MILE, SNATCH));
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
        List<Movie> movies = new ArrayList<>(List.of(SNATCH, GREEN_MILE, SHAWSHANK_REDEMPTION));
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
        List<Movie> movies = new ArrayList<>(List.of(SHAWSHANK_REDEMPTION, GREEN_MILE, SNATCH));
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

    @DisplayName("With test data - request single movie - get full data")
    @Test
    void test_getSingleMovie() throws Exception {
        when(movieService.getSingle(1)).thenReturn(SHAWSHANK_REDEMPTION_FULL);

        mockMvc.perform(get("/movie/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())

                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nameNative").value("The Shawshank Redemption"))
                .andExpect(jsonPath("$.nameRussian").value("Побег из Шоушенка"))
                .andExpect(jsonPath("$.yearOfRelease").value(1994))
                .andExpect(jsonPath("$.description", notNullValue()))
                .andExpect(jsonPath("$.price").value(123.45))
                .andExpect(jsonPath("$.rating").value(8.9))
                .andExpect(jsonPath("$.picturePath").value("https://images-na.ssl-images-amazon.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1._SY209_CR0,0,140,209_.jpg"))

                .andExpect(jsonPath("$.countries", hasSize(1)))
                .andExpect(jsonPath("$.countries[0].id").value(1))
                .andExpect(jsonPath("$.countries[0].name").value("США"))

                .andExpect(jsonPath("$.genres", hasSize(2)))
                .andExpect(jsonPath("$.genres[0].id").value(1))
                .andExpect(jsonPath("$.genres[0].name").value("драма"))
                .andExpect(jsonPath("$.genres[1].id").value(2))
                .andExpect(jsonPath("$.genres[1].name").value("криминал"))

                .andExpect(jsonPath("$.reviews", hasSize(2)))
                .andExpect(jsonPath("$.reviews[0].id").value(1))
                .andExpect(jsonPath("$.reviews[0].user.id").value(3))
                .andExpect(jsonPath("$.reviews[1].id").value(2))
                .andExpect(jsonPath("$.reviews[1].user.id").value(4));

        verify(movieService, times(1)).getSingle(1);
        verifyNoMoreInteractions(movieService);
    }
}