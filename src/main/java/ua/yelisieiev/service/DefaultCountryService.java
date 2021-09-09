package ua.yelisieiev.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.yelisieiev.dao.CountryDao;
import ua.yelisieiev.entity.Country;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultCountryService implements CountryService {
    private final CountryDao countryDao;

    @Override
    public List<Country> getListForMovie(int movieId) {
        return countryDao.getListForMovie(movieId);
    }
}
