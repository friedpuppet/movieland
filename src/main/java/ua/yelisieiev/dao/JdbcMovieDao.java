package ua.yelisieiev.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ua.yelisieiev.entity.Movie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcMovieDao {
    private static final BeanPropertyRowMapper<Movie> MOVIE_ROW_MAPPER = new BeanPropertyRowMapper<>(Movie.class);
//    private static final RowMapper<Movie> MOVIE_ROW_MAPPER = (rs, rowNum) -> rowToMovie(rs);
    private final JdbcTemplate jdbcTemplate;

    public JdbcMovieDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Movie> getAll() {
        return jdbcTemplate.query("SELECT id, name_russian, name_native, year_of_release, description, rating, price, picture_path, votes " +
                "FROM movieland.movie;", MOVIE_ROW_MAPPER);
    }

//    private static Movie rowToMovie(ResultSet resultSet) throws SQLException {
//
//        return Movie.builder()
//                .id(resultSet.getInt("id"))
//                .name_russian(resultSet.getString("name_russian"))
//                .name_native(resultSet.getString("name_native"))
//                .year_of_release(resultSet.getDate("year_of_release").toLocalDate())
//                .description(resultSet.getString("description"))
//                .rating(resultSet.getDouble("rating"))
//                .price(resultSet.getDouble("price"))
//                .picture_path(resultSet.getString("picture_path"))
//                .votes(resultSet.getInt("votes"))
//                .build();
//    }

}
