package com.harsh.rating_service.services;

import com.harsh.rating_service.entities.Rating;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RatingService {
    // create
    Rating create(Rating rating);
    // getAll
    List<Rating> getRatings();
    // getByUserId
    Rating getRatingByRatingId(String ratingId);
    // get all by hotelId
    List<Rating> getRatingByHotelId(String hotelId);

    List<Rating> getRatingByUserId(String userId);

}
