/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.microservice.moviecatalogservice.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class UserRatingResponseBean {
    
    private List<UserRating> userRatings = new ArrayList<>();

    public List<UserRating> getUserRatings() {
        return userRatings;
    }

    public void setUserRatings(List<UserRating> userRatings) {
        this.userRatings = userRatings;
    }
    
}
