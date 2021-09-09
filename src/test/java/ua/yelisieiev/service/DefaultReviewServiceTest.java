package ua.yelisieiev.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ua.yelisieiev.dao.ReviewDao;
import ua.yelisieiev.entity.Review;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static ua.yelisieiev.common.MockReviews.*;

class DefaultReviewServiceTest {
    private ReviewService reviewService;
    private ReviewDao reviewDao;

    @BeforeEach
    void setUp() {
        reviewDao = mock(ReviewDao.class);
        reviewService = new DefaultReviewService(reviewDao);
    }

    @DisplayName("On mocked dao - get reviews for a movie")
    @Test
    void getListForMovie() {
        when(reviewDao.getListForMovie(1)).thenReturn(List.of(SHAWSHANK_REVIEW_1_FULL, SHAWSHANK_REVIEW_2_FULL));

        List<Review> reviews =  reviewService.getListForMovie(1);
        assertNotNull(reviews);

        assertEquals(reviews.size(), 2);
        assertEquals(1, reviews.get(0).getId());
        assertEquals(3, reviews.get(0).getUser().getId());
        assertEquals(2, reviews.get(1).getId());
        assertEquals(4, reviews.get(1).getUser().getId());

        verify(reviewDao, times(1)).getListForMovie(1);
        verifyNoMoreInteractions(reviewDao);
    }
}