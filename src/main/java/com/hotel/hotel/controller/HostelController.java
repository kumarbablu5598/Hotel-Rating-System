package com.hotel.hotel.controller;

import com.hotel.hotel.model.Hotel;
import com.hotel.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")

public class HostelController {
    @Autowired
    HotelService hotelService;

    @GetMapping("/getall")
    public List<Hotel> getAll(){
        return hotelService.getAllHotels();
    }
    public ResponseEntity<String> addHotel(@RequestBody Hotel hotel){
        return hotelService.addhotel(hotel);
    }


}
