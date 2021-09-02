package ua.yelisieiev.dao.jdbc;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ua.yelisieiev.dao.MovieDao;
import ua.yelisieiev.entity.Movie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcMovieDao implements MovieDao {
    private static final RowMapper<Movie> MOVIE_ROW_MAPPER = new RowMovieMapper();
    private final JdbcTemplate jdbcTemplate;

    public JdbcMovieDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Movie> getAll() {
        return jdbcTemplate.query("SELECT id, name_russian, name_native, year_of_release, rating, price, picture_path " +
                "FROM movieland.movie;", MOVIE_ROW_MAPPER);
    }
}
