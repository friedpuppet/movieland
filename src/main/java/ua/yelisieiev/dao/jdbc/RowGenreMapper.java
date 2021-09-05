package ua.yelisieiev.dao.jdbc;

import org.springframework.jdbc.core.RowMapper;
import ua.yelisieiev.entity.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowGenreMapper implements RowMapper<Genre> {
    @Override
    public Genre mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return Genre.builder()
                .id(resultSet.getInt("id"))
                .name(resultSet.getString("name"))
                .build();
    }
}
