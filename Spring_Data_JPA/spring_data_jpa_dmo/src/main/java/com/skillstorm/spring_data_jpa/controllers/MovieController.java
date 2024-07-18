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

    // use dependency injection to get an instance of the MovieRepository
    @Autowired // not required when there is only one constructor
    public MovieController(MovieRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello";
    }

    @GetMapping
    public Iterable<Movie> findAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> findById(@PathVariable int id) {
        Optional<Movie> movie = repo.findById(id);
        if (movie.isPresent())
            return ResponseEntity.ok(movie.get());
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public Movie create(@RequestBody Movie movie) {
        return null;
    }

    @PutMapping("/{id}")
    public String putMethodName(@PathVariable int id, @RequestBody Movie entity) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {

    }
}
