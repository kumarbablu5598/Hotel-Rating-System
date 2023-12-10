package com.rating.rating.service;

import com.rating.rating.model.Rating;
import com.rating.rating.repo.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    RatingRepo ratingRepo;
    public List<Rating> getAll(){
        return ratingRepo.findAll();
    }
    public ResponseEntity<String> addRating(Rating rating){
        ratingRepo.save(rating);
        return new ResponseEntity<>("saved rating", HttpStatus.CREATED);
    }
    public List<Rating> getByUserId(String userId){
        return ratingRepo.findByUserId(userId);
    }
    public List<Rating> getByRatingId(String ratingId){
        return ratingRepo.findByRatingId(ratingId);
    }
    public List<Rating> getByHostelId(String hotelId){
        return ratingRepo.findByHotelId(hotelId);
    }
}
