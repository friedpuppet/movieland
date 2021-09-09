package ua.yelisieiev.dao.jdbc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import ua.yelisieiev.dao.ReviewDao;
import ua.yelisieiev.dao.jdbc.mapper.ReviewRowMapper;
import ua.yelisieiev.entity.Review;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static ua.yelisieiev.common.MockReviews.SHAWSHANK_REVIEW_1_FULL;
import static ua.yelisieiev.common.MockReviews.SHAWSHANK_REVIEW_2_FULL;

class JdbcReviewDaoTest {
    private ReviewDao reviewDao;
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setUp() {
        jdbcTemplate = mock(JdbcTemplate.class);
        reviewDao = new JdbcReviewDao(jdbcTemplate);
    }


    @DisplayName("On mocked jdbc - get review list for a movie")
    @Test
    void getListForMovie() {
        when(jdbcTemplate.query(anyString(), any(ReviewRowMapper.class), anyInt()))
                .thenReturn(List.of(SHAWSHANK_REVIEW_1_FULL, SHAWSHANK_REVIEW_2_FULL));

        List<Review> reviews = reviewDao.getListForMovie(1);

        assertNotNull(reviews);
        assertEquals(2, reviews.size());
        assertEquals(1, reviews.get(0).getId());
        assertEquals(3, reviews.get(0).getUser().getId());
        assertEquals(2, reviews.get(1).getId());
        assertEquals(4, reviews.get(1).getUser().getId());

        verify(jdbcTemplate, times(1)).query(anyString(), any(ReviewRowMapper.class), anyInt());
        verifyNoMoreInteractions(jdbcTemplate);
    }
}