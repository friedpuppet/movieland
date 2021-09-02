package ua.yelisieiev.web.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ua.yelisieiev.entity.Movie;
import ua.yelisieiev.service.DefaultMovieService;
import ua.yelisieiev.service.MovieService;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class MoviesControllerTest {

    private MockMvc mockMvc;
    private Movie shawshankRedemption;
    private Movie greenMile;
    private MovieService movieService;

    @BeforeEach
    void setUp() {
        shawshankRedemption = Movie.builder()
                .id(1)
                .nameNative("The Shawshank Redemption")
                .nameRussian("Побег из Шоушенка")
                .yearOfRelease(LocalDate.of(1994, 01, 01))
                .build();
        greenMile = Movie.builder()
                .id(2)
                .nameNative("The Green Mile")
                .nameRussian("Зеленая миля")
                .yearOfRelease(LocalDate.of(1999, 01, 01))
                .build();

        movieService = mock(DefaultMovieService.class);

        mockMvc = MockMvcBuilders.standaloneSetup(new MoviesController(movieService))
                .build();
    }

    @DisplayName("With test data - request all movies - get the list")
    @Test
    void test_getAllMovies() throws Exception {
        List<Movie> movies = List.of(shawshankRedemption, greenMile);
        when(movieService.getAll()).thenReturn(movies);

        mockMvc.perform(get("/movie/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))

                // todo the order??
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
}