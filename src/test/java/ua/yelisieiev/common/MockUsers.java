package ua.yelisieiev.common;

import ua.yelisieiev.entity.User;

public class MockUsers {
    public static final User DARLIN_EDWARDS = getDarlinEdwards();
    public static final User GABRIEL_JACKSON = getGabrielJackson();

    private static User getDarlinEdwards() {
        return User.builder()
                .id(3)
                .nickname("Дарлин Эдвардс")
                .build();
    }

    private static User getGabrielJackson() {
        return User.builder()
                .id(4)
                .nickname("Габриэль Джексон")
                .build();
    }
}
