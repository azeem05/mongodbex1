package com.example.mongodbex1.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongodbex1.dto.MovieDTO;
import com.example.mongodbex1.repository.Movie;
import com.example.mongodbex1.service.SampleService;

@RestController
@RequestMapping("/sample")
public class SampleController {
    
    @Autowired
    SampleService sampleService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/{title}")
    public ResponseEntity findMovieByTitle(@PathVariable String title){
        Movie movie= sampleService.findMovieByTitle(title);
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/similar/{titleRegEx}")
    public  ResponseEntity findMoviesByTitleRegEx(@PathVariable String titleRegEx){
        List<MovieDTO> movies =sampleService.findMoviesByTitleRegEx(titleRegEx);
        ResponseEntity responseEntity = ResponseEntity.ok(movies);
        return responseEntity;
    }

    @GetMapping("/similar/findone/{title}")
    public ResponseEntity findOneMovieByTitle(@PathVariable String title){
        Movie movie = sampleService.findOneMovieByTitle(title);
        ResponseEntity responseEntity=ResponseEntity.ok(movie);
        return responseEntity;
    }

    @PutMapping("/save")
    public ResponseEntity saveMovie(@RequestParam String title){
        System.out.println("Title==="+title);
        Movie movie = sampleService.saveMovie(title);
        return ResponseEntity.ok(movie);
    }
    
}
