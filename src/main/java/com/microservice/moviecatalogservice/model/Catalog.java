/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.microservice.moviecatalogservice.model;

/**
 *
 * @author Dell
 */
public class Catalog {
    
    private String movieName;
    private String movieDesc;
    private int rating;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDesc() {
        return movieDesc;
    }

    public void setMovieDesc(String movieDesc) {
        this.movieDesc = movieDesc;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    
    
}
