package ua.yelisieiev.dao.jdbc;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ua.yelisieiev.dao.MovieDao;
import ua.yelisieiev.dao.jdbc.mapper.MovieFullRowMapper;
import ua.yelisieiev.dao.jdbc.mapper.MovieRowMapper;
import ua.yelisieiev.entity.Movie;
import ua.yelisieiev.entity.MovieFull;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class JdbcMovieDao implements MovieDao {
    private static final RowMapper<Movie> MOVIE_ROW_MAPPER = new MovieRowMapper();
    private static final RowMapper<MovieFull> MOVIE_FULL_ROW_MAPPER = new MovieFullRowMapper();
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
    public List<Movie> getAllSorted(String sortedAttribute, String sortingType) {
        log.info("Get all movies sorted request received");
        return jdbcTemplate.query(
                "SELECT id, name_russian, name_native, year_of_release, rating, price, picture_path " +
                        "FROM movieland.movie " +
                        "ORDER BY " + sortedAttribute + " " + sortingType,
                MOVIE_ROW_MAPPER);
    }

    @Override
    public List<Movie> getRandoms(int count) {
        log.info("Get {} random movies request received", count);
        // todo will work slowly on a large set of rows;
        //  could implement sequential single-row queries for that case
        return jdbcTemplate.query(
                "SELECT id, name_russian, name_native, year_of_release, rating, price, picture_path " +
                        "FROM movieland.movie " +
                        "ORDER BY random() " +
                        "LIMIT ?",
                MOVIE_ROW_MAPPER,
                count);
    }

    @Override
    public List<Movie> getMoviesByGenre(int genreId) {
        log.info("Get movies for genre {} request received", genreId);
        return jdbcTemplate.query(
                "SELECT id, name_russian, name_native, year_of_release, rating, price, picture_path " +
                        "FROM movieland.movie m JOIN " +
                        "movieland.movie_genre mg ON " +
                        "m.id = mg.movie_id " +
                        "WHERE mg.genre_id = ?",
                MOVIE_ROW_MAPPER,
                genreId);
    }

    @Override
    public List<Movie> getMoviesByGenreSorted(int genreId, String sortedAttribute, String sortingType) {
        log.info("Get movies for genre {} sorted request received", genreId);
        return jdbcTemplate.query(
                "SELECT id, name_russian, name_native, year_of_release, rating, price, picture_path " +
                        "FROM movieland.movie m JOIN " +
                        "movieland.movie_genre mg ON " +
                        "m.id = mg.movie_id " +
                        "WHERE mg.genre_id = ? " +
                        "ORDER BY " + sortedAttribute + " " + sortingType,
                MOVIE_ROW_MAPPER,
                genreId);
    }

    @Override
    public MovieFull getSingle(int movieId) {
        return jdbcTemplate.queryForObject("SELECT id, name_russian, name_native, year_of_release, " +
                "description, rating, price, picture_path " +
                "FROM movieland.movie m " +
                "WHERE m.id = ?", MOVIE_FULL_ROW_MAPPER, movieId);
    }
}
