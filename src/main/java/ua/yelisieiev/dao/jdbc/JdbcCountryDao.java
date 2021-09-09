package ua.yelisieiev.dao.jdbc;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.yelisieiev.dao.CountryDao;
import ua.yelisieiev.dao.jdbc.mapper.CountryRowMapper;
import ua.yelisieiev.entity.Country;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class JdbcCountryDao implements CountryDao {
    private static final CountryRowMapper COUNTRY_ROW_MAPPER = new CountryRowMapper();
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Country> getListForMovie(int movieId) {
        return jdbcTemplate.query("SELECT c.id, c.name " +
                "FROM movieland.country c join movieland.movie_country mc " +
                "ON c.id = mc.country_id " +
                "WHERE mc.movie_id = ?", COUNTRY_ROW_MAPPER, movieId);
    }
}
