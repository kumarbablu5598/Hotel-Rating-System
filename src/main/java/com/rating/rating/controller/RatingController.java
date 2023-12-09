package com.rating.rating.controller;

import com.rating.rating.model.Rating;
import com.rating.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    RatingService ratingService;

    @GetMapping("/getAll")
    public List<Rating> getAll(){
        return ratingService.getAll();
    }
    public ResponseEntity<String>  addRating(@RequestBody Rating rating){
       return ratingService.addRating(rating);
    }
}
