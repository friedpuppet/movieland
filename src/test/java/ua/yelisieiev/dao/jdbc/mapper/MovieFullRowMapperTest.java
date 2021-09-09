package ua.yelisieiev.dao.jdbc.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ua.yelisieiev.entity.Genre;
import ua.yelisieiev.entity.MovieFull;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MovieFullRowMapperTest {
    MovieFullRowMapper movieFullRowMapper = new MovieFullRowMapper();
    ResultSet resultSet = mock(ResultSet.class);

    @DisplayName("On mocked resultset - get full movie")
    @Test
    void mapRow() throws SQLException {
        when(resultSet.getInt("id")).thenReturn(1);
        when(resultSet.getString("name_russian")).thenReturn("Побег из Шоушенка");
        when(resultSet.getString("name_native")).thenReturn("The Shawshank Redemption");
        when(resultSet.getDate("year_of_release")).thenReturn(Date.valueOf(LocalDate.of(1994, 1, 1)));
        when(resultSet.getString("description")).thenReturn("Успешный банкир Энди Дюфрейн обвинен в убийстве собственной жены и ее любовника. Оказавшись в тюрьме под названием Шоушенк, он сталкивается с жестокостью и беззаконием, царящими по обе стороны решетки. Каждый, кто попадает в эти стены, становится их рабом до конца жизни. Но Энди, вооруженный живым умом и доброй душой, отказывается мириться с приговором судьбы и начинает разрабатывать невероятно дерзкий план своего освобождения.");
        when(resultSet.getDouble("rating")).thenReturn(8.9);
        when(resultSet.getDouble("price")).thenReturn(123.45);
        when(resultSet.getString("picture_path")).thenReturn("https://images-na.ssl-images-amazon.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1._SY209_CR0,0,140,209_.jpg");

        MovieFull movieFull = movieFullRowMapper.mapRow(resultSet, 1);

        assertNotNull(movieFull);
        assertEquals(1, movieFull.getId());
        assertEquals("The Shawshank Redemption", movieFull.getNameNative());
        assertEquals("Побег из Шоушенка", movieFull.getNameRussian());
        assertEquals(LocalDate.of(1994, 1, 1), movieFull.getYearOfRelease());
        assertNotNull(movieFull.getDescription());
        assertEquals(123.45, movieFull.getPrice());
        assertEquals(8.9, movieFull.getRating());
        assertEquals("https://images-na.ssl-images-amazon.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1._SY209_CR0,0,140,209_.jpg",
                movieFull.getPicturePath());
        assertNull(movieFull.getCountries());
        assertNull(movieFull.getGenres());
        assertNull(movieFull.getReviews());
    }
}