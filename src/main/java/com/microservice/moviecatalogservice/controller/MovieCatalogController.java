/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.microservice.moviecatalogservice.controller;

import com.microservice.moviecatalogservice.model.Catalog;
import com.microservice.moviecatalogservice.model.Movie;
import com.microservice.moviecatalogservice.model.UserRating;
import com.microservice.moviecatalogservice.model.UserRatingResponseBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Dell
 */
@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
    
    @Autowired
    private RestTemplate restTemplate;
    
    @GetMapping("/fetchCatalogList/{userId}")
    public List<Catalog> getCatalogDetailsList(@PathVariable("userId") String userId) {
        
        
        
        UserRatingResponseBean userResponseBean = restTemplate.getForObject("http://localhost:8083/user-rating/fetchUserRating/1", UserRatingResponseBean.class);
        System.out.println("userResponseBean :: "+userResponseBean);
        
        ResponseEntity<UserRating[]> responseEntity = restTemplate.getForEntity("http://localhost:8083/user-rating/fetchUserRatingList/1", UserRating[].class);
        
        List<UserRating> ratings = Arrays.asList(responseEntity.getBody());
        System.out.println("responseEntity :: "+ratings);
        
        List<Catalog> catalogs = ratings.stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://localhost:8082/movies/fetchMovieInfo/"+rating.getMovieId(), Movie.class);
            System.out.println("movie :: "+movie);
            Catalog catalog = new Catalog();
            catalog.setMovieName(movie.getMovieName());
            catalog.setMovieDesc(movie.getMovieDesc());
            catalog.setRating(rating.getRating());
            return catalog;
        })
        .collect(Collectors.toList());
        
        return catalogs;
    }
}
