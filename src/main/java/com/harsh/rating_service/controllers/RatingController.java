package com.harsh.rating_service.controllers;

import com.harsh.rating_service.entities.Rating;
import com.harsh.rating_service.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RatingController {
    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping("/ratings")
    public ResponseEntity<Rating> addRating(
            @RequestBody
            Rating rating
    ) {
        return new ResponseEntity<>(ratingService.create(rating), HttpStatus.CREATED);
    }

    @GetMapping("/ratings/{ratingId}")
    public ResponseEntity<Rating> getRating(
            @PathVariable String ratingId
    ) {
        return new ResponseEntity<>(ratingService.getRatingByRatingId(ratingId), HttpStatus.FOUND);
    }

    @GetMapping("/ratings")
    public ResponseEntity<List<Rating>> getRatings() {
        return new ResponseEntity<>(ratingService.getRatings(), HttpStatus.FOUND);
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(
            @PathVariable
            String hotelId
    ) {
        return new ResponseEntity<>(ratingService.getRatingByHotelId(hotelId), HttpStatus.FOUND);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(
            @PathVariable
            String userId
    ) {
        return new ResponseEntity<>(ratingService.getRatingByUserId(userId), HttpStatus.FOUND);
    }

}
