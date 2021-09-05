package ua.yelisieiev.common;

import ua.yelisieiev.entity.Genre;

public class MockGenresFactory {
    public static Genre getGenre(String name) {
        switch (name) {
            case "драма":
                return new Genre(1, "драма");
            case "криминал":
                return new Genre(2, "криминал");
            case "фэнтези":
                return new Genre(3, "фэнтези");
            case "детектив":
                return new Genre(4, "детектив");
            default:
                throw new IllegalArgumentException();
        }
    }
}
