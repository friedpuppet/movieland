package ua.yelisieiev.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieFull {
    private int id;
    private String nameRussian;
    private String nameNative;
    @JsonFormat(pattern = "yyyy")
    private LocalDate yearOfRelease;
    private double rating;
    private double price;
    private String picturePath;
    private String description;
    private List<Genre> genres;
    private List<Country> countries;
    private List<Review> reviews;
}
