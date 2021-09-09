package ua.yelisieiev.dao.jdbc.mapper;

import org.springframework.jdbc.core.RowMapper;
import ua.yelisieiev.entity.Review;
import ua.yelisieiev.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewRowMapper implements RowMapper<Review> {
    @Override
    public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Review.builder()
                .id(rs.getInt("id"))
                .text(rs.getString("description"))
                .user(User.builder()
                        .id(rs.getInt("user_id"))
                        .nickname(rs.getString("nickname"))
                        .build())
                .build();
    }
}
