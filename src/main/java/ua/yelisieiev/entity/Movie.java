package ua.yelisieiev.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {
    private int id;
    private String nameRussian;
    private String nameNative;
    @JsonFormat(pattern = "yyyy")
    private LocalDate yearOfRelease;
    private double rating;
    private double price;
    private String picturePath;
}
