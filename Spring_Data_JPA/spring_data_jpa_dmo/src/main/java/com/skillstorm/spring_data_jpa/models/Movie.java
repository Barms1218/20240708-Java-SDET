package com.skillstorm.spring_data_jpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "movies") // Optional if name of database matches name of class - CASE SENSITIVE
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // strategies : IDENTITY not AUTO
    private int id;

    @Column(length = 50)
    private String movieTitle;

    @Min(value = 0)
    @Max(value = 10)
    private int rating;

    public Movie(int id, String movieTitle, @Min(0) @Max(10) int rating) {
        this.id = id;
        this.movieTitle = movieTitle;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    // Don't add the foreign id column;

}
