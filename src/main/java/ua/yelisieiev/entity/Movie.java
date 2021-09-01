package ua.yelisieiev.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {
    private int id;
    private String name_russian;
    private String name_native;
    private LocalDate year_of_release;
    private String description;
    private double rating;
    private double price;
    private String picture_path;
    private int votes;
}
