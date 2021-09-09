package ua.yelisieiev.dao;

import ua.yelisieiev.entity.Country;

import java.util.List;

public interface CountryDao {
    List<Country> getListForMovie(int movieId);
}
