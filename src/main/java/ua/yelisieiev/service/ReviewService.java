package ua.yelisieiev.service;

import ua.yelisieiev.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getListForMovie(int movieId);
}
