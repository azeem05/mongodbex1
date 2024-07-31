package com.example.mongodbex1.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.mongodbex1.dto.MovieDTO;
import com.example.mongodbex1.repository.Movie;
import com.example.mongodbex1.repository.SampleRepository;
import com.example.mongodbex1.util.ModelMapperConvertor;

@Service
public class SampleService {

    @Autowired
    SampleRepository sampleRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ModelMapperConvertor modelMapperConvertor;

    //ModelMapper modelMapper;

    public Movie findMovieByTitle(String title){
        Movie movie = sampleRepository.findMovieByTitle(title);
        System.out.println("Movie="+movie);
        return movie;
    }

    public List<MovieDTO> findMoviesByTitleRegEx(String titleRegEx){
        List<Movie> movies = sampleRepository.findMoviesByTitleRegEx(titleRegEx);   
        modelMapper.typeMap(Movie.class, MovieDTO.class)
        .addMappings(mapper -> 
            mapper.using(modelMapperConvertor).map(Movie::getTitle,MovieDTO::setTitleInUpperCase)
        );
        return movies.stream().map(movie -> modelMapper.map(movie,MovieDTO.class)).toList();
    }

    public Movie findOneMovieByTitle(String title){
        Movie mov=new Movie();
        mov.setTitle(title);
        
        Optional<Movie> movie = sampleRepository.findOne(Example.of(mov));
        return movie.isPresent()? movie.get():null;
        
    }

    public Movie saveMovie(String title){

        Movie mov=new Movie();
        mov.setTitle(title);
        mov.setPlot("plot");

        System.out.println("Movie that is saved="+mov);

        sampleRepository.save(mov);
        return mov;

    }
}
