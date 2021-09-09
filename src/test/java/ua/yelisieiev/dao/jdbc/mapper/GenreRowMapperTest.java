package ua.yelisieiev.dao.jdbc.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ua.yelisieiev.entity.Country;
import ua.yelisieiev.entity.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GenreRowMapperTest {
    GenreRowMapper genreRowMapper = new GenreRowMapper();
    ResultSet resultSet = mock(ResultSet.class);

    @DisplayName("On mocked resultset - get Genre")
    @Test
    void mapRow() throws SQLException {
        when(resultSet.getInt("id")).thenReturn(1);
        when(resultSet.getString("name")).thenReturn("драма");

        Genre genre = genreRowMapper.mapRow(resultSet, 1);

        assertNotNull(genre);
        assertEquals(1, genre.getId());
        assertEquals("драма", genre.getName());
    }
}