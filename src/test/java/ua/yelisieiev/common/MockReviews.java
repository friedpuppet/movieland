package ua.yelisieiev.common;

import ua.yelisieiev.entity.Review;

import static ua.yelisieiev.common.MockUsers.DARLIN_EDWARDS;
import static ua.yelisieiev.common.MockUsers.GABRIEL_JACKSON;

public class MockReviews {
    public static final Review SHAWSHANK_REVIEW_1_FULL = getShawshank1();
    public static final Review SHAWSHANK_REVIEW_2_FULL = getShawshank2();

    private static Review getShawshank1() {
        return Review.builder()
                .id(1)
                .user(DARLIN_EDWARDS)
                .text("Гениальное кино! Смотришь и думаешь «Так не бывает!», но позже понимаешь, что только так и должно быть. Начинаешь заново осмысливать значение фразы, которую постоянно используешь в своей жизни, «Надежда умирает последней». Ведь если ты не надеешься, то все в твоей жизни гаснет, не остается смысла. Фильм наполнен бесконечным числом правильных афоризмов. Я уверена, что буду пересматривать его сотни раз.")
                .build();
    }

    private static Review getShawshank2() {
        return Review.builder()
                .id(2)
                .user(GABRIEL_JACKSON)
                .text("Кино это является, безусловно, «со знаком качества». Что же до первого места в рейтинге, то, думаю, здесь имело место быть выставление «десяточек» от большинства зрителей вкупе с раздутыми восторженными откликами кинокритиков. Фильм атмосферный. Он драматичный. И, конечно, заслуживает того, чтобы находиться довольно высоко в мировом кинематографе.")
                .build();
    }
}
