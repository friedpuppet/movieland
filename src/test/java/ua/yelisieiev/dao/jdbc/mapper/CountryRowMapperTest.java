package ua.yelisieiev.dao.jdbc.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ua.yelisieiev.entity.Country;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CountryRowMapperTest {
    CountryRowMapper countryRowMapper = new CountryRowMapper();
    ResultSet resultSet = mock(ResultSet.class);

    @DisplayName("On mocked resultset - get Country")
    @Test
    void mapRow() throws SQLException {
        when(resultSet.getInt("id")).thenReturn(1);
        when(resultSet.getString("name")).thenReturn("США");

        Country country = countryRowMapper.mapRow(resultSet, 1);

        assertNotNull(country);
        assertEquals(1, country.getId());
        assertEquals("США", country.getName());
    }
}