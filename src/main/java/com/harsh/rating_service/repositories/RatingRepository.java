package com.harsh.rating_service.repositories;

import com.harsh.rating_service.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating, String> {
    List<Rating> findAllByHotelId(String hotelId);

    List<Rating> findByUserId(String userId);
}
