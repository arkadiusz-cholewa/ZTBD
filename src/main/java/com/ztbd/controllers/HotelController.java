package com.ztbd.controllers;

import com.ztbd.models.Hotel;
import com.ztbd.models.Room;
import com.ztbd.repositories.HotelRepository;
import com.ztbd.repositories.RoomRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private HotelRepository hotelRepository;

    public HotelController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getHotelById(@PathVariable("id") Long id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel", "id", id));;
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> list = hotelRepository.findAll();
        return new ResponseEntity<List<Hotel>>(list, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Void> addHotel(@RequestBody Hotel hotel) {
        hotelRepository.saveAndFlush(hotel);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel) {
        hotelRepository.save(hotel);
        return new ResponseEntity<Hotel>(hotel, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable("id") Long id) {
        hotelRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
