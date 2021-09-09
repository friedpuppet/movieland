package ua.yelisieiev.common;

import ua.yelisieiev.entity.Country;
import ua.yelisieiev.entity.Movie;
import ua.yelisieiev.entity.MovieFull;

import java.time.LocalDate;
import java.util.List;

import static ua.yelisieiev.common.MockCountries.USA;
import static ua.yelisieiev.common.MockGenres.CRIMINAL;
import static ua.yelisieiev.common.MockGenres.DRAMA;
import static ua.yelisieiev.common.MockReviews.SHAWSHANK_REVIEW_1_FULL;
import static ua.yelisieiev.common.MockReviews.SHAWSHANK_REVIEW_2_FULL;

public class MockMovies {
    public static final MovieFull SHAWSHANK_REDEMPTION_FULL = getShawshankRedemptionFull();
    public static final MovieFull SHAWSHANK_REDEMPTION_FULL_NOT_ENRICHED = getShawshankRedemptionFullNotEnriched();
    public static final Movie SHAWSHANK_REDEMPTION = getshawshankRedemption();
    public static final Movie GREEN_MILE = getGreenMile();
    public static final Movie FORREST_GUMP = getForrestGump();
    public static final Movie INCEPTION = getInception();
    public static final Movie SNATCH = getSnatch();

    private static Movie getshawshankRedemption() {
        return Movie.builder()
                .id(1)
                .nameNative("The Shawshank Redemption")
                .nameRussian("Побег из Шоушенка")
                .yearOfRelease(LocalDate.of(1994, 1, 1))
                .rating(8.9)
                .price(123.45)
                .picturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1._SY209_CR0,0,140,209_.jpg")
                .build();
    }

    public static MovieFull getShawshankRedemptionFullNotEnriched() {
        return MovieFull.builder()
                .id(1)
                .nameNative("The Shawshank Redemption")
                .nameRussian("Побег из Шоушенка")
                .yearOfRelease(LocalDate.of(1994, 1, 1))
                .rating(8.9)
                .price(123.45)
                .picturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1._SY209_CR0,0,140,209_.jpg")
                .description("Успешный банкир Энди Дюфрейн обвинен в убийстве собственной жены и ее любовника. Оказавшись в тюрьме под названием Шоушенк, он сталкивается с жестокостью и беззаконием, царящими по обе стороны решетки. Каждый, кто попадает в эти стены, становится их рабом до конца жизни. Но Энди, вооруженный живым умом и доброй душой, отказывается мириться с приговором судьбы и начинает разрабатывать невероятно дерзкий план своего освобождения.")
                .build();
    }

    private static MovieFull getShawshankRedemptionFull() {
        return MovieFull.builder()
                .id(1)
                .nameNative("The Shawshank Redemption")
                .nameRussian("Побег из Шоушенка")
                .yearOfRelease(LocalDate.of(1994, 1, 1))
                .rating(8.9)
                .price(123.45)
                .picturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1._SY209_CR0,0,140,209_.jpg")
                .description("Успешный банкир Энди Дюфрейн обвинен в убийстве собственной жены и ее любовника. Оказавшись в тюрьме под названием Шоушенк, он сталкивается с жестокостью и беззаконием, царящими по обе стороны решетки. Каждый, кто попадает в эти стены, становится их рабом до конца жизни. Но Энди, вооруженный живым умом и доброй душой, отказывается мириться с приговором судьбы и начинает разрабатывать невероятно дерзкий план своего освобождения.")
                .countries(List.of(USA))
                .genres(List.of(DRAMA, CRIMINAL))
                .reviews(List.of(SHAWSHANK_REVIEW_1_FULL, SHAWSHANK_REVIEW_2_FULL))
                .build();
    }

    private static Movie getGreenMile() {
        return Movie.builder()
                .id(2)
                .nameNative("The Green Mile")
                .nameRussian("Зеленая миля")
                .yearOfRelease(LocalDate.of(1999, 1, 1))
                .build();
    }

    private static Movie getForrestGump() {
        return Movie.builder()
                .id(3)
                .nameNative("Forrest Gump")
                .nameRussian("Форрест Гамп")
                .yearOfRelease(LocalDate.of(1994, 1, 1))
                .build();
    }

    private static Movie getInception() {
        return Movie.builder()
                .id(6)
                .nameNative("Inception")
                .nameRussian("Начало")
                .yearOfRelease(LocalDate.of(2010, 1, 1))
                .build();
    }

    private static Movie getSnatch() {
        return Movie.builder()
                .id(16)
                .nameNative("Snatch")
                .nameRussian("Большой куш")
                .yearOfRelease(LocalDate.of(2000, 1, 1))
                .build();
    }


}
