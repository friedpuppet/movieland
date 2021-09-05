package ua.yelisieiev.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.yelisieiev.dao.GenreDao;
import ua.yelisieiev.entity.Genre;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultGenreService implements GenreService {
    private final GenreDao genreDao;

    @Override
    public List<Genre> getAll() {
        log.info("Get all genres request received");
        return genreDao.getAll();
    }
}
