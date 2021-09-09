package ua.yelisieiev.dao;

import ua.yelisieiev.entity.Review;

import java.util.List;

public interface ReviewDao {
    List<Review> getListForMovie(int movieId);
}
