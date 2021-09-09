package ua.yelisieiev.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ua.yelisieiev.dao.CountryDao;
import ua.yelisieiev.entity.Country;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static ua.yelisieiev.common.MockCountries.USA;

class DefaultCountryServiceTest {
    private CountryService countryService;
    private CountryDao countryDao;

    @BeforeEach
    void setUp() {
        countryDao = mock(CountryDao.class);
        countryService = new DefaultCountryService(countryDao);
    }

    @DisplayName("On mocked dao - get countries list for a movie")
    @Test
    void test_getListForMovie() {
        when(countryDao.getListForMovie(1)).thenReturn(List.of(USA));

        List<Country> countries =  countryService.getListForMovie(1);
        assertNotNull(countries);
        assertEquals(1, countries.get(0).getId());
        assertEquals("США", countries.get(0).getName());

        verify(countryDao).getListForMovie(1);
        verifyNoMoreInteractions(countryDao);
    }
}