package ua.yelisieiev.dao.jdbc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ua.yelisieiev.dao.CountryDao;
import ua.yelisieiev.dao.jdbc.mapper.CountryRowMapper;
import ua.yelisieiev.entity.Country;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static ua.yelisieiev.common.MockCountries.USA;

class JdbcCountryDaoTest {
    private JdbcTemplate jdbcTemplate;
    private CountryDao countryDao;

    @BeforeEach
    void setUp() {
        jdbcTemplate = mock(JdbcTemplate.class);
        countryDao = new JdbcCountryDao(jdbcTemplate);
    }

    @DisplayName("On mocked jdbc - get countries list for a movie")
    @Test
    void getListForMovie() {
        when(jdbcTemplate.query(anyString(), any(CountryRowMapper.class), anyInt())).thenReturn(List.of(USA));

        List<Country> countries = countryDao.getListForMovie(1);

        assertNotNull(countries);
        assertEquals(1, countries.get(0).getId());
        assertEquals("США", countries.get(0).getName());

        verify(jdbcTemplate, times(1)).query(anyString(), any(CountryRowMapper.class), anyInt());
        verifyNoMoreInteractions(jdbcTemplate);
    }
}