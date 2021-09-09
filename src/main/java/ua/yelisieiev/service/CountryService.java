package ua.yelisieiev.service;

import ua.yelisieiev.entity.Country;

import java.util.List;

public interface CountryService {
    List<Country> getListForMovie(int movieId);
}
