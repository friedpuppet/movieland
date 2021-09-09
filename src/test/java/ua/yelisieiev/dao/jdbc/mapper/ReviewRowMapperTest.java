package ua.yelisieiev.dao.jdbc.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ua.yelisieiev.entity.Genre;
import ua.yelisieiev.entity.Review;
import ua.yelisieiev.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ReviewRowMapperTest {
    ReviewRowMapper reviewRowMapper = new ReviewRowMapper();
    ResultSet resultSet = mock(ResultSet.class);

    @DisplayName("On mocked resultset - get Genre")
    @Test
    void mapRow() throws SQLException {
        when(resultSet.getInt("id")).thenReturn(1);
        when(resultSet.getString("description")).thenReturn("Гениальное кино! Смотришь и думаешь «Так не бывает!», но позже понимаешь, что только так и должно быть. Начинаешь заново осмысливать значение фразы, которую постоянно используешь в своей жизни, «Надежда умирает последней». Ведь если ты не надеешься, то все в твоей жизни гаснет, не остается смысла. Фильм наполнен бесконечным числом правильных афоризмов. Я уверена, что буду пересматривать его сотни раз.");
        when(resultSet.getInt("user_id")).thenReturn(3);
        when(resultSet.getString("nickname")).thenReturn("Дарлин Эдвардс");

        Review review = reviewRowMapper.mapRow(resultSet, 1);

        assertNotNull(review);
        assertEquals(1, review.getId());
        assertEquals("Гениальное кино! Смотришь и думаешь «Так не бывает!», но позже понимаешь, что только так и должно быть. Начинаешь заново осмысливать значение фразы, которую постоянно используешь в своей жизни, «Надежда умирает последней». Ведь если ты не надеешься, то все в твоей жизни гаснет, не остается смысла. Фильм наполнен бесконечным числом правильных афоризмов. Я уверена, что буду пересматривать его сотни раз.",
                review.getText());
        assertEquals(3, review.getUser().getId());
        assertEquals("Дарлин Эдвардс", review.getUser().getNickname());
    }
}