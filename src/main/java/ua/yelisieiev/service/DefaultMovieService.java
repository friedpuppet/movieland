package ua.yelisieiev.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ua.yelisieiev.dao.MovieDao;
import ua.yelisieiev.entity.*;

import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultMovieService implements MovieService {
    private static final int DEFAULT_ENRICHMENT_TIMEOUT_MS = 5000;
    @Value("movie.enrichment.parallel.timeout")
    private int EnrichmentTimeout = DEFAULT_ENRICHMENT_TIMEOUT_MS;
    private final MovieDao movieDao;
    private final CountryService countryService;
    private final GenreService genreService;
    private final ReviewService reviewService;
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    @RequiredArgsConstructor
    private static class FieldFetcherThread<T> implements Callable<T> {
        private final Supplier<T> supplier;
        private final CountDownLatch latch;

        @Override
        public T call() {
            T value = supplier.get();
            latch.countDown();
            //todo it's possible than the latch is open but the value isn't returned yet
            // it's considered a timeout with current implementation
            return value;
        }
    }

    @RequiredArgsConstructor
    @Slf4j
    private class FieldFetcher<T> {
        private final Supplier<T> supplier;
        private final CountDownLatch latch;
        private Future<T> future;

        public void run() {
            future = executorService.submit(
                    new FieldFetcherThread<>(supplier, latch));
        }

        public T get() {
            if (future.isDone()) {
                try {
                    return future.get();
                } catch (InterruptedException e) {
                    log.warn("Field fetch was interrupted", e);
                } catch (ExecutionException e) {
                    log.warn("Field fetch unsuccessful", e);
                }
            }
            future.cancel(true);
            return null;
        }
    }

    @Override
    public List<Movie> getAll() {
        log.info("Get all movies request received");
        return movieDao.getAll();
    }

    @Override
    public List<Movie> getAllSorted(String sortedAttribute, String sortingType) {
        return movieDao.getAllSorted(sortedAttribute, sortingType);
    }

    @Override
    public List<Movie> getRandomMovies(int count) {
        log.info("Get {} random movies request received", count);
        return movieDao.getRandoms(count);
    }

    @Override
    public List<Movie> getMoviesByGenre(int genreId) {
        log.info("Get movies for genre {} request received", genreId);
        return movieDao.getMoviesByGenre(genreId);
    }

    @Override
    public List<Movie> getMoviesByGenreSorted(int genreId, String sortedAttribute, String sortingType) {
        return movieDao.getMoviesByGenreSorted(genreId, sortedAttribute, sortingType);
    }

    @Override
    public MovieFull getSingle(int id) {
        MovieFull movieFull = movieDao.getSingle(id);

        CountDownLatch latch = new CountDownLatch(3);

        FieldFetcher<List<Country>> countriesFetcher = new FieldFetcher<>(() -> countryService.getListForMovie(id), latch);
        countriesFetcher.run();

        FieldFetcher<List<Genre>> genresFetcher = new FieldFetcher<>(() -> genreService.getListForMovie(id), latch);
        genresFetcher.run();

        FieldFetcher<List<Review>> reviewsFetcher = new FieldFetcher<>(() -> reviewService.getListForMovie(id), latch);
        reviewsFetcher.run();

        try {
            if (!latch.await(EnrichmentTimeout, TimeUnit.MILLISECONDS)) {
                log.warn("Parallel enrichment timed out. Will try to enrich entity with what is available");
            }
        } catch (InterruptedException e) {
            log.warn("Parallel enrichment was interrupted. Will try to enrich entity with what is available", e);
        }

        movieFull.setCountries(countriesFetcher.get());
        movieFull.setGenres(genresFetcher.get());
        movieFull.setReviews(reviewsFetcher.get());

        return movieFull;
    }
}
