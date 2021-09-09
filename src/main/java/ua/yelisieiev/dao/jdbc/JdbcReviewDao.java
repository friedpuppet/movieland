package ua.yelisieiev.dao.jdbc;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.yelisieiev.dao.ReviewDao;
import ua.yelisieiev.dao.jdbc.mapper.ReviewRowMapper;
import ua.yelisieiev.entity.Review;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class JdbcReviewDao implements ReviewDao {
    private static final ReviewRowMapper ROW_REVIEW_MAPPER = new ReviewRowMapper();
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Review> getListForMovie(int movieId) {
        return jdbcTemplate.query("SELECT r.id, r.description, u.id as user_id, u.nickname " +
                "FROM movieland.review r JOIN movieland.user u ON r.user_id = u.id " +
                "WHERE r.movie_id = ?", ROW_REVIEW_MAPPER, movieId);
    }
}
