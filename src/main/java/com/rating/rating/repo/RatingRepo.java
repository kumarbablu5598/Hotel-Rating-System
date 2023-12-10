package com.rating.rating.repo;

import com.rating.rating.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepo extends JpaRepository<Rating,Integer> {
    List<Rating> findByHotelId(String  hotelId);
    List<Rating> findByRatingId(String ratingId);
    List<Rating> findByUserId(String userId);

}
