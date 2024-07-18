package com.skillstorm.spring_data_jpa.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.spring_data_jpa.models.Movie;
import com.skillstorm.spring_data_jpa.repositories.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieRepository repo;

    // Use dependency injection to get an instance of the MovieRepository
    @Autowired // Not required when there is only one constructor
    public MovieController(MovieRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/hello")
    public String HelloWorld() {
        return "Hello World!";
    }

    // Get all movies
    @GetMapping("/movies")
    public Iterable<Movie> getAllMovies(@RequestParam String param) {
        return repo.findAll();
    }

    // Get movies by ID
    @GetMapping()
    public ResponseEntity<Movie> getMovieByID(@PathVariable int id) {
        Optional<Movie> movie = repo.findById(id);
        if (movie.isPresent()) {
            return ResponseEntity.ok(movie.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Post a new movie
    @PostMapping()
    public ResponseEntity<Movie> createMovie(@PathVariable int id, @RequestBody Movie movie) {

        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    // Put mapping
    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable int id, @RequestBody Movie movie) {

        return new ResponseEntity<Movie>(HttpStatus.OK);
    }

    // Delete mapping
    @DeleteMapping("/{id}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable int id, @RequestBody Movie movie) {

        return new ResponseEntity<Movie>(HttpStatus.NO_CONTENT);
    }
}
