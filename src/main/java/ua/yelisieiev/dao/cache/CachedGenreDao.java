package ua.yelisieiev.dao.cache;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import ua.yelisieiev.dao.GenreDao;
import ua.yelisieiev.entity.Genre;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CachedGenreDao implements GenreDao {
    private static final int UPDATE_INTERVAL_MINUTES = 4 * 60;
    private final GenreDao targetDao;
    private List<Genre> cache;
    @Setter
    private LocalDateTime nextUpdateTime = LocalDateTime.now();

    @Override
    public List<Genre> getAll() {
        if (cache == null || LocalDateTime.now().isAfter(nextUpdateTime)) {
            log.info("Refreshing cache");
            cache = targetDao.getAll();
            nextUpdateTime = LocalDateTime.now().plusMinutes(UPDATE_INTERVAL_MINUTES);
        }
        return cache;
    }
}
