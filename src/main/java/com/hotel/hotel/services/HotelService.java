package com.hotel.hotel.services;

import com.hotel.hotel.exceptions.ResourceNotFoundException;
import com.hotel.hotel.model.Hotel;
import com.hotel.hotel.repo.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    @Autowired
    HotelRepo hotelRepo;
    public List<Hotel> getAllHotels(){
        return hotelRepo.findAll();
    }
    public ResponseEntity<String> addhotel(Hotel hotel){
        hotelRepo.save(hotel);
        return new ResponseEntity<>("saved hotel", HttpStatus.CREATED);
    }
    public Hotel getHotelById(String hotelId){
        int id = Integer.parseInt(hotelId);
        return hotelRepo.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("User with given id is not found on server"+hotelId));
    }

    }

