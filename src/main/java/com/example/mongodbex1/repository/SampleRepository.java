package com.example.mongodbex1.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public  interface  SampleRepository extends MongoRepository<Movie, String> {
    
    @Query("{title: '?0' }")
    Movie findMovieByTitle(String title);

    @Query("{title: {'$regex':'?0'}}")
    List<Movie> findMoviesByTitleRegEx(String titleRegEx);

}