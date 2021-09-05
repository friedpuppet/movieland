package ua.yelisieiev.dao.jdbc;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ua.yelisieiev.dao.MovieDao;
import ua.yelisieiev.entity.Movie;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class JdbcMovieDao implements MovieDao {
    private static final RowMapper<Movie> MOVIE_ROW_MAPPER = new RowMovieMapper();
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Movie> getAll() {
        log.info("Get all movies request received");
        return jdbcTemplate.query(
                "SELECT id, name_russian, name_native, year_of_release, rating, price, picture_path " +
                        "FROM movieland.movie;",
                MOVIE_ROW_MAPPER);
    }

    @Override
    public List<Movie> getRandoms(int count) {
        log.info("Get {} random movies request received", count);
        // todo will work slowly on a large set of rows;
        //  could implement sequential single-row queries for that case
        return jdbcTemplate.query(
                "SELECT id, name_russian, name_native, year_of_release, rating, price, picture_path " +
                        "from movieland.movie " +
                        "order by random() " +
                        "limit ?",
                MOVIE_ROW_MAPPER,
                count);
    }
}
