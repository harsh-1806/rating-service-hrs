package com.harsh.rating_service.services.impl;

import com.harsh.rating_service.entities.Rating;
import com.harsh.rating_service.exceptions.ResourceNotFoundException;
import com.harsh.rating_service.repositories.RatingRepository;
import com.harsh.rating_service.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;

    @Autowired
    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Rating create(Rating rating) {
        rating.setRatingId(UUID.randomUUID().toString());
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating getRatingByRatingId(String userId) {
        return ratingRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Rating not found with userId : " + userId));
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepository.findAllByHotelId(hotelId);
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }


}
