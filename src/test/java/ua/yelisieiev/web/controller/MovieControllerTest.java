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
}