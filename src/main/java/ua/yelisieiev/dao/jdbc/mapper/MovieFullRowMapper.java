package ua.yelisieiev.dao.jdbc.mapper;

import org.springframework.jdbc.core.RowMapper;
import ua.yelisieiev.entity.Movie;
import ua.yelisieiev.entity.MovieFull;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieFullRowMapper implements RowMapper<MovieFull> {
    @Override
    public MovieFull mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return MovieFull.builder()
                .id(resultSet.getInt("id"))
                .nameRussian(resultSet.getString("name_russian"))
                .nameNative(resultSet.getString("name_native"))
                .yearOfRelease(resultSet.getDate("year_of_release").toLocalDate())
                .rating(resultSet.getDouble("rating"))
                .price(resultSet.getDouble("price"))
                .picturePath(resultSet.getString("picture_path"))
                .description(resultSet.getString("description"))
                .build();

    }
}
