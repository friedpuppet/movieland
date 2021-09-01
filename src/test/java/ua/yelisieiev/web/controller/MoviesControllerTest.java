package ua.yelisieiev.web.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ua.yelisieiev.entity.Movie;
import ua.yelisieiev.service.MovieService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

class MoviesControllerTest {

    private MockMvc mockMvc;
    private Movie shawshankRedemption;
    private Movie greenMile;
    private MovieService movieService;

    @BeforeEach
    void setUp() {
        shawshankRedemption = Movie.builder()
                .id(1)
                .name_native("The Shawshank Redemption")
                .name_russian("Побег из Шоушенка")
                .year_of_release(LocalDate.of(1994, 01, 01))
                .build();
        greenMile = Movie.builder()
                .id(2)
                .name_native("The Green Mile")
                .name_russian("Зеленая миля")
                .year_of_release(LocalDate.of(1999, 01, 01))
                .build();

        movieService = mock(MovieService.class);

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
                .andExpect(jsonPath("$[0].name_native").value("The Shawshank Redemption"))
                .andExpect(jsonPath("$[0].name_russian").value("Побег из Шоушенка"))
                .andExpect(jsonPath("$[0].year_of_release").value("1994-01-01"))

                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name_native").value("The Green Mile"))
                .andExpect(jsonPath("$[1].name_russian").value("Зеленая миля"))
                .andExpect(jsonPath("$[1].year_of_release").value("1999-01-01"));

        verify(movieService, times(1)).getAll();
        verifyNoMoreInteractions(movieService);
    }
}