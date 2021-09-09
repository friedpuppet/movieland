package ua.yelisieiev.web.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ua.yelisieiev.entity.Genre;
import ua.yelisieiev.service.GenreService;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ua.yelisieiev.common.MockGenres.*;

class GenreControllerTest {
    private MockMvc mockMvc;
    private GenreService genreService;
    private List<Genre> allGenres;

    @BeforeEach
    void setUp() {
        genreService = mock(GenreService.class);
        allGenres = List.of(DRAMA,
                CRIMINAL,
                FANTASY,
                DETECTIVE);

        mockMvc = MockMvcBuilders.standaloneSetup(new GenreController(genreService))
                .build();
    }

    @DisplayName("On mocked service - get all genres")
    @Test
    void test_get_allGenres() throws Exception {
        when(genreService.getAll()).thenReturn(allGenres);

        mockMvc.perform(get("/genre")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)))

                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("драма"))

                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("криминал"))

                .andExpect(jsonPath("$[2].id").value(3))
                .andExpect(jsonPath("$[2].name").value("фэнтези"))

                .andExpect(jsonPath("$[3].id").value(4))
                .andExpect(jsonPath("$[3].name").value("детектив"));

        verify(genreService, times(1)).getAll();
        verifyNoMoreInteractions(genreService);
    }
}