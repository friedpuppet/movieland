package ua.yelisieiev.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.yelisieiev.dao.ReviewDao;
import ua.yelisieiev.entity.Review;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultReviewService implements ReviewService {
    private final ReviewDao reviewDao;

    @Override
    public List<Review> getListForMovie(int movieId) {
        return reviewDao.getListForMovie(movieId);
    }
}
