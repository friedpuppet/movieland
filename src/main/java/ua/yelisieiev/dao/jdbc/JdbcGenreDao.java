package ua.yelisieiev.dao.jdbc;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ua.yelisieiev.dao.GenreDao;
import ua.yelisieiev.dao.jdbc.mapper.GenreRowMapper;
import ua.yelisieiev.entity.Genre;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class JdbcGenreDao implements GenreDao {
    private final JdbcTemplate jdbcTemplate;
    private static final RowMapper<Genre> ROW_GENRE_MAPPER = new GenreRowMapper();

    @Override
    public List<Genre> getAll() {
        log.info("Get all genres request received");
        return jdbcTemplate.query("SELECT id, name FROM movieland.genre", ROW_GENRE_MAPPER);
    }

    @Override
    public List<Genre> getListForMovie(int movieId) {
        return jdbcTemplate.query("SELECT g.id, g.name " +
                "FROM movieland.genre g join movieland.movie_genre mg " +
                "ON g.id = mg.genre_id " +
                "WHERE mg.movie_id = ?", ROW_GENRE_MAPPER, movieId);
    }
}
