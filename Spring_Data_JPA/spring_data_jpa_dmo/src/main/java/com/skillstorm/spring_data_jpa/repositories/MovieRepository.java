package com.skillstorm.spring_data_jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.skillstorm.spring_data_jpa.models.Director;
import com.skillstorm.spring_data_jpa.models.Movie;

/*
 * CrudRepository - has methods for CRUD operations
 * 
 * PagingAndSortingRepository - extends CRUD operations with ability to specify
 * limit and offset of data returned
 * 
 * JpaRepository - extends PagingAndSortingRepository with more functionality
 * like flushing the persistence context
 */
public interface MovieRepository extends CrudRepository<Movie, Integer> {

    @Query(value = "select m from Movie m ORDER BY rating LIMIT 3", nativeQuery = false)
    List<Movie> findTop3();

    List<Movie> findByDirector(Director director);
}
