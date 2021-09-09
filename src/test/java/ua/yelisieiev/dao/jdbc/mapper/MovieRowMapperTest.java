package ua.yelisieiev.dao.jdbc.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ua.yelisieiev.entity.Movie;
import ua.yelisieiev.entity.MovieFull;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MovieRowMapperTest {
    MovieRowMapper movieRowMapper = new MovieRowMapper();
    ResultSet resultSet = mock(ResultSet.class);

    @DisplayName("On mocked resultset - get movie")
    @Test
    void mapRow() throws SQLException {
        when(resultSet.getInt("id")).thenReturn(1);
        when(resultSet.getString("name_russian")).thenReturn("Побег из Шоушенка");
        when(resultSet.getString("name_native")).thenReturn("The Shawshank Redemption");
        when(resultSet.getDate("year_of_release")).thenReturn(Date.valueOf(LocalDate.of(1994, 1, 1)));
        when(resultSet.getDouble("rating")).thenReturn(8.9);
        when(resultSet.getDouble("price")).thenReturn(123.45);
        when(resultSet.getString("picture_path")).thenReturn("https://images-na.ssl-images-amazon.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1._SY209_CR0,0,140,209_.jpg");

        Movie movie = movieRowMapper.mapRow(resultSet, 1);

        assertNotNull(movie);
        assertEquals(1, movie.getId());
        assertEquals("The Shawshank Redemption", movie.getNameNative());
        assertEquals("Побег из Шоушенка", movie.getNameRussian());
        assertEquals(LocalDate.of(1994, 1, 1), movie.getYearOfRelease());
        assertEquals(123.45, movie.getPrice());
        assertEquals(8.9, movie.getRating());
        assertEquals("https://images-na.ssl-images-amazon.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1._SY209_CR0,0,140,209_.jpg",
                movie.getPicturePath());
    }
}