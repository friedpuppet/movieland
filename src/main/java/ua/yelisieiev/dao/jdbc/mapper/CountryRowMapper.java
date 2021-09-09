package ua.yelisieiev.dao.jdbc.mapper;

import org.springframework.jdbc.core.RowMapper;
import ua.yelisieiev.entity.Country;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CountryRowMapper implements RowMapper<Country> {
    @Override
    public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Country(rs.getInt("id"), rs.getString("name"));
    }
}
