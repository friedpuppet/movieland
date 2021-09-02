package ua.yelisieiev.common;

import ua.yelisieiev.entity.Movie;

import java.time.LocalDate;

public class MockMoviesFactory {
    public static Movie getshawshankRedemption() {
        return Movie.builder()
                .id(1)
                .nameNative("The Shawshank Redemption")
                .nameRussian("Побег из Шоушенка")
                .yearOfRelease(LocalDate.of(1994, 1, 1))
                .build();
    }

    public static Movie getGreenMile() {
        return Movie.builder()
                .id(2)
                .nameNative("The Green Mile")
                .nameRussian("Зеленая миля")
                .yearOfRelease(LocalDate.of(1999, 1, 1))
                .build();
    }

    public static Movie getForrestGump() {
        return Movie.builder()
                .id(3)
                .nameNative("Forrest Gump")
                .nameRussian("Форрест Гамп")
                .yearOfRelease(LocalDate.of(1994, 1, 1))
                .build();
    }

    public static Movie getInception() {
        return Movie.builder()
                .id(6)
                .nameNative("Inception")
                .nameRussian("Начало")
                .yearOfRelease(LocalDate.of(2010, 1, 1))
                .build();
    }


}
